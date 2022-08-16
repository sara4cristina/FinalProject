package com.unibuc.assig.FinalProject.restControllers;

import com.unibuc.assig.FinalProject.dtos.ClientDto;
import com.unibuc.assig.FinalProject.models.Client;
import com.unibuc.assig.FinalProject.services.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
@Slf4j
@RestController
@Validated
@RequestMapping("/clienti")
@Api(value="/clienti", tags="Clienti")
public class ClientController {

    private ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    @ApiOperation(value = "Create a Client", notes="Creates a new Client based on the information received in the request")
    public ResponseEntity<Client> createClient(
            @Valid
            @RequestBody
             @ApiParam( name="client", value = "Client details", required = true)
                    ClientDto client)
    {
        Client clientRaspuns = service.createClientAccount(new Client(client.getNume(), client.getTelefon(), client.getCui()));
        return ResponseEntity
                .created(URI.create("/clients/" + clientRaspuns.getId()))
                .body(new Client (clientRaspuns.getId(),clientRaspuns.getNume(), clientRaspuns.getTelefon() ,clientRaspuns.getCui() ));
    }


    @GetMapping()
    @ApiOperation(value = "Get list of Clienti", notes="Find all the Clieti in the database")
    public List<Client> getClient()
    {
        return service.getAllClients();
    }


}
