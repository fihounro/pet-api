package bj.finance.petapi.config;

import bj.finance.petapi.repositories.PersonRepository;
import bj.finance.petapi.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final UserRepository userRepository;

    private final PersonRepository personRepository;

    private final PasswordEncoderProvider passwordEncoder;

    private UserDetailsService userDetailsService;

    public SecurityConfiguration(UserRepository userRepository, PersonRepository personRepository, PasswordEncoderProvider passwordEncoder, UserDetailsService userDetailsService) {
        this.userRepository = userRepository;
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsService);
        auth.setPasswordEncoder(passwordEncoder.passwordEncoder());

        return auth;
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{

          httpSecurity.authorizeHttpRequests()
                .antMatchers("/","/registration**",
                        "/static/**",
                        //"/swagger-ui/**",
                        "/webjars/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()//.loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();

          httpSecurity.headers().frameOptions().sameOrigin();

          return httpSecurity.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return web -> {
            web.ignoring().antMatchers();
        };
    }


}
