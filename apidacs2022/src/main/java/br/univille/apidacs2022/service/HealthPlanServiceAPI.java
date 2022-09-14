package br.univille.apidacs2022.service;

import java.util.List;

import br.univille.coredacs2022.entity.HealthPlan;

public interface HealthPlanServiceAPI {

    List<HealthPlan> getAll();
    HealthPlan save(HealthPlan healthPlan);
    HealthPlan findById(long id);
    HealthPlan delete(long id);
    List<HealthPlan> getByName(String name);
    
}
