package com.unibuc.assig.FinalProject.controllers;


import com.unibuc.assig.FinalProject.dtos.SoferDto;
import com.unibuc.assig.FinalProject.models.Buletin;
import com.unibuc.assig.FinalProject.models.Masina;
import com.unibuc.assig.FinalProject.models.Sofer;
import com.unibuc.assig.FinalProject.services.SoferService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Slf4j
@RestController
@Validated
@RequestMapping("/soferi")
@Api(value="/soferi", tags="Soferi")
public class SoferController {

    private SoferService service;

    public SoferController(SoferService service) {
        this.service = service;
    }

    @GetMapping
    @ApiOperation(value = "Get list of Soferi", notes="Find all the Soferi in the database")
    public List<Sofer> findAllSoferi()
    {
        return service.getAllSoferi();
    }

    @PostMapping
    @ApiOperation(value = "Create a Sofer", notes="Creates a new Sofer based on the information received in the request")
    public Sofer createSofer(
            @Valid
            @RequestBody
            @ApiParam( name="sofer", value = "Sofer details", required = true)
            SoferDto soferDto)
    {

        Buletin reqBuletin= new Buletin(soferDto.getNumar_nr(), soferDto.getCnp());
        Masina reqMasina = new Masina(soferDto.getNumar_masina(), soferDto.getCapacitate());
        Sofer reqSofer = new Sofer(soferDto.getNume(), soferDto.getPrenume(), soferDto.getTelefon(), reqBuletin, reqMasina);

        
        Sofer raspunsSofer = service.createSoferAccount(reqSofer);
        return raspunsSofer;
    }



}
