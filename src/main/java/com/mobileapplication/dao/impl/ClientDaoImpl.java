package com.mobileapplication.dao.impl;

import com.mobileapplication.dao.ClientDao;
import com.mobileapplication.domain.Client;
import com.mobileapplication.domain.ClientRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Implementation of ClientDao.
 */
@Transactional
@Component
public class ClientDaoImpl implements ClientDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Client> findAll() {
        Query query = entityManager.createQuery("SELECT e FROM Client e");
        List <Client> clients = query.getResultList();
        return (List<Client>) clients;
    }

    @Override
    public Client getClientById(Integer id) {
        Query query = entityManager.createQuery("FROM Client where id = :id");
        query.setParameter("id", id);
        Client client = (Client) query.getSingleResult();
        return client;
    }

    @Override
    public void saveClient (Client client){
     entityManager.persist(client);
    }

    @Override
    public Client findByUserEmail(String email) {
        Query query = entityManager.createQuery("FROM Client where email = :email");
        query.setParameter("email", email);
        return (Client) query.getSingleResult();
    }

    @Override
    public void saveRoleForClient(ClientRole entity) {
        entityManager.persist(entity);
    }

    @Override
    public void updateClientInformation(Client client) {
        entityManager.merge(client);
    }

    @Override
    public void deleteClient(Client client) {
        entityManager.remove(entityManager.merge(client));
    }

    @Override
    public void saveRole(ClientRole clientRole) {
        entityManager.persist(clientRole);
    }
}
