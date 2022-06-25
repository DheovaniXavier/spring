package br.univille.dacs2022.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.univille.dacs2022.dto.DoctorDTO;
import br.univille.dacs2022.entity.Doctor;

@Mapper
public interface DoctorMapper {

    List<DoctorDTO> mapListDoctor(List<Doctor> doctor);
    List<Doctor> mapListDoctorDTO(List<DoctorDTO> doctor);

    DoctorDTO mapDoctor(Doctor doctor);
    Doctor mapDoctorDTO(DoctorDTO doctor);
    
}
