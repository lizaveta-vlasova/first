package com.mobileapplication.service.impl;

import com.mobileapplication.dao.ContractDao;
import com.mobileapplication.dao.OptionDao;
import com.mobileapplication.domain.Client;
import com.mobileapplication.domain.Contract;
import com.mobileapplication.domain.Option;
import com.mobileapplication.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractDao contractDao;


    @Autowired
    OptionDao optionDao;


    @Override
    public List<Contract> findContractsByClient(Client client) {
        return contractDao.findContractsByClient(client);

    }

    public Contract findContractById(Integer id) {
        return contractDao.findContractById(id);

    }

    @Override
    public void updateContract(Contract contract) {
        contractDao.update(contract);
    }

    @Override
    public void addOptionByContractId(Integer optionId, Integer contractId) {
        Contract contract = contractDao.findContractById(contractId);
        Option option = optionDao.findOptionById(optionId);
        contract.getOptions().add(option);
        contractDao.save(contract);
    }

    @Override
    public void removeOptionByContractId(Integer optionId, Integer contractId) {
        Contract contract = contractDao.findContractById(contractId);
        Option option = optionDao.findOptionById(optionId);
        contract.getOptions().remove(option);
        contractDao.save(contract);
    }

    @Override
    public void userBlocked(Contract contract) {
        contract.setIsBlockedByUser(1);
        contractDao.update(contract);
    }

    public void userUnblocked(Contract contract) {
        contract.setIsBlockedByUser(0);
        contractDao.update(contract);
    }

    public boolean isContractBlocked(Integer contractId){
        Contract contract = contractDao.findContractById(contractId);
        if(contract.getIsBlockedByAdmin() > 0 || contract.getIsBlockedByUser() > 0){
            return true;
        }
        return false;
    }

    public boolean isContractBlockedByUser(Integer contractId) {
        Contract contract = contractDao.findContractById(contractId);
        if (contract.getIsBlockedByUser() > 0 ) return true;
        else return false;
    }
    public boolean isContractBlockedByAdmin(Integer contractId) {
        Contract contract = contractDao.findContractById(contractId);
        if (contract.getIsBlockedByAdmin() > 0 ) return true;
        else return false;
    }

    @Override
    public void userBlockedByAdmin(Contract contract) {
        contract.setIsBlockedByAdmin(1);
        contractDao.update(contract);
    }

    @Override
    public void userUnblockedByAdmin(Contract contract) {
        contract.setIsBlockedByAdmin(0);
        contractDao.update(contract);
    }

    @Override
    public Contract saveContract(Contract contract) {
        contractDao.save(contract);
        return contract;
    }

    @Override
    public Contract findContractByNumber(String number) {
        return contractDao.findContractByNumber(number);
    }

    @Override
    public void removeContract(Integer contractId) {
        contractDao.deleteContractById(contractId);
    }

}
