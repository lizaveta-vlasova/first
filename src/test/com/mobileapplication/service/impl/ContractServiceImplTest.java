package com.mobileapplication.service.impl;


import com.mobileapplication.dao.ContractDao;
import com.mobileapplication.domain.Client;
import com.mobileapplication.domain.Contract;
import com.mobileapplication.domain.Option;
import com.mobileapplication.domain.Tariff;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

public class ContractServiceImplTest {

    @Mock
    ContractDao contractDao;

    @InjectMocks
    ContractServiceImpl contractService;

    @BeforeMethod
    public void setup() throws Exception{
        MockitoAnnotations.initMocks(this);
        List<Contract> contractList = new ArrayList();
        Contract contract = new Contract();
        contract.setIsBlockedByAdmin(1);
        contract.setId(1);
        contract.setNumber("12345");
        Client client = new Client();
        client.setId(1);
        Option option = new Option();
        option.setOptionId(1);

        when(this.contractDao.findContractsByClient(client)).thenReturn(contractList);
        when(this.contractDao.findContractById(contract.getId())).thenReturn(contract);
        doNothing().when(this.contractDao).update(contract);
        doNothing().when(this.contractDao).save(contract);
        when(this.contractDao.findContractByNumber("12345")).thenReturn(contract);
    }
    @Test
    public void testFindContractsByClient() throws Exception{
        List<Contract> expectedList = new ArrayList<>();
        Client client = new Client();
        client.setContracts(expectedList);
        contractService.findContractsByClient(client);
        verify(contractDao).findContractsByClient(client);

    }

    @Test
    public void testFindContractById() throws Exception{
        Contract expectedContract = new Contract();
        expectedContract.setId(1);
        contractService.findContractById(expectedContract.getId());
        verify(contractDao).findContractById(expectedContract.getId());
    }
    @Test
    public void testUppdateContract() throws Exception{
        Contract expectedContract = new Contract();
        expectedContract.setIsBlockedByAdmin(1);
        contractService.updateContract(expectedContract);
        verify(contractDao).update(expectedContract);

    }
    /*Test
    public void testAddOptionByContractId() throws Exception{
        Contract contract = new Contract();
        Option option = new Option();
        contract.setId(1);
        option.setOptionId(1);
        contractService.addOptionByContractId(option.getOptionId(), contract.getId());
        verify(contractDao).save(contract);
    }*/
    @Test
    public void testUserBlocked(){
        Contract contract = new Contract();
        contractService.userBlocked(contract);
        verify(contractDao).update(contract);
        }
    @Test
    public void testUserUnblocked() throws Exception{
        Contract contract = new Contract();
        contractService.userUnblocked(contract);
        verify(contractDao).update(contract);
    }
    @Test
    public void testUserBlockedByAdmin() throws Exception{
        Contract contract = new Contract();
        contractService.userBlockedByAdmin(contract);
        verify(contractDao).update(contract);
    }
    @Test
    public void testUserUnlockedByAdmin() throws Exception{
        Contract contract = new Contract();
        contractService.userUnblockedByAdmin(contract);
        verify(contractDao).update(contract);
    }
    @Test
    public void testSaveContract() throws Exception{
        Contract contract = new Contract();
        contractService.saveContract(contract);
        verify(contractDao).save(contract);
    }
    @Test
    public void testFindCOntractByNumber() throws Exception{
        Contract contract = new Contract();
        contract.setNumber("12345");
        contractService.findContractByNumber("12345");
        verify(contractDao).findContractByNumber("12345");
    }
    @Test
    public void testRemoveConctract() throws Exception{
        Contract contract = new Contract();
        contract.setId(1);
        contractService.removeContract(contract.getId());
        verify(contractDao).deleteContractById(contract.getId());
    }



}
