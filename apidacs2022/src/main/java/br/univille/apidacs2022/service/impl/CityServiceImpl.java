package br.univille.apidacs2022.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.apidacs2022.service.CityServiceAPI;
import br.univille.coredacs2022.entity.City;
import br.univille.coredacs2022.repository.CityRepository;

@Service
public class CityServiceImpl implements CityServiceAPI {

    @Autowired
    private CityRepository repository;

    @Override
    public List<City> getAll() {
        return repository.findAll();
    }

    @Override
    public City save(City city) {
        repository.save(city);
        return city;
    }

    @Override
    public City findById(long id) {
        Optional<City> city = repository.findById(id);

        if (city.isPresent()) {
            return city.get();
        }

        return null;
    }

    @Override
    public City delete(long id) {
        Optional<City> city = repository.findById(id);

        if (city.isPresent()) {
            repository.delete(city.get());
        }

        return null;
    }

    @Override
    public List<City> getByName(String name) {
        return repository.findByNameIgnoreCaseContaining(name);
    }
    
}
