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

import br.univille.apidacs2022.service.DoctorServiceAPI;
import br.univille.coredacs2022.entity.Doctor;

@RestController
@RequestMapping("api/v1/doctor")
public class DoctorControllerApi {

    @Autowired
    private DoctorServiceAPI service;

    @GetMapping
    public ResponseEntity<List<Doctor>> getAll() {
        List<Doctor> doctors = service.getAll();
        return new ResponseEntity<List<Doctor>>(doctors, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Doctor>> getByName(@PathVariable("name") String name) {
        List<Doctor> doctors = service.getByName(name);
        return new ResponseEntity<List<Doctor>>(doctors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getById(@PathVariable("id") long id) {
        Doctor doctor = service.findById(id);
        return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Doctor> insertDoctor(@RequestBody Doctor doctor) {
        if (doctor.getId() == 0) {
            service.save(doctor);
            return new ResponseEntity<Doctor>(doctor, HttpStatus.CREATED);
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(
        @RequestBody Doctor doctor,
        @PathVariable("id") long id
    ) {
        Doctor docEntity = service.findById(id);

        if (docEntity != null) {
            docEntity.setCrm(doctor.getCrm());
            docEntity.setName(doctor.getName());
            docEntity.setProcedures(doctor.getProcedures());
            service.save(docEntity);

            return new ResponseEntity<Doctor>(docEntity, HttpStatus.OK);
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Doctor> delete(@PathVariable("id") long id) {
        Doctor doctor = service.findById(id);

        if (doctor == null) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);
        return ResponseEntity.accepted().build();
    }

}
