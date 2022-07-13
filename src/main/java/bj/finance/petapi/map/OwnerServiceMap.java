package bj.finance.petapi.map;

import bj.finance.petapi.model.Owner;
import bj.finance.petapi.model.Pet;
import bj.finance.petapi.model.PetType;
import bj.finance.petapi.services.OwnerService;
import bj.finance.petapi.services.PetService;
import bj.finance.petapi.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {


        if(object != null){
            /*
            if(object.getPets() != null){

                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            //save the PetType
                            PetType savedPestType = petTypeService.save(pet.getPetType());
                            // adding relationship with ID
                            pet.setPetType(savedPestType);
                        }
                    }
                    else {
                        throw new RuntimeException("Pet Type is required");
                    }

                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }

                });

            }

         */
            return super.save(object);
        }
        else {
            return null;
        }
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Set<Owner> findByLastName(String lastName) {
        return null;
    }
}
