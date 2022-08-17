package br.univille.dacs2022.service.impl;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.dacs2022.dto.HealthPlanDTO;
import br.univille.coredacs2022.entity.HealthPlan;
import br.univille.dacs2022.mapper.HealthPlanMapper;
import br.univille.coredacs2022.repository.HealthPlanRepository;
import br.univille.dacs2022.service.HealthPlanService;

@Service
public class HealthPlanServiceImpl implements HealthPlanService {

    @Autowired
    private HealthPlanRepository repository;
    private HealthPlanMapper mapper = Mappers.getMapper(HealthPlanMapper.class);

    @Override
    public List<HealthPlanDTO> getAll() {
        List<HealthPlan> plans = repository.findAll();
        return mapper.mapListHealthPlan(plans);
    }

    @Override
    public HealthPlanDTO save(HealthPlanDTO plan) {
        HealthPlan healthPlan = mapper.mapHealthPlanDTO(plan);
        repository.save(healthPlan);
        
        return mapper.mapHealthPlan(healthPlan);
    }

    @Override
    public HealthPlanDTO findById(long id) {
        Optional<HealthPlan> plan = repository.findById(id);
        return mapper.mapHealthPlan(plan.get());
    }

    @Override
    public HealthPlanDTO delete(long id) {
        Optional<HealthPlan> planEntity = repository.findById(id);

        if(planEntity.isPresent()) {
            HealthPlan healthPlan = planEntity.get();
            repository.delete(healthPlan);
            return mapper.mapHealthPlan(healthPlan);
        }

        return null;
    }
    
}
