package br.univille.dacs2022.service;

import java.util.List;

import br.univille.dacs2022.dto.ProcedureDTO;

public interface ProcedureService {

    public List<ProcedureDTO> getAll();

    public ProcedureDTO save(ProcedureDTO procedure);
    
    public ProcedureDTO findById(long id);
    
    public ProcedureDTO delete(long id);
    
}
