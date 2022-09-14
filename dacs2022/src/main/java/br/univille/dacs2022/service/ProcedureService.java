package br.univille.dacs2022.service;

import java.util.List;

import br.univille.dacs2022.dto.ProcedureDTO;

public interface ProcedureService {

    List<ProcedureDTO> getAll();

    ProcedureDTO save(ProcedureDTO procedure);
    
    ProcedureDTO findById(long id);
    
    ProcedureDTO delete(long id);
    
}
