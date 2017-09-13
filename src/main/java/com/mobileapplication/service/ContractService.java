package com.mobileapplication.service;

import com.mobileapplication.domain.Client;
import com.mobileapplication.domain.Contract;

import java.util.List;


public interface ContractService {

    List<Contract> findContractsByClient(Client client);

    Contract findContractById(Integer id);
    
    void updateContract(Contract contract);

    void addOptionByContractId(Integer optionId, Integer contractId);
    void removeOptionByContractId(Integer optionId, Integer contractId);
    void userBlocked (Contract contract);
    void userUnblocked(Contract contract);
    boolean isContractBlocked(Integer contractId);
    boolean isContractBlockedByUser (Integer contractId);
    boolean isContractBlockedByAdmin (Integer contractId);
    void userBlockedByAdmin(Contract contract);
    void userUnblockedByAdmin(Contract contract);
    Contract saveContract(Contract contract);

    Contract findContractByNumber(String number);

    void removeContract(Integer contractId);
}

