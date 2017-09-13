package com.mobileapplication.dto;


import com.mobileapplication.domain.Option;
import com.mobileapplication.domain.Tariff;

import java.util.Set;

public class TariffDTO {
    private Tariff tariff;
    private Integer id;
    private Integer price;
    private String name;
    private String description;
    //private OptionNamesDTO optionNamesDTO;
    private Set<String> optionsNames;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public Set<String> getOptionsNames() {
        return optionsNames;
    }

    public void setOptionsNames(Set<String> optionsNames) {
        this.optionsNames = optionsNames;
    }

    /*public OptionNamesDTO getOptionNamesDTO() {
        return optionNamesDTO;
    }

    public void setOptionNamesDTO(OptionNamesDTO optionNamesDTO) {
        this.optionNamesDTO = optionNamesDTO;
    }*/
}
