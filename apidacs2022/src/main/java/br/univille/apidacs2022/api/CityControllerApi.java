package br.univille.apidacs2022.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.apidacs2022.service.CityServiceAPI;
import br.univille.coredacs2022.entity.City;

@RestController
@RequestMapping("api/v1/city")
public class CityControllerApi {

    @Autowired
    private CityServiceAPI service;

    @GetMapping
    public ResponseEntity<List<City>> getAll() {
        List<City> cities = service.getAll();
        return new ResponseEntity<List<City>>(cities, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<City>> getByName(@PathVariable("name") String name) {
        List<City> cities = service.getByName(name);
        return new ResponseEntity<List<City>>(cities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getById(@PathVariable("id") long id) {
        City city = service.findById(id);
        return new ResponseEntity<City>(city, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<City> insertCity(@RequestBody City city) {
        if (city.getId() == 0) {
            service.save(city);
            return new ResponseEntity<City>(city, HttpStatus.CREATED);
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(
        @RequestBody City city,
        @PathVariable("id") long id
    ) {
        City cityEntity = service.findById(id);

        if (cityEntity != null) {
            cityEntity.setName(city.getName());
            cityEntity.setState(city.getState());
            service.save(cityEntity);

            return new ResponseEntity<City>(cityEntity, HttpStatus.OK);
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<City> delete(@PathVariable("id") long id) {
        City city = service.findById(id);
        
        if (city == null) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);
        return ResponseEntity.accepted().build();
    }
    
}
