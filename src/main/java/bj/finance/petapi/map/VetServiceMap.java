package bj.finance.petapi.map;


import bj.finance.petapi.model.Specialty;
import bj.finance.petapi.model.Vet;
import bj.finance.petapi.services.SpecialtyService;
import bj.finance.petapi.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {

        if(object.getId() != null){
            if(object.getSpecialties().size() >0){
                object.getSpecialties().forEach(specialty -> {
                    if(specialty.getId() == null){
                        Specialty savedSpe = specialtyService.save(specialty);
                        specialty.setId(savedSpe.getId());
                    }
                });
            }
            return super.save(object);
        }
        return null;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
