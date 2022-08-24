package com.unibuc.assig.FinalProject.services;


import com.unibuc.assig.FinalProject.exceptions.notFoundExceptions.SoferNotFoundException;
import com.unibuc.assig.FinalProject.models.Buletin;
import com.unibuc.assig.FinalProject.models.Masina;
import com.unibuc.assig.FinalProject.models.Sofer;
import com.unibuc.assig.FinalProject.repos.SoferRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SoferService {

    @Autowired
    private SoferRepo soferRepo;

    @Autowired
    private BuletinService buletinService;

    @Autowired
    private MasinaService masinaService;


    public SoferService(SoferRepo soferRepo, BuletinService buletinService, MasinaService masinaService) {
        this.soferRepo = soferRepo;
        this.buletinService = buletinService;
        this.masinaService = masinaService;
    }

    @Transactional
    public Sofer createSoferAccount (Sofer sofer){

       Buletin buletin =  buletinService.addBuletin(sofer.getBuletin());
       Masina masina =  masinaService.addMasina(sofer.getMasina());
       sofer.setBuletin(buletin);
       sofer.setMasina(masina);

        return soferRepo.save(sofer);
    }

    public List<Sofer> getAllSoferi() {
        return soferRepo.findAll();
    }


    public Sofer getSoferById(long idSofer) {
        Optional<Sofer> soferOptional = soferRepo.findById(idSofer);
        if(soferOptional.isPresent())
        {
            return soferOptional.get();
        }
        else
        {
            throw new SoferNotFoundException(idSofer);
        }
    }
    @Transactional
    public void deleteById(Long id) {
        Optional<Sofer> soferOptional = soferRepo.findById(id);
        if (!soferOptional.isPresent()) {
            throw new RuntimeException("Sofer not found!");
        }
        soferRepo.deleteById(id);

    }
}
