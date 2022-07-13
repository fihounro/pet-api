package bj.finance.petapi.services.security;


import bj.finance.petapi.config.PasswordEncoderProvider;
import bj.finance.petapi.dto.UserRegistrationDto;
import bj.finance.petapi.model.Person;
import bj.finance.petapi.model.security.Role;
import bj.finance.petapi.model.security.User;
import bj.finance.petapi.repositories.PersonRepository;
import bj.finance.petapi.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PersonRepository personRepository;
    private final PasswordEncoderProvider passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, PersonRepository personRepository, PasswordEncoderProvider passwordEncoder) {
        this.userRepository = userRepository;
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        Person person = null;


        if(registrationDto.getPersonId() != null && registrationDto.getPersonId() > 0 && userRepository.findById(registrationDto.getPersonId()).isPresent()) {
            person = personRepository.findById(registrationDto.getPersonId()).get();
        }
        else if(registrationDto.getPersonId() == null || registrationDto.getPersonId() == 0){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            //LocalDate date = LocalDate.parse(registrationDto.getBirthDate(), formatter);

            person = new Person();
            person.setFirstName(registrationDto.getFirstName());
            person.setLastName(registrationDto.getLastName());
            person.setGender(registrationDto.getGender());
            //person.setBirthDate(date);
        }

        Set<Role> roles = new HashSet<>();
        roles.add(new Role("ROLE_USER"));

        User user = new User(registrationDto.getUsername(),
                registrationDto.getEmail(),
                passwordEncoder.passwordEncoder().encode(registrationDto.getPassword())
                ,
                person, roles);

        userRepository.save(user);

        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User foundUser = userRepository.findByUsernameIgnoreCaseOrEmailIgnoreCase(username, username);

        if(foundUser == null){
            throw new UsernameNotFoundException("Invalid username/email or password.");
        }

        return new org.springframework.security.core.userdetails.User(foundUser.getUsername(), foundUser.getPassword(), mapRolesToAuthorities(foundUser.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){

      return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());
    }
}
