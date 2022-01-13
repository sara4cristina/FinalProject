package com.unibuc.assig.FinalProject.services;

import com.unibuc.assig.FinalProject.exceptions.notFoundExceptions.CerereNotFoundException;
import com.unibuc.assig.FinalProject.exceptions.notFoundExceptions.SoferNotFoundException;
import com.unibuc.assig.FinalProject.models.Cerere;
import com.unibuc.assig.FinalProject.models.Sofer;
import com.unibuc.assig.FinalProject.repos.CerereRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CerereServiceTest {

    @Mock
    private CerereRepo cerereRepo;
    @Mock
    private ClientService clientService;
    @InjectMocks
    private CerereService cerereService;


    @Test
    @DisplayName("Get Cerere by Id when Cerere is null")
    void getCerereByIdCerereNull() {
        //aragge
        long idCerere=5;
        Cerere cerere = new Cerere();
        when(cerereRepo.findById(anyLong()))
                .thenReturn(Optional.empty());
        //act
        CerereNotFoundException exception = assertThrows(CerereNotFoundException.class,
                () -> cerereService.getCerereById(idCerere));
        //assert
        assertEquals("Cerere with id "+ idCerere+ " doesn't exist!", exception.getMessage());

    }

    @Test
    @DisplayName("Get Cerere by Id when Cerere sofer exists")
    void getCerereByIdCerereExists()
    {
        //arrage
        long idCerere=5;
        Cerere cerere = new Cerere();
        cerere.setId(idCerere);
        when(cerereRepo.findById(anyLong())).thenReturn(Optional.of(cerere));

        //act
        Cerere cerereResponse = cerereService.getCerereById(idCerere);

        //assert
        assertNotNull(cerereResponse);
        assertEquals(cerere.getId(), cerereResponse.getId());
    }
}