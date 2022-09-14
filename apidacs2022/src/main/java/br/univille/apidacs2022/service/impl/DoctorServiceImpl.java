package br.univille.apidacs2022.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.apidacs2022.service.DoctorServiceAPI;
import br.univille.coredacs2022.entity.Doctor;
import br.univille.coredacs2022.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorServiceAPI {

    @Autowired
    private DoctorRepository repository;
    
    @Override
    public List<Doctor> getAll() {
        return repository.findAll();
    }

    @Override
    public Doctor save(Doctor doctor) {
        repository.save(doctor);
        return doctor;
    }

    @Override
    public Doctor findById(long id) {
        Optional<Doctor> doctor = repository.findById(id);

        if (doctor.isPresent()) {
            return doctor.get();
        }

        return null;
    }

    @Override
    public Doctor delete(long id) {
        Optional<Doctor> doctor = repository.findById(id);

        if (doctor.isPresent()) {
            repository.delete(doctor.get());
        }

        return null;
    }

    @Override
    public List<Doctor> getByName(String name) {
        return repository.findByNameIgnoreCaseContaining(name);
    }

}
