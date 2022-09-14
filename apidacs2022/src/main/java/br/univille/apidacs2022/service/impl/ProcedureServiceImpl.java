package br.univille.apidacs2022.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.apidacs2022.service.ProcedureServiceAPI;
import br.univille.coredacs2022.entity.Procedure;
import br.univille.coredacs2022.repository.ProcedureRepository;

@Service
public class ProcedureServiceImpl implements ProcedureServiceAPI {

    @Autowired
    private ProcedureRepository repository;

    @Override
    public List<Procedure> getAll() {
        return repository.findAll();
    }

    @Override
    public Procedure save(Procedure procedure) {
        repository.save(procedure);
        return procedure;
    }

    @Override
    public Procedure findById(long id) {
        Optional<Procedure> procedure = repository.findById(id);

        if (procedure.isPresent()) {
            return procedure.get();
        }

        return null;
    }

    @Override
    public Procedure delete(long id) {
        Optional<Procedure> procedure = repository.findById(id);

        if (procedure.isPresent()) {
            repository.delete(procedure.get());
        }

        return null;
    }

    @Override
    public List<Procedure> getByTitle(String title) {
        return repository.findByTitleIgnoreCaseContaining(title);
    }
    
}
