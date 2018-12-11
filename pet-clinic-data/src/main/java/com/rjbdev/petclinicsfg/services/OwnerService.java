package com.rjbdev.petclinicsfg.services;

import com.rjbdev.petclinicsfg.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName (String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

}
