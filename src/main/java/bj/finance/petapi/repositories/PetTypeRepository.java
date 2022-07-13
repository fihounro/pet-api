package bj.finance.petapi.repositories;

import bj.finance.petapi.model.Pet;
import bj.finance.petapi.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
