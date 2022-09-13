package com.unibuc.assig.FinalProject.controllers;

import com.unibuc.assig.FinalProject.models.Masina;
import com.unibuc.assig.FinalProject.services.MasinaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
@Slf4j
public class MasinaController {

    @Autowired
    MasinaService masinaService;

    public MasinaController(MasinaService masinaService) {
        this.masinaService = masinaService;
    }

    @RequestMapping("/masina/list")
    public ModelAndView masinaList(){
        ModelAndView modelAndView = new ModelAndView("masini");
        List<Masina> masini = masinaService.findAll();
        modelAndView.addObject("masini",masini);
        return modelAndView;
    }

    @RequestMapping("/masina/delete/{id}")
    public String deleteById(@PathVariable String id){
        masinaService.deleteById(Long.valueOf(id));
        return "redirect:/masina/list";
    }

    @RequestMapping("/masina/new")
    public String newMasina(Model model) {
        model.addAttribute("masina", new Masina());
        return "masinaForm";
    }

    @PostMapping("/masina")
    public String saveOrUpdate(@Valid @ModelAttribute Masina masina,
                                          BindingResult bindingResult
                               ){
        if (bindingResult.hasErrors()){
            return "masinaForm";
        }
        Masina savedMasina = masinaService.addMasina(masina);
        return "redirect:/masina/list" ;
    }

}
