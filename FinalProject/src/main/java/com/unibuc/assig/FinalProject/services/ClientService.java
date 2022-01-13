package com.unibuc.assig.FinalProject.services;

import com.unibuc.assig.FinalProject.exceptions.notFoundExceptions.ClientNotFoundException;
import com.unibuc.assig.FinalProject.models.Client;
import com.unibuc.assig.FinalProject.repos.ClientRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClientService {

    private ClientRepo clientRepo;

    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public Client createClientAccount (Client client){ return clientRepo.save(client);}

    public List<Client> getAllClients() { return clientRepo.findAll(); }

    public Client getClientById(long idClient){

        Optional<Client> clientOptional = clientRepo.findById(idClient);
        if(clientOptional.isPresent())
        { return clientOptional.get(); }
        else
        {
            throw new ClientNotFoundException(idClient);
             }

    }
}
