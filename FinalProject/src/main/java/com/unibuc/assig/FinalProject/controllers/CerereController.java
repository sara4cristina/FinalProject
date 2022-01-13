package com.unibuc.assig.FinalProject.controllers;

import com.unibuc.assig.FinalProject.dtos.CerereDto;
import com.unibuc.assig.FinalProject.models.Cerere;
import com.unibuc.assig.FinalProject.services.CerereService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/cereri")
@Api(value="/cereri", tags="Cereri ale Clientilor")
public class CerereController {

    private CerereService cerereService;

    public CerereController(CerereService cerereService) {
        this.cerereService = cerereService;
    }



    @PostMapping("/{id}")
    @ApiOperation(value = "Create a Cerere", notes="Creates a Cerere based on the information received in the request and the Id of the Client how makes that Cerere")
    public Cerere createCerere(
            @Valid
            @RequestBody
            @ApiParam (name = "cerere", value = "Cerere details", required = true)
            CerereDto cerereDto,

            @ApiParam(name = "id", value = "Id of the Client", required = true)
            @PathVariable
            long id )
    {
       Cerere cerereRaspuns = cerereService.createCerere(
                new Cerere(cerereDto.getPlecare(), cerereDto.getSosire(), cerereDto.getData(), cerereDto.getPret())
                , id);

        return  cerereRaspuns;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get list of Cereri of one Client", notes="Find all the Cereri of one Client(found by their Id) in the database")
    public List<Cerere> findAllCerereByClientId(
            @PathVariable
            @ApiParam(name = "id", value = "Id of the Client that we want the Cereri of", required = true)
            long id)
    {
            return cerereService.getAllCerereByClientId(id);
    }


}
