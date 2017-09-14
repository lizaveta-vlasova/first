package com.mobileapplication.service.impl;


import com.mobileapplication.dao.ClientDao;
import com.mobileapplication.domain.Client;
import com.mobileapplication.domain.Contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {



    @Autowired
    ClientDao clientDao;

    Client currentClient;

    Contract currentContract;

    public Client login(Integer id) {
        currentClient = (Client) clientDao.getClientById(id);
        return currentClient;
    }

    public void loginByEmail(String email) {
        currentClient = clientDao.findByUserEmail(email);
    }





    public Client getCurrentClient() {
        return currentClient;
    }

    public void setCurrentClient(Client currentClient) {
        this.currentClient = currentClient;
    }




    public Contract getCurrentContract() {
        return currentContract;
    }

    public void setCurrentContract(Contract currentContract) {
        this.currentContract = currentContract;
    }


}
