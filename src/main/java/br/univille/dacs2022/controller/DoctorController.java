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

import br.univille.dacs2022.dto.DoctorDTO;
import br.univille.dacs2022.service.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @GetMapping
    public ModelAndView index() {
        List<DoctorDTO> doctorsList = service.getAll();

        return new ModelAndView("doctor/index", "doctorsList", doctorsList);
    }

    @GetMapping("/new")
    public ModelAndView newDoctor() {
        var doctor = new DoctorDTO();

        return new ModelAndView("doctor/form", "doctor", doctor);
    }
    
    @PostMapping(params="form")
    public ModelAndView save(@Valid @ModelAttribute("doctor") DoctorDTO doctor, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ModelAndView("doctor/form");
        }
        service.save(doctor);

        return new ModelAndView("redirect:/doctor");
    }

    @GetMapping(path = "/update/{id}")
    public ModelAndView update(@PathVariable("id") long id) {
        DoctorDTO doctor = service.findById(id);

        return new ModelAndView("doctor/form", "doctor", doctor);
    }

    @GetMapping(path = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id) {
        service.delete(id);

        return new ModelAndView("redirect:/doctor");
    }
    
}
