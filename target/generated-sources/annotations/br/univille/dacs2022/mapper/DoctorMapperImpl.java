package br.univille.dacs2022.mapper;

import br.univille.dacs2022.dto.DoctorDTO;
import br.univille.dacs2022.entity.Doctor;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-10T18:34:30-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Private Build)"
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

        doctorDTO.setId( doctor.getId() );
        doctorDTO.setName( doctor.getName() );
        doctorDTO.setCrm( doctor.getCrm() );

        return doctorDTO;
    }

    @Override
    public Doctor mapDoctorDTO(DoctorDTO doctor) {
        if ( doctor == null ) {
            return null;
        }

        Doctor doctor1 = new Doctor();

        doctor1.setId( doctor.getId() );
        doctor1.setName( doctor.getName() );
        doctor1.setCrm( doctor.getCrm() );

        return doctor1;
    }
}
