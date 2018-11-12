package com.rjbdev.petclinicsfg.services;

import com.rjbdev.petclinicsfg.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();

}
