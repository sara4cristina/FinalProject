package com.unibuc.assig.FinalProject.controllers;

import com.unibuc.assig.FinalProject.models.Client;
import com.unibuc.assig.FinalProject.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping("/list")
    public ModelAndView clientList(){
        ModelAndView modelAndView = new ModelAndView("clienti");
        List<Client> clienti = clientService.getAllClients();
        modelAndView.addObject("clienti",clienti);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteById(@PathVariable String id){
        clientService.deleteById(Long.valueOf(id));
        return "redirect:/client/list";
    }

    @RequestMapping("/new")
    public String newClient(Model model) {
        model.addAttribute("client", new Client());
        return "clientForm";
    }

    @PostMapping("/")
    public String saveOrUpdate(@Valid @ModelAttribute Client client,
                                          BindingResult bindingResult
                               ){
        if (bindingResult.hasErrors()){
            return "clientForm";
        }
        return "redirect:/client/list" ;
    }

}
