package com.mobileapplication.service.impl;

import com.mobileapplication.dao.OptionDao;
import com.mobileapplication.domain.Option;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class OptionServiceImplTest {


    @Mock
    OptionDao optionDao;

    @InjectMocks
    OptionServiceImpl optionService;

    @BeforeMethod
    public void setup() throws Exception{
        MockitoAnnotations.initMocks(this);

       List<Option> optionList = new ArrayList<>();
        Option option = new Option();
        option.setOptionId(1);
        optionList.add(option);

        when(this.optionDao.findAll()).thenReturn(optionList);
        when(this.optionDao.findOptionById(1)).thenReturn(option);
        doNothing().when(this.optionDao).save(option);
        doNothing().when(this.optionDao).removeOption(option);

    }
    @Test
    public void testOptionList() throws Exception{
        List<Option> expectedList = new ArrayList<>();
        Option option = new Option();
        option.setOptionId(1);
        expectedList.add(option);

        optionService.optionList();

        verify(optionDao).findAll();
    }

    @Test
    public void testFindOptionById() throws Exception{
        Option expectedOption = new Option();
        expectedOption.setOptionId(1);

        optionService.findOptionById(1);

        verify(optionDao).findOptionById(expectedOption.getOptionId());
    }
    @Test
    public void testSaveOption() throws Exception{
        Option expectedOption = new Option();
        optionService.saveOption(expectedOption);
        verify(optionDao).save(expectedOption);
    }
    @Test
    public void testRemoveOption() throws Exception{
        Option expectedOption = new Option();
        optionService.removeOption(expectedOption);
        verify(optionDao).removeOption(expectedOption);
    }
}
