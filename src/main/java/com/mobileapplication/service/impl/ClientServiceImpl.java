package com.mobileapplication.service.impl;

import com.mobileapplication.dao.ClientDao;
import com.mobileapplication.domain.Client;
import com.mobileapplication.domain.ClientRole;
import com.mobileapplication.dto.ClientDTO;
import com.mobileapplication.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {


    @Autowired
    private ClientDao clientDao;

    private static Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);


    @Override
    public List<Client> clientList() {
        LOGGER.info("Get full client list");
        return clientDao.findAll();
    }

    @Override
    public Client getClientById (Integer id){
        LOGGER.info("Get client by ID");
        ClientDTO client1 = new ClientDTO();
        Client entity = clientDao.getClientById(id);
        client1.setId(entity.getId());
        client1.setFirst_name(entity.getFirst_name());
        client1.setSecond_name(entity.getSecond_name());
        client1.setDate_of_birth(entity.getDate_of_birth());
        client1.setPassport_number(entity.getPassport_number());
        client1.setAddress(entity.getAddress());
        client1.setEmail(entity.getEmail());
        client1.setPassword(entity.getPassword());
        client1.setContracts(entity.getContracts());
        client1.setClientRoles(entity.getClientRoles());
        return entity;
    }


    @Override
    public Client saveClient(Client client) {
        LOGGER.info("New client add");
          clientDao.saveClient(client);
        return client;
    }

    @Override
    public void updateClientInformation(Client client) {
        clientDao.updateClientInformation(client);
    }

    @Override
    public void deleteClient(Client client) {
        clientDao.deleteClient(client);
    }

    @Override
    public void saveRole(ClientRole clientRole) {
        clientDao.saveRole(clientRole);
    }


}


