package com.tecsup.petclinic.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.tecsup.petclinic.repositories.OwnerRepository;
import com.tecsup.petclinic.entities.Owner;
import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public Owner create(Owner owner) {
        return ownerRepository.save(owner);
    }

    public Owner update(Owner owner) {
        return ownerRepository.save(owner);
    }

    public void delete(Integer id) {
        ownerRepository.deleteById(id);
    }

    public Owner findById(Integer id) {
        return ownerRepository.findById(id).orElse(null);
    }

    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }
}
