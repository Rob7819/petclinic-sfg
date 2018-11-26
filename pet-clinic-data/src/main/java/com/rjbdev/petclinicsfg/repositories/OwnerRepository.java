package com.rjbdev.petclinicsfg.repositories;

import com.rjbdev.petclinicsfg.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
