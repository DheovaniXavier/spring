package br.univille.dacs2022.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.univille.dacs2022.dto.HealthPlanDTO;
import br.univille.coredacs2022.entity.HealthPlan;

@Mapper
public interface HealthPlanMapper {

    List<HealthPlanDTO> mapListHealthPlan(List<HealthPlan> healthPlans);
    List<HealthPlan> mapListHealthPlanDTO(List<HealthPlanDTO> healthPlans);

    HealthPlanDTO mapHealthPlan(HealthPlan healthPlan);
    HealthPlan mapHealthPlanDTO(HealthPlanDTO healthPlan);
        
}
