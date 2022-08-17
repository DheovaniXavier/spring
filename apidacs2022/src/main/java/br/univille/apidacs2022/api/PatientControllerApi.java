package br.univille.apidacs2022.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.coredacs2022.entity.Patient;
import br.univille.coredacs2022.repository.PatientRepository;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientControllerApi {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping
    public ResponseEntity<List<Patient>> getAll() {
        List<Patient> patients = patientRepository.findAll();
        return new ResponseEntity<List<Patient>>(patients, HttpStatus.OK);
    }
    
}
