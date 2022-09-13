package com.unibuc.assig.FinalProject.services;


import com.unibuc.assig.FinalProject.exceptions.notFoundExceptions.CerereNotFoundException;
import com.unibuc.assig.FinalProject.models.Cerere;
import com.unibuc.assig.FinalProject.models.Client;
import com.unibuc.assig.FinalProject.models.RezervareType;
import com.unibuc.assig.FinalProject.repos.CerereRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CerereService {

    @Autowired
    private CerereRepo cerereRepo;
    @Autowired
    private ClientService clientService;


    public CerereService(CerereRepo cerereRepo, ClientService clientService) {
        this.cerereRepo = cerereRepo;
        this.clientService = clientService;
    }

    @Transactional
    public Cerere createCerere(Cerere cerere, long idClient)
    {
        Client client = clientService.getClientById(idClient);
        cerere.setClient(client);
        cerere.setRezervare(RezervareType.NEREZERVAT);
        Cerere cerereRaspuns = cerereRepo.save(cerere);

        return cerereRepo.save(cerere);
    }

    @Transactional
    public Cerere createCerere(Cerere cerere)
    {
        log.info(cerere.toString());
        long idClient = cerere.getClient().getId();
        Client client = clientService.getClientById(idClient);
        cerere.setClient(client);
        cerere.setRezervare(RezervareType.NEREZERVAT);
        Cerere cerereRaspuns = cerereRepo.save(cerere);

        return cerereRepo.save(cerere);
    }

    public List<Cerere> getAllCerereByClientId(long idClient) {

        Client clientById = clientService.getClientById(idClient);
        return clientById.getCereri();

    }


    public List<Cerere> getAllAvailableCereri() {
        return cerereRepo.findAllByRezervareEquals(RezervareType.NEREZERVAT);
    }
    public List<Cerere> findAll()
    {
        return cerereRepo.findAll();
    }

    public Cerere getCerereById(long idCerere) {
        Optional<Cerere> cerereOptional = cerereRepo.findById(idCerere);
        if(cerereOptional.isPresent())
        {
            return cerereOptional.get();
        }
        else
        {
            throw new CerereNotFoundException(idCerere);
        }
    }

    @Transactional
    public Cerere updateCerere(Cerere cerere) {
         cerereRepo.updateRezervareCerere(RezervareType.REZERVAT, cerere.getId());
        return getCerereById(cerere.getId());
    }

    @Transactional
    public void deleteById(Long id) {
        Optional<Cerere> cerereOptional = cerereRepo.findById(id);
        if (!cerereOptional.isPresent()) {
            throw new RuntimeException("Cerere not found!");
        }
        cerereRepo.deleteById(id);

    }
}
