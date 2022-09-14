package br.univille.dacs2022.service;

import java.util.List;

import br.univille.dacs2022.dto.DoctorDTO;

public interface DoctorService {

    List<DoctorDTO> getAll();

    DoctorDTO save(DoctorDTO doctor);
    
    DoctorDTO findById(long id);
    
    DoctorDTO delete(long id);
    
}
