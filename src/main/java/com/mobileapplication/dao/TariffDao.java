package com.mobileapplication.dao;


import com.mobileapplication.domain.Tariff;

import java.util.List;

public interface TariffDao {

    List<Tariff> findAll();
    Tariff getTariffById(Integer id);
    void update(Tariff tariff);
    void save(Tariff tariff);
    void delete(Tariff tariff);
}
