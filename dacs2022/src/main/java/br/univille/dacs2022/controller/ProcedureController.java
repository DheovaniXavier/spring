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

import br.univille.dacs2022.dto.ProcedureDTO;
import br.univille.dacs2022.service.ProcedureService;

@Controller
@RequestMapping("/procedure")
public class ProcedureController {

    @Autowired
    private ProcedureService service;

    @GetMapping
    public ModelAndView index() {
        List<ProcedureDTO> proceduresList = service.getAll();

        return new ModelAndView("procedure/index", "proceduresList", proceduresList);
    }

    @GetMapping("/new")
    public ModelAndView newProcedure() {
        var procedure = new ProcedureDTO();

        return new ModelAndView("procedure/form", "procedure", procedure);
    }

    @PostMapping(params="form")
    public ModelAndView save(@Valid @ModelAttribute("procedure") ProcedureDTO procedure, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ModelAndView("procedure/form");
        }
        service.save(procedure);

        return new ModelAndView("redirect:/procedure");
    }

    @GetMapping(path = "/update/{id}")
    public ModelAndView update(@PathVariable("id") long id) {
        ProcedureDTO procedure = service.findById(id);

        return new ModelAndView("procedure/form", "procedure", procedure);
    }

    @GetMapping(path = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id) {
        service.delete(id);

        return new ModelAndView("redirect:/procedure");
    }
    
}
