package br.univille.dacs2022.service;

import java.util.List;

import br.univille.dacs2022.dto.HealthPlanDTO;

public interface HealthPlanService {

    List<HealthPlanDTO> getAll();

    HealthPlanDTO findById(long id);
    
}
