package com.unibuc.assig.FinalProject.services;


import com.unibuc.assig.FinalProject.exceptions.notFoundExceptions.CerereNotFoundException;
import com.unibuc.assig.FinalProject.models.Cerere;
import com.unibuc.assig.FinalProject.models.Client;
import com.unibuc.assig.FinalProject.models.RezervareType;
import com.unibuc.assig.FinalProject.repos.CerereRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CerereService {

    private CerereRepo cerereRepo;
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

    public List<Cerere> getAllCerereByClientId(long idClient) {

        Client clientById = clientService.getClientById(idClient);
        return clientById.getCereri();

    }


    public List<Cerere> getAllAvailableCereri() {

        return cerereRepo.findByRezervare(RezervareType.NEREZERVAT);
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
}
