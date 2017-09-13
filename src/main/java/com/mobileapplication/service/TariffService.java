package com.mobileapplication.service;


import com.mobileapplication.domain.Option;
import com.mobileapplication.domain.Tariff;
import com.mobileapplication.dto.TariffDTO;

import java.util.List;
import java.util.Set;

public interface TariffService {
    List<Tariff>tariffList();

    void changeTariff(Tariff tariff);

    Tariff getTariffById(Integer id);

    Tariff addNewTariff(Tariff tariff);

    void removeTariff(Tariff tariff);

    void addOptionByTariffId(Integer tariffId, Integer optionId);
    void removeOptionByTariffId(Integer tariffId, Integer optionId);
    boolean isOptionsCompatible(Set<Option> uncompatibleOption, Set<Option> optionList);
}
