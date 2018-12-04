package com.rjbdev.petclinicsfg.services.springdatajpa;

import com.rjbdev.petclinicsfg.model.Owner;
import com.rjbdev.petclinicsfg.repositories.OwnerRepository;
import com.rjbdev.petclinicsfg.repositories.PetRepository;
import com.rjbdev.petclinicsfg.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Smith";
    //@Mock marks the dependencies for OwnerSDJpaService
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    //Required for dependency injection, 'service' is our testing instance
    //for OwnerSDJpaService...
    @InjectMocks
    OwnerSDJpaService service;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {

        //Return test data (as created in setUp()) to this testing instance
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner smith = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, smith.getLastName());

        //verify that ownerRepository.findByLastName was called in this test
        //(ownerRepository is a defined dependency to be injected, so this may be tested)
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(Owner.builder().id(1L).build());
        returnOwnersSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        //ownerRepository.findById() returns an optional
        when(ownerRepository.findById(any())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        //ownerRepository.findById() returns an optional
        when(ownerRepository.findById(any())).thenReturn(Optional.empty());

        Owner owner = service.findById(1L);

        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        //add the behaviour of ownerRepository(necessary or we get null error)
        when(ownerRepository.save(any())).thenReturn(ownerToSave);

        Owner owner = service.save(ownerToSave);

        assertNotNull(owner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnOwner);

        //default is 1 so specifying times is not necessary
        verify(ownerRepository,times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        //default is 1 so specifying times is not necessary
        verify(ownerRepository,times(1)).deleteById(anyLong());
    }
}