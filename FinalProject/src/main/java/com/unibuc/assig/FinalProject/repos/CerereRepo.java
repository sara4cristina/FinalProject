package com.unibuc.assig.FinalProject.repos;

import com.unibuc.assig.FinalProject.models.Cerere;
import com.unibuc.assig.FinalProject.models.RezervareType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.Optional;

@Repository
public interface CerereRepo extends JpaRepository<Cerere, Long> {



    Optional<Cerere> findById(long id);

    List<Cerere> findAllByRezervareEquals(RezervareType rezervareType);

                                                           @Modifying
    @Query( value = "update Cerere cer set cer.rezervare = :rezervareType where cer.id = :id")
    void updateRezervareCerere(RezervareType rezervareType, long id);


}
