package com.unibuc.assig.FinalProject.controllers;

import com.unibuc.assig.FinalProject.dtos.SoferDto;
import com.unibuc.assig.FinalProject.models.Buletin;
import com.unibuc.assig.FinalProject.models.Masina;
import com.unibuc.assig.FinalProject.models.Sofer;
import com.unibuc.assig.FinalProject.services.SoferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/sofer")
public class SoferController {

    @Autowired
    SoferService soferService;

    public SoferController(SoferService soferService) {
        this.soferService = soferService;
    }

    @RequestMapping("/list")
    public ModelAndView soferList(){
        ModelAndView modelAndView = new ModelAndView("soferi");
        List<Sofer> soferi = soferService.getAllSoferi();
        modelAndView.addObject("soferi",soferi);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteById(@PathVariable String id){
        soferService.deleteById(Long.valueOf(id));
        return "redirect:/list";
    }

    @RequestMapping("/new")
    public String newSofer(Model model) {
        model.addAttribute("sofer", new SoferDto());
        return "soferForm";
    }

    @PostMapping("/")
    public String saveOrUpdate(@Valid @ModelAttribute SoferDto soferDto,
                                          BindingResult bindingResult
                               ){
        if (bindingResult.hasErrors()){
            return "soferForm";
        }

        Buletin reqBuletin = new Buletin(soferDto.getSerieNr(), soferDto.getCnp());
        Masina reqMasina = new Masina(soferDto.getNumar_masina(), soferDto.getCapacitate());
        Sofer reqSofer = new Sofer(soferDto.getNume(), soferDto.getPrenume(), soferDto.getTelefon(), reqBuletin, reqMasina);

        Sofer savedSofer = soferService.createSoferAccount(reqSofer);
        return "redirect:/sofer/list" ;
    }

}
