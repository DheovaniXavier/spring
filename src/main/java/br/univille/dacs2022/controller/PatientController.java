package br.univille.dacs2022.controller;

import java.util.HashMap;
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
import br.univille.dacs2022.dto.PatientDTO;
import br.univille.dacs2022.service.CityService;
import br.univille.dacs2022.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {
    
    @Autowired
    private PatientService patientService;

    @Autowired
    private CityService cityService;

    @GetMapping
    public ModelAndView index() {
        List<PatientDTO> patientsList = patientService.getAll();

        return new ModelAndView("patient/index", "patientsList", patientsList);
    }

    @GetMapping("/new")
    public ModelAndView newPatient() {
        PatientDTO patient = new PatientDTO();
        List<CityDTO> cities = cityService.getAll();
        HashMap<String, Object> data = new HashMap<>();
        data.put("patient", patient);
        data.put("cities", cities);

        return new ModelAndView("patient/form", data);
    }
    
    @PostMapping(params="form")
    public ModelAndView save(@Valid @ModelAttribute("patient") PatientDTO patient, BindingResult bindingResult) {
        CityDTO city = cityService.findByID(patient.getCityId());
        patient.setCity(city);

        if(bindingResult.hasErrors()) {
            List<CityDTO> cities = cityService.getAll();
            HashMap<String,Object> data = new HashMap<>();
            data.put("cities", cities);
            return new ModelAndView("paciente/form", data);
        }

        patientService.save(patient);

        return new ModelAndView("redirect:/patient");
    }

    @GetMapping(path = "/update/{id}")
    public ModelAndView update(@PathVariable("id") long id) {
        PatientDTO patient = patientService.findById(id);
        List<CityDTO> cities = cityService.getAll();
        HashMap<String,Object> data = new HashMap<>();
        data.put("patient", patient);
        data.put("cities", cities);

        return new ModelAndView("patient/form", "patient", patient);
    }

    @GetMapping(path = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id) {
        patientService.delete(id);

        return new ModelAndView("redirect:/patient");
    }

}
