package br.univille.dacs2022.service;

import java.util.List;

import br.univille.dacs2022.dto.PatientDTO;

public interface PatientService {

    List<PatientDTO> getAll();

    PatientDTO save(PatientDTO patient);
    
    PatientDTO findById(long id);
    
    PatientDTO delete(long id);
    
}
