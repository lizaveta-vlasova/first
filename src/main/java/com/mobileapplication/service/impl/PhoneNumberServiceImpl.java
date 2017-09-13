package com.mobileapplication.service.impl;


import com.mobileapplication.dao.PhoneNumberDao;
import com.mobileapplication.domain.PhoneNumber;
import com.mobileapplication.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {
    @Autowired
    private PhoneNumberDao phoneNumberDao;

    @Override
    public List<PhoneNumber> numberList() {
       return phoneNumberDao.findAll();
    }



}
