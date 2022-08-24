package com.unibuc.assig.FinalProject.controllers;

import com.unibuc.assig.FinalProject.models.Cursa;
import com.unibuc.assig.FinalProject.services.CursaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/cursa")
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

    @GetMapping("/info/{id}")
    public String showById(@PathVariable String id, Model model){

        Object response = cursaService.findCursaById(Long.valueOf(id));
        if( response instanceof Cursa) {
            model.addAttribute("cursa", response);
            return "infoCursa";
        }else{
            model.addAttribute("error", response);
            return "error";
        }
    }

    @RequestMapping("/delete/{id}")
    public String deleteById(@PathVariable String id){
        cursaService.deleteById(Long.valueOf(id));
        return "redirect:/cursa/list";
    }

    @RequestMapping("/validate/{idSofer}/{idCerere}")
    public String newCursa(Model model) {
        model.addAttribute("cursa", new Cursa());
        return "cursaForm";
    }

    @PostMapping("/{idSofer}/{idCerere}")
    public String saveOrUpdate(@Valid @ModelAttribute Cursa cursa,
                                          BindingResult bindingResult,
                               @PathVariable long idSofer,
                               @PathVariable long idCerere
                               ){
        if (bindingResult.hasErrors()){
            return "cereriForm";
        }

        Cursa savedCursa = cursaService.validateCursa(idSofer, idCerere);

        return "redirect:/cursa/list" ;
    }

}
