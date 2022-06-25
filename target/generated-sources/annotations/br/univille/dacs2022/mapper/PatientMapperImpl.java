package br.univille.dacs2022.mapper;

import br.univille.dacs2022.dto.PatientDTO;
import br.univille.dacs2022.entity.Patient;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-22T19:26:35-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Private Build)"
)
public class PatientMapperImpl implements PatientMapper {

    @Override
    public List<PatientDTO> mapListPatient(List<Patient> patient) {
        if ( patient == null ) {
            return null;
        }

        List<PatientDTO> list = new ArrayList<PatientDTO>( patient.size() );
        for ( Patient patient1 : patient ) {
            list.add( mapPatient( patient1 ) );
        }

        return list;
    }

    @Override
    public List<Patient> mapListPatientDTO(List<PatientDTO> patient) {
        if ( patient == null ) {
            return null;
        }

        List<Patient> list = new ArrayList<Patient>( patient.size() );
        for ( PatientDTO patientDTO : patient ) {
            list.add( mapPatientDTO( patientDTO ) );
        }

        return list;
    }

    @Override
    public PatientDTO mapPatient(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientDTO patientDTO = new PatientDTO();

        patientDTO.setId( patient.getId() );
        patientDTO.setName( patient.getName() );
        patientDTO.setSex( patient.getSex() );
        patientDTO.setBirthDate( patient.getBirthDate() );

        return patientDTO;
    }

    @Override
    public Patient mapPatientDTO(PatientDTO patient) {
        if ( patient == null ) {
            return null;
        }

        Patient patient1 = new Patient();

        patient1.setId( patient.getId() );
        patient1.setName( patient.getName() );
        patient1.setSex( patient.getSex() );
        patient1.setBirthDate( patient.getBirthDate() );

        return patient1;
    }
}
