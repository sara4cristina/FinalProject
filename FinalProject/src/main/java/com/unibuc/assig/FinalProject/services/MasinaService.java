package com.unibuc.assig.FinalProject.services;

import com.unibuc.assig.FinalProject.models.Masina;
import com.unibuc.assig.FinalProject.repos.MasinaRepo;
import org.springframework.stereotype.Service;


@Service
public class MasinaService {


    private MasinaRepo repo;

    public MasinaService(MasinaRepo repo) {
        this.repo = repo;
    }

    public Masina addMasina(Masina masina)
    {
        return repo.save(masina);
    }
}
