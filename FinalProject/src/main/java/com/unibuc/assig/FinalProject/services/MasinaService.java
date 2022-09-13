package com.unibuc.assig.FinalProject.services;

import com.unibuc.assig.FinalProject.models.Masina;
import com.unibuc.assig.FinalProject.repos.MasinaRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class MasinaService {

    @Autowired
    private MasinaRepo masinaRepo;

    public MasinaService(MasinaRepo masinaRepo) {
        this.masinaRepo = masinaRepo;
    }

    public Masina addMasina(Masina masina){
        log.info("masina in repo" +masina.toString());
        return masinaRepo.save(masina);
    }

    public List<Masina> findAll(){
        return masinaRepo.findAll();
    }


    @Transactional
    public void deleteById(Long id) {
        Optional<Masina> masinaOptional = masinaRepo.findById(id);
        if (!masinaOptional.isPresent()) {
            throw new RuntimeException("Masina not found!");
        }
        masinaRepo.deleteById(id);

    }
}
