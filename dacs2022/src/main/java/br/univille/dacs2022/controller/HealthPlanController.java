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

import br.univille.dacs2022.dto.HealthPlanDTO;
import br.univille.dacs2022.service.HealthPlanService;

@Controller
@RequestMapping("/healthplan")
public class HealthPlanController {

    @Autowired
    private HealthPlanService planService;

    @GetMapping
    public ModelAndView index() {
        List<HealthPlanDTO> plans = planService.getAll();

        return new ModelAndView("healthplan/index", "plans", plans);
    }

    @GetMapping("/new")
    public ModelAndView newPlan() {
        HealthPlanDTO plan = new HealthPlanDTO();

        return new ModelAndView("healthplan/form", "plan", plan);
    }

    @PostMapping(params = "form")
    public ModelAndView save(@Valid @ModelAttribute("healthPlan") HealthPlanDTO healthPlan, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ModelAndView("healthplan/form");
        }
        planService.save(healthPlan);

        return new ModelAndView("redirect:/healthplan");
    }
    
    @GetMapping(path = "/update/{id}")
    public ModelAndView update(@PathVariable long id) {
        HealthPlanDTO plan = planService.findById(id);

        return new ModelAndView("healthplan/form", "plan", plan);
    }
    
    @GetMapping(path = "/delete/{id}")
    public ModelAndView delete(@PathVariable long id) {
        planService.delete(id);

        return new ModelAndView("redirect:/healthplan");
    }

}
