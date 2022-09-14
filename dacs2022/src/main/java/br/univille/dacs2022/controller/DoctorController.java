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

import br.univille.dacs2022.dto.DoctorDTO;
import br.univille.dacs2022.dto.ProcedureDTO;
import br.univille.dacs2022.service.DoctorService;
import br.univille.dacs2022.service.ProcedureService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private ProcedureService procedureService;

    @GetMapping
    public ModelAndView index() {
        List<DoctorDTO> doctorsList = doctorService.getAll();

        return new ModelAndView("doctor/index", "doctorsList", doctorsList);
    }

    @GetMapping("/new")
    public ModelAndView newDoctor() {
        DoctorDTO doctor = new DoctorDTO();
        List<ProcedureDTO> procedures = procedureService.getAll();
        HashMap<String, Object> map = new HashMap<>();
        map.put("doctor", doctor);
        map.put("procedures", procedures);

        return new ModelAndView("doctor/form", map);
    }

    @PostMapping(params="newproc")
    public ModelAndView newProc(@Valid @ModelAttribute("doctor") DoctorDTO doctor, BindingResult bindingResult) {
        Long procId = doctor.getProcedureId();
        ProcedureDTO proc = procedureService.findById(procId);
        doctor.getProcedures().add(proc);

        List<ProcedureDTO> procedures = procedureService.getAll();
        HashMap<String, Object> map = new HashMap<>();
        map.put("doctor", doctor);
        map.put("procedures", procedures);

        return new ModelAndView("doctor/form", map);
    }
    
    @PostMapping(params="save")
    public ModelAndView save(@Valid @ModelAttribute("doctor") DoctorDTO doctor, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            List<ProcedureDTO> procedures = procedureService.getAll();
            return new ModelAndView("doctor/form", "procedures", procedures);
        }
        doctorService.save(doctor);

        return new ModelAndView("redirect:/doctor");
    }

    @GetMapping(path = "/update/{id}")
    public ModelAndView update(@PathVariable("id") long id) {
        DoctorDTO doctor = doctorService.findById(id);
        List<ProcedureDTO> procedures = procedureService.getAll();
        HashMap<String, Object> map = new HashMap<>();
        map.put("doctor", doctor);
        map.put("procedures", procedures);

        return new ModelAndView("doctor/form", map);
    }

    @GetMapping(path = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id) {
        doctorService.delete(id);

        return new ModelAndView("redirect:/doctor");
    }

    @PostMapping(params="delproc")
    public ModelAndView deleteProc(@ModelAttribute("doctor") DoctorDTO doctor, @RequestParam(name = "delproc") int index, BindingResult bindingResult) {
        doctor.getProcedures().remove(index);

        List<ProcedureDTO> procedures = procedureService.getAll();
        HashMap<String, Object> map = new HashMap<>();
        map.put("doctor", doctor);
        map.put("procedures", procedures);

        return new ModelAndView("doctor/form", map);
    }

}
