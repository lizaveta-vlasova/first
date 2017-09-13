package com.mobileapplication.service;

import com.mobileapplication.domain.Client;
import com.mobileapplication.domain.ClientRole;
import com.mobileapplication.dto.ClientDTO;

import java.util.List;

public interface ClientService {
     List<Client>clientList();

     Client getClientById(Integer id);

     Client saveClient(Client client);

     void updateClientInformation(Client client);

     void deleteClient(Client client);

     void saveRole(ClientRole clientRole);




}
