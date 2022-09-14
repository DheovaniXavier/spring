package br.univille.apidacs2022.service;

import java.util.List;

import br.univille.coredacs2022.entity.Doctor;

public interface DoctorServiceAPI {
    
    List<Doctor> getAll();
    Doctor save(Doctor doctor);
    Doctor findById(long id);
    Doctor delete(long id);
    List<Doctor> getByName(String name);

}
