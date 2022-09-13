package com.unibuc.assig.FinalProject.controllers;

import com.unibuc.assig.FinalProject.exceptions.notFoundExceptions.CursaNotFoundException;
import com.unibuc.assig.FinalProject.models.Cursa;
import com.unibuc.assig.FinalProject.models.EfectuareType;
import com.unibuc.assig.FinalProject.models.Sofer;
import com.unibuc.assig.FinalProject.services.CerereService;
import com.unibuc.assig.FinalProject.services.CursaService;
import com.unibuc.assig.FinalProject.services.SoferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/cursa")
@Slf4j
public class CursaController {

    @Autowired
    CursaService cursaService;

    public CursaController(CursaService cursaService) {
        this.cursaService = cursaService;
    }

    @RequestMapping("/list")
    public ModelAndView cereriList(){
        ModelAndView modelAndView = new ModelAndView("curse");
        List<Cursa> curse = cursaService.findAll();
        modelAndView.addObject("curse",curse);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteById(@PathVariable String id){
        cursaService.deleteById(Long.valueOf(id));
        return "redirect:/cursa/list";
    }

    @RequestMapping("/")
    public String newCursa()
    {
        return "alegeSofer";
    }

    @RequestMapping("/validate")
    public String saveCursa(@RequestParam(value = "idCerere", required = true) String idCerere, @RequestParam(value = "idSofer" , required = true) String idSofer){

        log.info("Suntem in valideaza cursa cu cererea" + idCerere + " sofer " + idSofer);
        cursaService.validateCursa(Long.valueOf(idSofer), Long.valueOf(idCerere));
//        Cerere savedCerere = cerereService.createCerere(cerere);
        log.info("Am fost in salvarea de cursa");
        return "redirect:/cursa/list" ;
    }

    @RequestMapping("/efectueaza/{idCursa}")
    public String efectCursa(@PathVariable String idCursa){
        cursaService.executaCursa(Long.valueOf(idCursa));
        return "redirect:/cursa/list";
    }

}
