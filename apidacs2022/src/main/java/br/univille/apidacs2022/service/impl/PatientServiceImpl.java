package br.univille.apidacs2022.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.apidacs2022.service.PatientServiceAPI;
import br.univille.coredacs2022.entity.Patient;
import br.univille.coredacs2022.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientServiceAPI {

    @Autowired
    private PatientRepository repository;

    @Override
    public List<Patient> getAll() {
        return repository.findAll();
    }

    @Override
    public Patient save(Patient patient) {
        repository.save(patient);
        return patient;
    }

    @Override
    public Patient findById(long id) {
        Optional<Patient> patient = repository.findById(id);
        
        if (patient.isPresent()) {
            return patient.get();
        }

        return null;
    }
    
    @Override
    public Patient delete(long id) {
        Optional<Patient> patient = repository.findById(id);
        
        if (patient.isPresent()) {
            repository.delete(patient.get());
        }

        return null;
    }

    @Override
    public List<Patient> getByName(String name) {
        return repository.findByNameIgnoreCaseContaining(name);
    }  

}
