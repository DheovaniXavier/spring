package br.univille.dacs2022.service.impl;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import br.univille.dacs2022.dto.CityDTO;
import br.univille.dacs2022.entity.City;
import br.univille.dacs2022.mapper.CityMapper;
import br.univille.dacs2022.repository.CityRepository;
import br.univille.dacs2022.service.CityService;

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
    public CityDTO findByID(long id) {
        var city = repository.findById(id);
        return mapper.mapCity(city.get());
    }
    
}
