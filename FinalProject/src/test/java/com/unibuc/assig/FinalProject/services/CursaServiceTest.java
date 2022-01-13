package com.unibuc.assig.FinalProject.services;

import com.unibuc.assig.FinalProject.exceptions.notFoundExceptions.ClientNotFoundException;
import com.unibuc.assig.FinalProject.exceptions.notFoundExceptions.CursaNotFoundException;
import com.unibuc.assig.FinalProject.models.Client;
import com.unibuc.assig.FinalProject.models.Cursa;
import com.unibuc.assig.FinalProject.repos.CursaRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CursaServiceTest {

    @Mock
    private CursaRepo cursaRepo;
    @Mock
    private CerereService cerereService;
    @Mock
    private SoferService soferService;

    @InjectMocks
    private CursaService cursaService;

    @Test
    @DisplayName("Find Cursa By Id when Cursa is null")
    void findCursaByIdCursaNull() {

        //aragge
        long idCursa=5;
        Cursa cursa = new Cursa();
        when(cursaRepo.findById(anyLong()))
                .thenReturn(Optional.empty());
        //act
        CursaNotFoundException exception = assertThrows(CursaNotFoundException.class,
                () -> cursaService.findCursaById(idCursa));
        //assert
        assertEquals("Cursa with id " +idCursa+ " doesn't exist!", exception.getMessage());

    }

    @Test
    @DisplayName("Get Cursa by Id when Cursa exists")
    void getCursaByIdSCursaExists()
    {
        //arrage
        long idCursa=5;
        Cursa cursa = new Cursa();
        cursa.setId(idCursa);

        when(cursaRepo.findById(anyLong())).thenReturn(Optional.of(cursa));

        //act
        Cursa cursaResponse = cursaService.findCursaById(idCursa);

        //assert
        assertNotNull(cursaResponse);
        assertEquals(cursa.getId(), cursaResponse.getId());
    }



    }
