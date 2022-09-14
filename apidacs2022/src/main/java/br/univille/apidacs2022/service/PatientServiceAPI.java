package br.univille.apidacs2022.service;

import java.util.List;
import br.univille.coredacs2022.entity.Patient;

public interface PatientServiceAPI {

    List<Patient> getAll();
    Patient save(Patient patient);
    Patient findById(long id);
    Patient delete(long id);
    List<Patient> getByName(String name);

}