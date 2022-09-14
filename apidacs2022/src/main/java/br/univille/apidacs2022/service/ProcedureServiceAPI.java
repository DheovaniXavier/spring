package br.univille.apidacs2022.service;

import java.util.List;

import br.univille.coredacs2022.entity.Procedure;

public interface ProcedureServiceAPI {

    List<Procedure> getAll();
    Procedure save(Procedure procedure);
    Procedure findById(long id);
    Procedure delete(long id);
    List<Procedure> getByTitle(String title);
    
}
