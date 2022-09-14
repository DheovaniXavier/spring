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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.dacs2022.dto.CityDTO;
import br.univille.dacs2022.dto.HealthPlanDTO;
import br.univille.dacs2022.dto.PatientDTO;
import br.univille.dacs2022.service.CityService;
import br.univille.dacs2022.service.HealthPlanService;
import br.univille.dacs2022.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {
    
    @Autowired
    private PatientService patientService;

    @Autowired
    private CityService cityService;

    @Autowired
    private HealthPlanService planService;

    @GetMapping
    public ModelAndView index() {
        List<PatientDTO> patientsList = patientService.getAll();

        return new ModelAndView("patient/index", "patientsList", patientsList);
    }

    @GetMapping("/new")
    public ModelAndView newPatient() {
        PatientDTO patient = new PatientDTO();
        List<CityDTO> cities = cityService.getAll();
        List<HealthPlanDTO> plans = planService.getAll();
        HashMap<String, Object> data = new HashMap<>();
        data.put("patient", patient);
        data.put("cities", cities);
        data.put("plans", plans);

        return new ModelAndView("patient/form", data);
    }

    @PostMapping(params="newplan")
    public ModelAndView newPlan(@Valid @ModelAttribute("patient") PatientDTO patient, BindingResult bindingResult) {
        Long planId = patient.getHealthPlanId();
        HealthPlanDTO plan = planService.findById(planId);
        patient.getPlans().add(plan);

        List<CityDTO> cities = cityService.getAll();
        List<HealthPlanDTO> plans = planService.getAll();
        HashMap<String, Object> data = new HashMap<>();
        data.put("patient", patient);
        data.put("cities", cities);
        data.put("plans", plans);

        return new ModelAndView("patient/form", data);
    }
    
    @PostMapping(params="save")
    public ModelAndView save(@Valid @ModelAttribute("patient") PatientDTO patient, BindingResult bindingResult) {
        CityDTO city = cityService.findByID(patient.getCityId());
        patient.setCity(city);

        if(bindingResult.hasErrors()) {
            List<CityDTO> cities = cityService.getAll();
            List<HealthPlanDTO> plans = planService.getAll();
            HashMap<String,Object> data = new HashMap<>();
            data.put("cities", cities);
            data.put("plans", plans);
            return new ModelAndView("patient/form", data);
        }
        patientService.save(patient);

        return new ModelAndView("redirect:/patient");
    }

    @GetMapping(path = "/update/{id}")
    public ModelAndView update(@PathVariable("id") long id) {
        PatientDTO patient = patientService.findById(id);
        List<CityDTO> cities = cityService.getAll();
        List<HealthPlanDTO> plans = planService.getAll();
        HashMap<String,Object> data = new HashMap<>();
        data.put("patient", patient);
        data.put("cities", cities);
        data.put("plans", plans);

        return new ModelAndView("patient/form", data);
    }

    @GetMapping(path = "/delete/{id}")
    public ModelAndView deletePatient(@PathVariable("id") long id) {
        patientService.delete(id);

        return new ModelAndView("redirect:/patient");
    }

    @PostMapping(params="deleteplan")
    public ModelAndView deletePlan(@ModelAttribute("patient") PatientDTO patient, @RequestParam(name = "deleteplan") int index, BindingResult bindingResult) {
        patient.getPlans().remove(index);

        List<CityDTO> cities = cityService.getAll();
        List<HealthPlanDTO> plans = planService.getAll();
        HashMap<String, Object> data = new HashMap<>();
        data.put("patient", patient);
        data.put("cities", cities);
        data.put("plans", plans);

        return new ModelAndView("patient/form", data);
    }

}
