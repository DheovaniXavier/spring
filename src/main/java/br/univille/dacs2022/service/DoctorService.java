package br.univille.dacs2022.service;

import java.util.List;

import br.univille.dacs2022.dto.DoctorDTO;

public interface DoctorService {

    public List<DoctorDTO> getAll();

    public DoctorDTO save(DoctorDTO doctor);
    
    public DoctorDTO findById(long id);
    
    public DoctorDTO delete(long id);
    
}
