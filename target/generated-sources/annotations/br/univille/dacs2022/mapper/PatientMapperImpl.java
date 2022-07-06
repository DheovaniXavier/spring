package br.univille.dacs2022.mapper;

import br.univille.dacs2022.dto.PatientDTO;
import br.univille.dacs2022.entity.Patient;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-06T19:54:19-0300",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.100.v20220318-0906, environment: Java 17.0.3 (Eclipse Adoptium)"
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

        patientDTO.setBirthDate( patient.getBirthDate() );
        patientDTO.setId( patient.getId() );
        patientDTO.setName( patient.getName() );
        patientDTO.setSex( patient.getSex() );

        return patientDTO;
    }

    @Override
    public Patient mapPatientDTO(PatientDTO patient) {
        if ( patient == null ) {
            return null;
        }

        Patient patient1 = new Patient();

        patient1.setBirthDate( patient.getBirthDate() );
        patient1.setId( patient.getId() );
        patient1.setName( patient.getName() );
        patient1.setSex( patient.getSex() );

        return patient1;
    }
}
