package com.rjbdev.petclinicsfg.services;

import com.rjbdev.petclinicsfg.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();

}
