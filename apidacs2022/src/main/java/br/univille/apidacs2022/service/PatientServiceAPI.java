package br.univille.apidacs2022.service;

import java.util.List;
import br.univille.coredacs2022.entity.Patient;

public interface PatientServiceAPI {

    public List<Patient> getAll();
    public Patient save(Patient patient);
    public Patient findById(long id);
    public Patient delete(long id);
    public List<Patient> getByName(String name);

}