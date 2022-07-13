package bj.finance.petapi.repositories;

import bj.finance.petapi.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
