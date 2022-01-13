package com.unibuc.assig.FinalProject.repos;

import com.unibuc.assig.FinalProject.models.Masina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasinaRepo extends JpaRepository<Masina, Long> {
}
