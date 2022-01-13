package com.unibuc.assig.FinalProject.services;

import com.unibuc.assig.FinalProject.exceptions.notFoundExceptions.SoferNotFoundException;
import com.unibuc.assig.FinalProject.models.Buletin;
import com.unibuc.assig.FinalProject.models.Masina;
import com.unibuc.assig.FinalProject.models.Sofer;
import com.unibuc.assig.FinalProject.repos.SoferRepo;
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
public class SoferServiceTest {

    @Mock
    private SoferRepo soferRepo;
    @Mock
    private MasinaService masinaService;
    @Mock
    private BuletinService buletinService;
    @InjectMocks
    private SoferService soferService;

    @Test
    @DisplayName("Create sofer Account")
    void createSoferAccount() {
        //arrage
        Buletin buletin = new Buletin();
        Masina masina = new Masina();
        Sofer sofer = new Sofer();
        buletin.setCnp("8546621");
        sofer.setBuletin(buletin);
        sofer.setMasina(masina);
        when(buletinService.addBuletin(sofer.getBuletin()))
                .thenReturn(buletin);
        when(masinaService.addMasina(sofer.getMasina()))
                .thenReturn(masina);

        when(soferRepo.save(sofer)).thenReturn(sofer);
        //act
        Sofer soferResponse = soferService.createSoferAccount(sofer);
        //assert
        assertNotNull(soferResponse);
    }

    @Test
    @DisplayName("Get sofer by Id when Sofer is null")
    void getSoferByIdSoferNull() {
        //aragge
        long idSofer=5;
        Sofer sofer = new Sofer();
        when(soferRepo.findById(anyLong()))
                .thenReturn(Optional.empty());
        //act
        SoferNotFoundException exception = assertThrows(SoferNotFoundException.class,
                () -> soferService.getSoferById(idSofer));
        //assert
        assertEquals("Sofer with id "+ idSofer+ " doesn't exist!", exception.getMessage());

    }

    @Test
    @DisplayName("Get sofer by Id when Sofer sofer exists")
    void getSoferByIdSoferExists()
    {
        //arrage
        long idSofer=5;
        Sofer sofer = new Sofer();
        sofer.setId(idSofer);
        when(soferRepo.findById(anyLong())).thenReturn(Optional.of(sofer));

        //act
        Sofer soferResponse = soferService.getSoferById(idSofer);

        //assert
        assertNotNull(soferResponse);
        assertEquals(sofer.getId(), soferResponse.getId());
    }



}