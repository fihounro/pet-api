package bj.finance.petapi.controllers.api;

import bj.finance.petapi.dto.PetDto;
import bj.finance.petapi.jpa.PetServiceJpa;
import bj.finance.petapi.model.Pet;
import bj.finance.petapi.services.MapValidationErrorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("api/pets")
public class PetApiController {

    private final PetServiceJpa petService;
    private final MapValidationErrorService mapValidationErrorService;

    public PetApiController(PetServiceJpa petService, MapValidationErrorService mapValidationErrorService) {
        this.petService = petService;
        this.mapValidationErrorService = mapValidationErrorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getOnePet(@PathVariable("id") Long id){

        Pet pet = petService.getOnePet(id);

        if(pet != null){
            return new ResponseEntity<>(pet, HttpStatus.ACCEPTED);
        }
        else {
            return new ResponseEntity<>(new Pet(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping({"", "/"})
    public ResponseEntity<?> createOnePet(@Valid @RequestBody PetDto petDto, BindingResult bindingResult){

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(bindingResult);
        if (errorMap != null) return errorMap;

        Pet savedPet = petService.savePet(petDto);

        return new ResponseEntity<>(savedPet, HttpStatus.CREATED);

        /*
        if(pet != null){

        }
        else {
            return new ResponseEntity<>(new Pet(), HttpStatus.NOT_FOUND);
        }
        */
    }

    @GetMapping("/")
    public ResponseEntity<Set<Pet>> getAllPets(){
        return new ResponseEntity<>(petService.getAllPets(), HttpStatus.ACCEPTED);
    }
}
