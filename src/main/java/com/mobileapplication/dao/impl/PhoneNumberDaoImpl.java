package com.mobileapplication.dao.impl;


import com.mobileapplication.dao.PhoneNumberDao;
import com.mobileapplication.domain.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Component
public class PhoneNumberDaoImpl implements PhoneNumberDao{
    @Autowired
    EntityManager entityManager;

    @Override
    public List<PhoneNumber> findAll() {

        Query query = entityManager.createQuery("SELECT e FROM PhoneNumber e where e.contractId = null ");
        List numbers = query.getResultList();
        return (List<PhoneNumber>) numbers;
    }
}
