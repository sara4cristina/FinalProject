package com.unibuc.assig.FinalProject.controllers;

import com.unibuc.assig.FinalProject.models.Cerere;
import com.unibuc.assig.FinalProject.services.CerereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
public class CereriController {

    @Autowired
    CerereService cerereService;

    public CereriController(CerereService cerereService) {
        this.cerereService = cerereService;
    }

    @RequestMapping("/cerere/list")
    public ModelAndView cereriList(){
        ModelAndView modelAndView = new ModelAndView("cereri");
        List<Cerere> cereri = cerereService.findAll();
        modelAndView.addObject("cereri",cereri);
        return modelAndView;
    }

    @GetMapping("/cerere/info/{id}")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("cerere",
                cerereService.getCerereById(Long.valueOf(id)));
        return "info";
    }

    @RequestMapping("/cerere/delete/{id}")
    public String deleteById(@PathVariable String id){
        cerereService.deleteById(Long.valueOf(id));
        return "redirect:/cerere/list";
    }

    @RequestMapping("/cerere/new")
    public String newCerere(Model model) {
        model.addAttribute("cerere", new Cerere());
        return "cereriForm";
    }

    @PostMapping("/cerere/{id}")
    public String saveOrUpdate(@Valid @ModelAttribute Cerere cerere,
                                          BindingResult bindingResult,
                               @PathVariable long id
                               ){
        if (bindingResult.hasErrors()){
            return "cereriForm";
        }

        Cerere savedCerere = cerereService.createCerere(cerere, id);
        return "redirect:/cerere/list" ;
    }

}
