package br.univille.dacs2022.service.impl;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.dacs2022.dto.ProcedureDTO;
import br.univille.dacs2022.entity.Procedure;
import br.univille.dacs2022.mapper.ProcedureMapper;
import br.univille.dacs2022.repository.ProcedureRepository;
import br.univille.dacs2022.service.ProcedureService;

@Service
public class ProcedureServiceImpl implements ProcedureService {

    @Autowired
    private ProcedureRepository repository;
    private ProcedureMapper mapper = Mappers.getMapper(ProcedureMapper.class);

    @Override
    public List<ProcedureDTO> getAll() {
        return mapper.mapListProcedure(repository.findAll());
    }

    @Override
    public ProcedureDTO save(ProcedureDTO procedure) {
        Procedure procedureEntity = mapper.mapProcedureDTO(procedure);
        procedureEntity = repository.save(procedureEntity);

        return mapper.mapProcedure(procedureEntity);
    }

    @Override
    public ProcedureDTO findById(long id) {
        Optional<Procedure> procedureEntity = repository.findById(id);

        if(procedureEntity.isPresent()) {
            return mapper.mapProcedure(procedureEntity.get());
        }

        return new ProcedureDTO();
    }

    @Override
    public ProcedureDTO delete(long id) {
        Optional<Procedure> procedureEntity = repository.findById(id);

        if(procedureEntity.isPresent()) {
            Procedure patient = procedureEntity.get();
            repository.delete(patient);
            return mapper.mapProcedure(patient);
        }

        return null;
    }
    
}
