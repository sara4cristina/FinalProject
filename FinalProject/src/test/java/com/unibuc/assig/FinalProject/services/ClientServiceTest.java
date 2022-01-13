package com.unibuc.assig.FinalProject.services;

import com.unibuc.assig.FinalProject.exceptions.notFoundExceptions.ClientNotFoundException;
import com.unibuc.assig.FinalProject.exceptions.notFoundExceptions.SoferNotFoundException;
import com.unibuc.assig.FinalProject.models.Client;
import com.unibuc.assig.FinalProject.models.Sofer;
import com.unibuc.assig.FinalProject.repos.ClientRepo;
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
public class ClientServiceTest {

    @Mock
    private ClientRepo clientRepo;

    @InjectMocks
    private ClientService clientService;

        @Test
        @DisplayName("Get Clint by Id when Client exists")
        void getClientByIdSClientExists()
        {
            //arrage
            long idClient=5;
            Client client = new Client();
            client.setId(idClient);

            when(clientRepo.findById(anyLong())).thenReturn(Optional.of(client));

            //act
            Client clientResponse = clientService.getClientById(idClient);

            //assert
            assertNotNull(clientResponse);
            assertEquals(client.getId(), clientResponse.getId());
        }


    @Test
    @DisplayName("Get Clint by Id when Client is null")
    void getClientByIdSClientNull()
    {
        //aragge
        long idClient=5;
        Client client = new Client();
        when(clientRepo.findById(anyLong()))
                .thenReturn(Optional.empty());
        //act
        ClientNotFoundException exception = assertThrows(ClientNotFoundException.class,
                () -> clientService.getClientById(idClient));
        //assert
        assertEquals("Client with id "+ idClient+ " doesn't exist!", exception.getMessage());

    }

}