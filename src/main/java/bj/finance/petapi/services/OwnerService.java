package bj.finance.petapi.services;

import bj.finance.petapi.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {
    Set<Owner> findByLastName(String lastName);
}
