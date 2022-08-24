package com.unibuc.assig.FinalProject.services;


import com.unibuc.assig.FinalProject.exceptions.notFoundExceptions.CursaNotFoundException;
import com.unibuc.assig.FinalProject.models.*;
import com.unibuc.assig.FinalProject.repos.CursaRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class CursaService {

    @Autowired
    private CursaRepo cursaRepo;

    @Autowired
    private CerereService cerereService;

    @Autowired
    private SoferService soferService;

    public CursaService(CursaRepo cursaRepo, CerereService cerereService, SoferService soferService) {
        this.cursaRepo = cursaRepo;
        this.cerereService = cerereService;
        this.soferService = soferService;
    }


    public List<Cerere> getAllAvailableCurse() {
        return cerereService.getAllAvailableCereri();
    }

    public List<Cursa> findAll() {
        return cursaRepo.findAll();
    }


    @Transactional
    public Cursa validateCursa(long idSofer, long idCerere) {

        Cerere cerere = cerereService.getCerereById(idCerere);
        cerere.setRezervare(RezervareType.REZERVAT);
        cerere = cerereService.updateCerere(cerere);

        Sofer sofer = soferService.getSoferById(idSofer);
        Cursa cursa = new Cursa(EfectuareType.NEEFECTUATA, sofer, cerere);
        return cursaRepo.save(cursa);


    }

    @Transactional
    public Cursa executaCursa(long idCursa) {
        cursaRepo.updateCursaExecutie(EfectuareType.EFECTUATA,idCursa);
        return findCursaById(idCursa);
    }



    public Cursa findCursaById(long idCursa)
    {
        Optional<Cursa> cursaOptional = cursaRepo.findById(idCursa);
        if(cursaOptional.isPresent())
        {
            return cursaOptional.get();
        }
        else
        {
            throw new CursaNotFoundException(idCursa);
        }

    }



    public List<Cursa> getCursaBySoferId(long idSofer) {
        Sofer sofer = soferService.getSoferById(idSofer);
       return sofer.getCurse();
    }

    @Transactional
    public void deleteById(Long id) {
        Optional<Cursa> cursaOptional = cursaRepo.findById(id);
        if (!cursaOptional.isPresent()) {
            throw new RuntimeException("Cursa not found!");
        }
        cursaRepo.deleteById(id);
    }
}