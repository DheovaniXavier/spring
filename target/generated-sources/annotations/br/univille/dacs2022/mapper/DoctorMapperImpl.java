package br.univille.dacs2022.mapper;

import br.univille.dacs2022.dto.DoctorDTO;
import br.univille.dacs2022.dto.ProcedureDTO;
import br.univille.dacs2022.entity.Doctor;
import br.univille.dacs2022.entity.Procedure;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-13T20:02:54-0300",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.100.v20220318-0906, environment: Java 17.0.3 (Eclipse Adoptium)"
)
public class DoctorMapperImpl implements DoctorMapper {

    @Override
    public List<DoctorDTO> mapListDoctor(List<Doctor> doctor) {
        if ( doctor == null ) {
            return null;
        }

        List<DoctorDTO> list = new ArrayList<DoctorDTO>( doctor.size() );
        for ( Doctor doctor1 : doctor ) {
            list.add( mapDoctor( doctor1 ) );
        }

        return list;
    }

    @Override
    public List<Doctor> mapListDoctorDTO(List<DoctorDTO> doctor) {
        if ( doctor == null ) {
            return null;
        }

        List<Doctor> list = new ArrayList<Doctor>( doctor.size() );
        for ( DoctorDTO doctorDTO : doctor ) {
            list.add( mapDoctorDTO( doctorDTO ) );
        }

        return list;
    }

    @Override
    public DoctorDTO mapDoctor(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        DoctorDTO doctorDTO = new DoctorDTO();

        doctorDTO.setCrm( doctor.getCrm() );
        doctorDTO.setId( doctor.getId() );
        doctorDTO.setName( doctor.getName() );
        doctorDTO.setProcedures( procedureListToProcedureDTOList( doctor.getProcedures() ) );

        return doctorDTO;
    }

    @Override
    public Doctor mapDoctorDTO(DoctorDTO doctor) {
        if ( doctor == null ) {
            return null;
        }

        Doctor doctor1 = new Doctor();

        doctor1.setCrm( doctor.getCrm() );
        doctor1.setId( doctor.getId() );
        doctor1.setName( doctor.getName() );
        doctor1.setProcedures( procedureDTOListToProcedureList( doctor.getProcedures() ) );

        return doctor1;
    }

    protected ProcedureDTO procedureToProcedureDTO(Procedure procedure) {
        if ( procedure == null ) {
            return null;
        }

        ProcedureDTO procedureDTO = new ProcedureDTO();

        procedureDTO.setDescription( procedure.getDescription() );
        procedureDTO.setId( procedure.getId() );
        procedureDTO.setTitle( procedure.getTitle() );

        return procedureDTO;
    }

    protected List<ProcedureDTO> procedureListToProcedureDTOList(List<Procedure> list) {
        if ( list == null ) {
            return null;
        }

        List<ProcedureDTO> list1 = new ArrayList<ProcedureDTO>( list.size() );
        for ( Procedure procedure : list ) {
            list1.add( procedureToProcedureDTO( procedure ) );
        }

        return list1;
    }

    protected Procedure procedureDTOToProcedure(ProcedureDTO procedureDTO) {
        if ( procedureDTO == null ) {
            return null;
        }

        Procedure procedure = new Procedure();

        procedure.setDescription( procedureDTO.getDescription() );
        procedure.setId( procedureDTO.getId() );
        procedure.setTitle( procedureDTO.getTitle() );

        return procedure;
    }

    protected List<Procedure> procedureDTOListToProcedureList(List<ProcedureDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Procedure> list1 = new ArrayList<Procedure>( list.size() );
        for ( ProcedureDTO procedureDTO : list ) {
            list1.add( procedureDTOToProcedure( procedureDTO ) );
        }

        return list1;
    }
}
