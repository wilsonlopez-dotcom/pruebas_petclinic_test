package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.repositories.VetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VetService {

    @Autowired
    private VetRepository vetRepository;

    public Vet create(Vet vet) {
        return vetRepository.save(vet);
    }

    public Vet update(Vet vet) {
        return vetRepository.save(vet);
    }

    public Optional<Vet> findById(Long id) {
        return vetRepository.findById(id);
    }

    public List<Vet> findAll() {
        return vetRepository.findAll();
    }

    public void delete(Long id) {
        vetRepository.deleteById(id);
    }
}