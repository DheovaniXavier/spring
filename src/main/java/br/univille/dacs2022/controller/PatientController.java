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

import br.univille.dacs2022.dto.PatientDTO;
import br.univille.dacs2022.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {
    
    @Autowired
    private PatientService service;

    @GetMapping
    public ModelAndView index() {
        List<PatientDTO> patientsList = service.getAll();

        return new ModelAndView("patient/index", "patientsList", patientsList);
    }

    @GetMapping("/new")
    public ModelAndView newPatient() {
        var patient = new PatientDTO();

        return new ModelAndView("patient/form", "patient", patient);
    }
    
    @PostMapping(params="form")
    public ModelAndView save(@Valid @ModelAttribute("patient") PatientDTO patient, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ModelAndView("patient/form");
        }
        service.save(patient);

        return new ModelAndView("redirect:/patient");
    }

    @GetMapping(path = "/update/{id}")
    public ModelAndView update(@PathVariable("id") long id) {
        PatientDTO patient = service.findById(id);

        return new ModelAndView("patient/form", "patient", patient);
    }

    @GetMapping(path = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id) {
        service.delete(id);

        return new ModelAndView("redirect:/patient");
    }

}
