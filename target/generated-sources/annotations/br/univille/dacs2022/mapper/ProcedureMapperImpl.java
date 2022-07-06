package br.univille.dacs2022.mapper;

import br.univille.dacs2022.dto.ProcedureDTO;
import br.univille.dacs2022.entity.Procedure;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-06T19:57:33-0300",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.100.v20220318-0906, environment: Java 17.0.3 (Eclipse Adoptium)"
)
public class ProcedureMapperImpl implements ProcedureMapper {

    @Override
    public List<ProcedureDTO> mapListProcedure(List<Procedure> procedure) {
        if ( procedure == null ) {
            return null;
        }

        List<ProcedureDTO> list = new ArrayList<ProcedureDTO>( procedure.size() );
        for ( Procedure procedure1 : procedure ) {
            list.add( mapProcedure( procedure1 ) );
        }

        return list;
    }

    @Override
    public List<Procedure> mapListProcedureDTO(List<ProcedureDTO> procedure) {
        if ( procedure == null ) {
            return null;
        }

        List<Procedure> list = new ArrayList<Procedure>( procedure.size() );
        for ( ProcedureDTO procedureDTO : procedure ) {
            list.add( mapProcedureDTO( procedureDTO ) );
        }

        return list;
    }

    @Override
    public ProcedureDTO mapProcedure(Procedure procedure) {
        if ( procedure == null ) {
            return null;
        }

        ProcedureDTO procedureDTO = new ProcedureDTO();

        procedureDTO.setId( procedure.getId() );
        procedureDTO.setDescription( procedure.getDescription() );

        return procedureDTO;
    }

    @Override
    public Procedure mapProcedureDTO(ProcedureDTO procedure) {
        if ( procedure == null ) {
            return null;
        }

        Procedure procedure1 = new Procedure();

        procedure1.setId( procedure.getId() );
        procedure1.setDescription( procedure.getDescription() );

        return procedure1;
    }
}
