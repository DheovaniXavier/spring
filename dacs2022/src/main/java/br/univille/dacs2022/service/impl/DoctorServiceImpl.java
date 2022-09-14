package br.univille.dacs2022.service.impl;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.dacs2022.dto.DoctorDTO;
import br.univille.coredacs2022.entity.Doctor;
import br.univille.dacs2022.mapper.DoctorMapper;
import br.univille.coredacs2022.repository.DoctorRepository;
import br.univille.dacs2022.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository repository;
    private DoctorMapper mapper = Mappers.getMapper(DoctorMapper.class);

    @Override
    public List<DoctorDTO> getAll() {
        return mapper.mapListDoctor(repository.findAll());
    }

    @Override
    public DoctorDTO save(DoctorDTO doctor) {
        Doctor doctorEntity = mapper.mapDoctorDTO(doctor);
        doctorEntity = repository.save(doctorEntity);

        return mapper.mapDoctor(doctorEntity);
    }

    @Override
    public DoctorDTO findById(long id) {
        Optional<Doctor> doctorEntity = repository.findById(id);

        if(doctorEntity.isPresent()) {
            return mapper.mapDoctor(doctorEntity.get());
        }

        return new DoctorDTO();
    }

    @Override
    public DoctorDTO delete(long id) {
        Optional<Doctor> doctorEntity = repository.findById(id);

        if(doctorEntity.isPresent()) {
            Doctor doctor = doctorEntity.get();
            repository.delete(doctor);
            return mapper.mapDoctor(doctor);
        }

        return null;
    }
    
}
