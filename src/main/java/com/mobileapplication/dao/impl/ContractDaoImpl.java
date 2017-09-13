package com.mobileapplication.dao.impl;

import com.mobileapplication.dao.ContractDao;
import com.mobileapplication.domain.Client;
import com.mobileapplication.domain.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
@EnableTransactionManagement
public class ContractDaoImpl implements ContractDao {

    @Autowired
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Contract findContractById(Integer id) {
        Query query = entityManager.createQuery("FROM Contract where id = :id");
        query.setParameter("id", id);
        Contract contract = (Contract) query.getSingleResult();
        return contract;
    }

    @Override
    public Contract findContractByNumber(String number) {
        Query query = entityManager.createQuery("from Contract where number = :number");
        query.setParameter("number", number);
        Contract contract = (Contract) query.getSingleResult();
        return contract;
    }

    @Override
    public void save(Contract entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(Contract contract) {
        entityManager.merge(contract);
    }

    @Override
    public void deleteContractById(Integer id) {
        /*Query query = entityManager.createNativeQuery("DELETE FROM contract WHERE id = " + id);
        query.executeUpdate();*/
        Contract contract = entityManager.find(Contract.class, id);
        if (id != 0){
            entityManager.remove(contract);
        }
    }

    @Override
    public List<Contract> findContractsByClient(Client client) {
        Query query = entityManager.createQuery("SELECT c FROM Contract c WHERE c.client.id = :id");
        query.setParameter("id", client.getId());
        return (List<Contract>) query.getResultList();
    }


}
