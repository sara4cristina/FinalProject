package com.unibuc.assig.FinalProject.controllers;

import com.unibuc.assig.FinalProject.models.Cerere;
import com.unibuc.assig.FinalProject.services.CerereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CerereService cerereService;

    @GetMapping("/showLogInForm")
    public String showLogInForm(){ return "login"; }

    @RequestMapping({"", "/", "/index"})
    public ModelAndView cerereList(){
        ModelAndView modelAndView = new ModelAndView("cereri");
        List<Cerere> cereri = cerereService.findAll();
        modelAndView.addObject("cereri",cereri);
        return modelAndView;
    }

    @GetMapping("/login-error")
    public String loginError() {
        return "login-error";
    }

    @GetMapping("/access_denied")
    public String accessDenied() {
        return "access_denied";
    }

    @GetMapping("error")
    public String error() {return "acces_denied";}


}
