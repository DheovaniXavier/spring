package br.univille.dacs2022.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.univille.coredacs2022.entity.Procedure;
import br.univille.dacs2022.dto.ProcedureDTO;

@Mapper
public interface ProcedureMapper {

    List<ProcedureDTO> mapListProcedure(List<Procedure> procedure);
    List<Procedure> mapListProcedureDTO(List<ProcedureDTO> procedure);

    ProcedureDTO mapProcedure(Procedure procedure);
    Procedure mapProcedureDTO(ProcedureDTO procedure);
    
}
