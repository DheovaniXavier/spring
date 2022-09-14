package br.univille.apidacs2022.service;

import java.util.List;

import br.univille.coredacs2022.entity.City;

public interface CityServiceAPI {
    
    List<City> getAll();
    City save(City city);
    City findById(long id);
    City delete(long id);
    List<City> getByName(String name);

}
