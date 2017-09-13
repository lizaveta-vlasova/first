package com.mobileapplication.dao;


import com.mobileapplication.domain.Client;
import com.mobileapplication.domain.Contract;

import java.util.List;

public interface ContractDao {
 Contract findContractById(Integer id);
 Contract findContractByNumber(String number);
 void save(Contract contract);
 void update(Contract contract);
 void deleteContractById(Integer id);
 List<Contract> findContractsByClient(Client client);

}
