package br.univille.dacs2022.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.dacs2022.dto.CityDTO;
import br.univille.dacs2022.service.CityService;


@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public ModelAndView index() {
        List<CityDTO> cities = cityService.getAll();

        return new ModelAndView("city/index", "cities", cities);
    }

    @GetMapping("/new")
    public ModelAndView newCity() {
        CityDTO city = new CityDTO();

        return new ModelAndView("city/form", "city", city);
    }
    
    @PostMapping(params = "form")
    public ModelAndView save(@Valid @ModelAttribute("city") CityDTO city, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ModelAndView("city/form");
        }
        cityService.save(city);

        return new ModelAndView("redirect:/city");
    }
    
    @GetMapping(path = "/update/{id}")
    public ModelAndView update(@PathVariable("id") long id) {
        CityDTO city = cityService.findByID(id);

        return new ModelAndView("city/form", "city", city);
    }
    
    @GetMapping(path = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id) {
        cityService.delete(id);

        return new ModelAndView("redirect:/city");
    }
    
}
