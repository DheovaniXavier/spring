package br.univille.apidacs2022.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.apidacs2022.service.HealthPlanServiceAPI;
import br.univille.coredacs2022.entity.HealthPlan;
import br.univille.coredacs2022.repository.HealthPlanRepository;

@Service
public class HealthPlanServiceImpl implements HealthPlanServiceAPI {

    @Autowired
    private HealthPlanRepository repository;

    @Override
    public List<HealthPlan> getAll() {
        return repository.findAll();
    }

    @Override
    public HealthPlan save(HealthPlan healthPlan) {
        repository.save(healthPlan);
        return healthPlan;
    }

    @Override
    public HealthPlan findById(long id) {
        Optional<HealthPlan> healthPlan = repository.findById(id);

        if (healthPlan.isPresent()) {
            return healthPlan.get();
        }

        return null;
    }

    @Override
    public HealthPlan delete(long id) {
        Optional<HealthPlan> healthPlan = repository.findById(id);

        if (healthPlan.isPresent()) {
            repository.delete(healthPlan.get());
        }

        return null;
    }

    @Override
    public List<HealthPlan> getByName(String name) {
        return repository.findByNameIgnoreCaseContaining(name);
    }
    
}
