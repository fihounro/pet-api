package bj.finance.petapi.jpa;

import bj.finance.petapi.dto.PetDto;
import bj.finance.petapi.model.Gender;
import bj.finance.petapi.model.Owner;
import bj.finance.petapi.model.Pet;
import bj.finance.petapi.model.PetType;
import bj.finance.petapi.repositories.OwnerRepository;
import bj.finance.petapi.repositories.PetRepository;
import bj.finance.petapi.repositories.PetTypeRepository;
import bj.finance.petapi.services.PetService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Primary
public class PetServiceJpa implements PetService {

    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    private final OwnerRepository ownerRepository;

    public PetServiceJpa(PetRepository petRepository, PetTypeRepository petTypeRepository, OwnerRepository ownerRepository) {
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
        this.ownerRepository = ownerRepository;
    }

    public Pet getOnePet(Long id){

        if(petRepository.findById(id).isPresent()){
            return petRepository.findById(id).get();
        }
        return null;
    };

    public Set<Pet> getAllPets(){

        Set<Pet> allPets = new HashSet<>();

        petRepository.findAll()
                .forEach(allPets::add);
        return allPets;
    }

    public Pet savePet(PetDto petDto) {

        Pet pet =new Pet();

        Optional<PetType> petType = petTypeRepository.findById(petDto.getPetTypeId());
        Optional<Owner> owner = ownerRepository.findById(petDto.getOwnerId());

        Gender gender;
        if(petDto.getGender().equals(Gender.MALE.name())){
            gender = Gender.MALE;
        }
        else if(petDto.getGender().equals(Gender.FEMALE.name())){
            gender = Gender.FEMALE;
        }
        else {
            throw new RuntimeException("Genre non pris en charge");
        }

        pet.setName(petDto.getName());
        pet.setGender(gender) ;
        pet.setBirthDate(LocalDate.now());

        if(owner.isPresent()){
            pet.setOwner(owner.get());
            owner.get().getPets().add(pet);
        }
        if(petType.isPresent()){
            pet.setPetType(petType.get());
            petType.get().getPets().add(pet);
        }

        petRepository.save(pet);

        return pet;
    }

    @Override
    public Set<Pet> findAll() {
        return null;
    }

    @Override
    public Pet findById(Long aLong) {
        return null;
    }

    @Override
    public Pet save(Pet object) {
        return null;
    }

    public void delete(Pet object) {

    }

    public void deleteById(Long aLong) {

    }
}
