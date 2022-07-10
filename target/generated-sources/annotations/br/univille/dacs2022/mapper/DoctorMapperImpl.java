package br.univille.dacs2022.mapper;

import br.univille.dacs2022.dto.DoctorDTO;
import br.univille.dacs2022.entity.Doctor;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-10T12:09:10-0300",
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

        return doctor1;
    }
}
