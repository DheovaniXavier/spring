package br.univille.dacs2022.service;

import java.util.List;

import br.univille.dacs2022.dto.CityDTO;

public interface CityService {

    List<CityDTO> getAll();

    CityDTO save(CityDTO city);

    CityDTO findByID(long id);

    CityDTO delete(long id);
    
}
