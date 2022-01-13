package com.unibuc.assig.FinalProject.repos;

import com.unibuc.assig.FinalProject.models.Cursa;
import com.unibuc.assig.FinalProject.models.EfectuareType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CursaRepo extends JpaRepository<Cursa, Long> {

    @Modifying
    @Query("update Cursa cursa set cursa.executie = :efectuareType where cursa.id = :id" )
    void updateCursaExecutie(EfectuareType efectuareType, long id);
}
