package br.univille.dacs2022.mapper;

import br.univille.dacs2022.dto.CityDTO;
import br.univille.dacs2022.dto.HealthPlanDTO;
import br.univille.dacs2022.dto.PatientDTO;
import br.univille.dacs2022.entity.City;
import br.univille.dacs2022.entity.HealthPlan;
import br.univille.dacs2022.entity.Patient;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-06T21:52:22-0300",
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
        patientDTO.setCity( cityToCityDTO( patient.getCity() ) );
        patientDTO.setId( patient.getId() );
        patientDTO.setName( patient.getName() );
        patientDTO.setPlans( healthPlanListToHealthPlanDTOList( patient.getPlans() ) );
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
        patient1.setCity( cityDTOToCity( patient.getCity() ) );
        patient1.setId( patient.getId() );
        patient1.setName( patient.getName() );
        patient1.setPlans( healthPlanDTOListToHealthPlanList( patient.getPlans() ) );
        patient1.setSex( patient.getSex() );

        return patient1;
    }

    protected CityDTO cityToCityDTO(City city) {
        if ( city == null ) {
            return null;
        }

        CityDTO cityDTO = new CityDTO();

        cityDTO.setId( city.getId() );
        cityDTO.setName( city.getName() );

        return cityDTO;
    }

    protected HealthPlanDTO healthPlanToHealthPlanDTO(HealthPlan healthPlan) {
        if ( healthPlan == null ) {
            return null;
        }

        HealthPlanDTO healthPlanDTO = new HealthPlanDTO();

        healthPlanDTO.setId( healthPlan.getId() );
        healthPlanDTO.setName( healthPlan.getName() );

        return healthPlanDTO;
    }

    protected List<HealthPlanDTO> healthPlanListToHealthPlanDTOList(List<HealthPlan> list) {
        if ( list == null ) {
            return null;
        }

        List<HealthPlanDTO> list1 = new ArrayList<HealthPlanDTO>( list.size() );
        for ( HealthPlan healthPlan : list ) {
            list1.add( healthPlanToHealthPlanDTO( healthPlan ) );
        }

        return list1;
    }

    protected City cityDTOToCity(CityDTO cityDTO) {
        if ( cityDTO == null ) {
            return null;
        }

        City city = new City();

        city.setId( cityDTO.getId() );
        city.setName( cityDTO.getName() );

        return city;
    }

    protected HealthPlan healthPlanDTOToHealthPlan(HealthPlanDTO healthPlanDTO) {
        if ( healthPlanDTO == null ) {
            return null;
        }

        HealthPlan healthPlan = new HealthPlan();

        healthPlan.setId( healthPlanDTO.getId() );
        healthPlan.setName( healthPlanDTO.getName() );

        return healthPlan;
    }

    protected List<HealthPlan> healthPlanDTOListToHealthPlanList(List<HealthPlanDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<HealthPlan> list1 = new ArrayList<HealthPlan>( list.size() );
        for ( HealthPlanDTO healthPlanDTO : list ) {
            list1.add( healthPlanDTOToHealthPlan( healthPlanDTO ) );
        }

        return list1;
    }
}
