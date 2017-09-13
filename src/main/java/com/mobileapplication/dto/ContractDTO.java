package com.mobileapplication.dto;


import com.mobileapplication.domain.Option;
import com.mobileapplication.domain.Tariff;

import java.util.Set;

public class ContractDTO {
    private Integer id;
    private String number;
    private Set<Option> options;
    private Integer isBlockedByUser;
    private Integer isBlockedByAdmin;
    private Tariff tariff;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }

    public Integer getIsBlockedByUser() {
        return isBlockedByUser;
    }

    public void setIsBlockedByUser(Integer isBlockedByUser) {
        this.isBlockedByUser = isBlockedByUser;
    }

    public Integer getIsBlockedByAdmin() {
        return isBlockedByAdmin;
    }

    public void setIsBlockedByAdmin(Integer isBlockedByAdmin) {
        this.isBlockedByAdmin = isBlockedByAdmin;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }
}
