package com.rjbdev.petclinicsfg.repositories;

import com.rjbdev.petclinicsfg.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
