package br.univille.dacs2022.service.impl;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.dacs2022.dto.CityDTO;
import br.univille.coredacs2022.entity.City;
import br.univille.dacs2022.mapper.CityMapper;
import br.univille.coredacs2022.repository.CityRepository;
import br.univille.dacs2022.service.CityService;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository repository;
    private CityMapper mapper = Mappers.getMapper(CityMapper.class);

    @Override
    public List<CityDTO> getAll() {
        List<City> cities = repository.findAll();
        return mapper.mapListCity(cities);
    }

    @Override
    public CityDTO save(CityDTO city) {
        City cityEntity = mapper.mapCityDTO(city);
        repository.save(cityEntity);

        return mapper.mapCity(cityEntity);
    }

    @Override
    public CityDTO findByID(long id) {
        Optional<City> city = repository.findById(id);
        return mapper.mapCity(city.get());
    }

    @Override
    public CityDTO delete(long id) {
        Optional<City> cityEntity = repository.findById(id);
        
        if(cityEntity.isPresent()) {
            City city = cityEntity.get();
            repository.delete(city);
            mapper.mapCity(city);
        }

        return null;
    }
    
}
