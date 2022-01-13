package com.unibuc.assig.FinalProject.repos;

import com.unibuc.assig.FinalProject.models.Buletin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuletinRepo extends JpaRepository<Buletin,Long> {
}
