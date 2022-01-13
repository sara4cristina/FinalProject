package com.unibuc.assig.FinalProject.repos;

import com.unibuc.assig.FinalProject.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {
}
