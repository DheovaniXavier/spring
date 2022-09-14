package br.univille.apidacs2022.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.apidacs2022.service.ProcedureServiceAPI;
import br.univille.coredacs2022.entity.Procedure;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/procedure")
public class ProcedureControllerApi {

    @Autowired
    private ProcedureServiceAPI service;

    @GetMapping
    public ResponseEntity<List<Procedure>> getAll() {
        List<Procedure> procedures = service.getAll();
        return new ResponseEntity<>(procedures, HttpStatus.OK);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Procedure>> getByTitle(@PathVariable("title") String title) {
        List<Procedure> procedures = service.getByTitle(title);
        return new ResponseEntity<>(procedures, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Procedure> getById(@PathVariable("id") long id) {
        Procedure procedure = service.findById(id);
        return new ResponseEntity<>(procedure, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Procedure> insertProcedure(@RequestBody Procedure procedure) {
        if (procedure.getId() == 0) {
            service.save(procedure);
            return new ResponseEntity<Procedure>(procedure, HttpStatus.CREATED);
        }

        return ResponseEntity.badRequest().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Procedure> update(
        @RequestBody Procedure procedure,
        @PathVariable("id") long id
    ) {
        Procedure procedureEntity = service.findById(id);

        if (procedureEntity != null) {
            procedureEntity.setTitle(procedure.getTitle());
            procedureEntity.setDescription(procedure.getDescription());
            service.save(procedureEntity);

            return new ResponseEntity<>(procedureEntity, HttpStatus.OK);
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Procedure> delete(@PathVariable("id") long id) {
        Procedure procedure = service.findById(id);

        if (procedure == null) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);
        return ResponseEntity.accepted().build();
    }
    
}
