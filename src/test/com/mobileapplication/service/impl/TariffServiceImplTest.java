package com.mobileapplication.service.impl;


import com.mobileapplication.dao.OptionDao;
import com.mobileapplication.dao.TariffDao;
import com.mobileapplication.domain.Option;
import com.mobileapplication.domain.Tariff;
import com.mobileapplication.dto.TariffDTO;
import com.mobileapplication.mq.Sender;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TariffServiceImplTest {


    @Mock
    TariffDao tariffDao;

    @Mock
    OptionDao optionDao;

    @Mock
    Sender sender;

    @InjectMocks
    private TariffServiceImpl tariffService;

    @BeforeMethod
    public void setup() throws Exception{
        MockitoAnnotations.initMocks(this);

        List<Tariff> tariffList = new ArrayList<>();
        Tariff tariff = new Tariff();
        tariff.setId(1);
        tariffList.add(tariff);
        tariffList.remove(tariff);
        tariff.setName("dada");
        Option option = new Option();
        option.setOptionId(1);



        when(this.tariffDao.findAll()).thenReturn(tariffList);
        when(this.tariffDao.getTariffById(1)).thenReturn(tariff);
        doNothing().when(this.tariffDao).update(tariff);
       // doNothing().when(this.sender).send(tariffList);


    }

    @Test
    public void testTariffList() throws Exception{
        List<Tariff> expected = new ArrayList<>();
        Tariff tariff = new Tariff();
        tariff.setId(1);
        expected.add(tariff);

        tariffService.tariffList();

        verify(tariffDao).findAll();

    }
    @Test
    public void testGetTariffById() throws Exception{
        Tariff expectedTariff = new Tariff();
        expectedTariff.setId(1);

        tariffService.getTariffById(expectedTariff.getId());

        verify(tariffDao).getTariffById(expectedTariff.getId());
    }
    /*@Test
    public void testChangeTariff() throws Exception{
        Tariff expectedTariff = new Tariff();
        expectedTariff.setName("dada");

        tariffService.changeTariff(expectedTariff);
        tariffDao.update(expectedTariff);
        verify(sender).send(tariffDao.findAll());
    }*/
    @Test
    public void testAddNewTariff() throws Exception{
        Tariff expectedTariff = new Tariff();
        tariffService.addNewTariff(expectedTariff);
        verify(tariffDao).save(expectedTariff);
    }
    @Test
    public void testRemoveTariff() throws Exception{
        Tariff expectedTariff = new Tariff();
        tariffService.removeTariff(expectedTariff);
        verify(tariffDao).delete(expectedTariff);
    }
   /* @Test
    public void testAddOptionByTariffId() throws Exception{
        Tariff expectedTariff = new Tariff();
        Option expectedOption = new Option();
        expectedOption.setOptionId(1);
        expectedTariff.setId(1);
        tariffService.addOptionByTariffId(expectedTariff.getId(), expectedOption.getOptionId());
        verify(sender).send();
    }

*/
}
