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

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Patient>> getByName(@PathVariable("name") String name) {
        List<Patient> patients = service.getByName(name);
        return new ResponseEntity<List<Patient>>(patients, HttpStatus.OK);
    }

    // @GetMapping
    // public ResponseEntity<List<Patient>> getByName2(@RequestParam("name") String name) {
    //     List<Patient> patients = service.getByName(name);
    //     return new ResponseEntity<List<Patient>>(patients, HttpStatus.OK);
    // }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getById(@PathVariable("id") long id) {
        Patient patient = service.findById(id);
        return new ResponseEntity<Patient>(patient, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Patient> insertPatient(@RequestBody Patient patient) {
        if (patient.getId() == 0) {
            service.save(patient);
            return new ResponseEntity<Patient>(patient, HttpStatus.CREATED);
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(
        @RequestBody Patient patient,
        @PathVariable("id") long id
    ) {
        Patient patientEntity = service.findById(id);

        if (patientEntity != null) {
            patientEntity.setName(patient.getName());
            patientEntity.setSex(patient.getSex());
            patientEntity.setBirthDate(patient.getBirthDate());
            patientEntity.setCity(patient.getCity());
            patientEntity.setPlans(patient.getPlans());
            service.save(patientEntity);

            return new ResponseEntity<Patient>(patientEntity, HttpStatus.OK);
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Patient> delete(@PathVariable("id") long id) {
        Patient patient = service.findById(id);

        if (patient == null) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);
        return ResponseEntity.accepted().build();
    }
    
}
