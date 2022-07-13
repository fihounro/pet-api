package bj.finance.petapi.repositories;

import bj.finance.petapi.model.Owner;
import bj.finance.petapi.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
