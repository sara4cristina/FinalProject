package com.unibuc.assig.FinalProject.repos.security;

import com.unibuc.assig.FinalProject.models.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
