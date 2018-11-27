package com.rjbdev.petclinicsfg.services.map;

import com.rjbdev.petclinicsfg.model.Specialty;
import com.rjbdev.petclinicsfg.model.Vet;
import com.rjbdev.petclinicsfg.services.SpecialtyService;
import com.rjbdev.petclinicsfg.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService <Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        //Using HashMaps and saving objects outside of JPA requires this step
        //to ensure unsaved objects are properly handled (this is determined
        //by the absence of IDs).
        if (object.getSpecialties().size() > 0){
            object.getSpecialties().forEach(specialty -> {
                if(specialty.getId() == null){
                    Specialty savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
