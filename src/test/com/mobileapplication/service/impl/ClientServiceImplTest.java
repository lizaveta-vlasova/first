package com.mobileapplication.service.impl;

import com.mobileapplication.dao.ClientDao;
import com.mobileapplication.domain.Client;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.*;
import static org.mockito.Mockito.when;


public class ClientServiceImplTest {



    @Mock
    ClientDao clientDao;

    @InjectMocks
    private ClientServiceImpl clientService;

    @BeforeMethod
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        List<Client> clientList = new ArrayList<>();
        Client client = new Client();
        client.setId(1);
        clientList.add(client);

        when(this.clientDao.findAll()).thenReturn(clientList);
        when(this.clientDao.getClientById(1)).thenReturn(client);
        doNothing().when(this.clientDao).saveClient(client);

    }

    @Test
    public void testClientList() throws Exception {
        List<Client> expected = new ArrayList<>();
        Client client = new Client();
        client.setId(1);
        expected.add(client);

        List<Client> actual = clientService.clientList();

        assertEquals(actual.get(0).getId(), expected.get(0).getId());
    }


    @Test
    public void testGetClientById() throws Exception {
        Client expectedClient = new Client();
        expectedClient.setId(1);

        clientService.getClientById(expectedClient.getId());

        verify(clientDao).getClientById(expectedClient.getId());
    }

    @Test
    public void testSaveClient() throws Exception {
        Client expectedClient = new Client();

        clientService.saveClient(expectedClient);

        verify(clientDao).saveClient(expectedClient);
    }

}