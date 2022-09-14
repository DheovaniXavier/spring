package br.univille.apidacs2022.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.apidacs2022.service.HealthPlanServiceAPI;
import br.univille.coredacs2022.entity.HealthPlan;

@RestController
@RequestMapping("/api/v1/healthplan")
public class HealthPlanControllerApi {

    @Autowired
    private HealthPlanServiceAPI service;

    @GetMapping
    public ResponseEntity<List<HealthPlan>> getAll() {
        List<HealthPlan> healthPlans = service.getAll();
        return new ResponseEntity<List<HealthPlan>>(healthPlans, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<HealthPlan>> getByName(@PathVariable("name") String name) {
        List<HealthPlan> healthPlans = service.getByName(name);
        return new ResponseEntity<List<HealthPlan>>(healthPlans, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthPlan> getById(@PathVariable("id") long id) {
        HealthPlan healthPlan = service.findById(id);
        return new ResponseEntity<HealthPlan>(healthPlan, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<HealthPlan> insertHealthPlan(@RequestBody HealthPlan healthPlan) {
        if (healthPlan.getId() == 0) {
            service.save(healthPlan);
            return new ResponseEntity<HealthPlan>(healthPlan, HttpStatus.CREATED);
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<HealthPlan> updateHealthPlan (
        @RequestBody HealthPlan healthPlan,
        @PathVariable("id") long id
    ) {
        HealthPlan healthPlanEntity = service.findById(id);

        if (healthPlanEntity != null) {
            healthPlanEntity.setName(healthPlan.getName());
            service.save(healthPlanEntity);

            return new ResponseEntity<HealthPlan>(healthPlanEntity, HttpStatus.OK);
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HealthPlan> delete(@PathVariable("id") long id) {
        HealthPlan healthPlan = service.findById(id);

        if (healthPlan == null) {
            return ResponseEntity.notFound().build();
        }
        
        service.delete(id);
        return ResponseEntity.accepted().build();
    }
    
}
