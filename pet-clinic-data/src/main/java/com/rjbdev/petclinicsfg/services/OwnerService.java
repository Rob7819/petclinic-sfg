package com.rjbdev.petclinicsfg.services;

import com.rjbdev.petclinicsfg.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName (String lastName);

}
