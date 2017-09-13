package com.mobileapplication.dao;


import com.mobileapplication.domain.Client;
import com.mobileapplication.domain.ClientRole;

import java.util.List;

/**
 *  Client DAO
 */
public interface ClientDao {
    /**
     * FInd all {@link Client}
     *
     * @return List of {@link Client}
     */
    List<Client> findAll();
    Client getClientById(Integer id);
    void saveClient(Client client);
    Client findByUserEmail(String email);
    void saveRoleForClient(ClientRole clientRole);
    void updateClientInformation(Client client);
    void deleteClient(Client client);
    void saveRole(ClientRole clientRole);
}
