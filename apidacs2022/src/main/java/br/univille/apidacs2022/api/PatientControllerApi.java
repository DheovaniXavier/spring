package br.univille.apidacs2022.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.apidacs2022.service.PatientServiceAPI;
import br.univille.coredacs2022.entity.Patient;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientControllerApi {

    @Autowired
    private PatientServiceAPI service;

    @GetMapping
    public ResponseEntity<List<Patient>> getAll() {
        List<Patient> patients = service.getAll();
        return new ResponseEntity<List<Patient>>(patients, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Patient> insertPatient(@RequestBody Patient patient) {
        service.save(patient);
        return new ResponseEntity<Patient>(patient, HttpStatus.CREATED);
    }
    
}
