package com.unibuc.assig.FinalProject.repos;

import com.unibuc.assig.FinalProject.models.Sofer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoferRepo extends JpaRepository<Sofer, Long> {
}
