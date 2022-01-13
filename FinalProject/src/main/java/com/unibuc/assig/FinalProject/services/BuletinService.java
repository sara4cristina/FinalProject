package com.unibuc.assig.FinalProject.services;

import com.unibuc.assig.FinalProject.models.Buletin;
import com.unibuc.assig.FinalProject.repos.BuletinRepo;
import org.springframework.stereotype.Service;

@Service
public class BuletinService {

    private BuletinRepo repo;

    public BuletinService(BuletinRepo repo) {
        this.repo = repo;
    }

    public Buletin addBuletin(Buletin buletin)
    {
        return repo.save(buletin);
    }
}
