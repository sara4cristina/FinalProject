package com.unibuc.assig.FinalProject.controllers;

import com.unibuc.assig.FinalProject.models.Cerere;
import com.unibuc.assig.FinalProject.models.Cursa;
import com.unibuc.assig.FinalProject.services.CursaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/cursa")
@Api(value="/cursa", tags="Curse")
public class CursaController {

    CursaService cursaService;

    public CursaController(CursaService cursaService) {
        this.cursaService = cursaService;
    }


    @GetMapping()
    @ApiOperation(value = "List of Curse", notes="Gives a list of all Available Curse - Cereri that wasn't valideted by any driver")
    public List<Cerere> getAllAvailableCurse()
    {
        return cursaService.getAllAvailableCurse();
    }

    @ApiOperation(value = "Create a Cursa", notes="Asign a Cerere to a Sofer by created a new Cursa")
    @PostMapping("/{idSofer}/{idCerere}")
    public Cursa createCursa(
            @PathVariable
            @ApiParam( name="idSofer", value = "The id of the Sofer", required = true)
            long idSofer,

            @PathVariable
            @ApiParam( name="idCerere", value = "The id of the Cerere that the Sofer wants to validate", required = true)
            long idCerere)
    {
        return cursaService.validateCursa(idSofer, idCerere);
    }


    @PostMapping("/{idCursa}")
    @ApiOperation(value = "Executes a Cursa", notes="Let the Sofer mark a Cursa as done")
    public Cursa executaCursa(
            @PathVariable
            @ApiParam( name="idCursa", value = "The id of the Cursa", required = true)
                    long idCursa)
    {
        return cursaService.executaCursa(idCursa);
    }


    @GetMapping("/{idSofer}")
    @ApiOperation(value = "List Sofer's Curse", notes="Let the Sofer list all of his Curse based on his id")
    public List<Cursa> getCursa(
            @PathVariable
            @ApiParam( name="idSofer", value = "The id of the Sofer", required = true)
            long idSofer){
        return cursaService.getCursaBySoferId(idSofer);
    }


}
