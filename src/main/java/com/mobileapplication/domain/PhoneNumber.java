package com.mobileapplication.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PhoneNumber {


    @Id
    @Column(name = "number")
     private String number;

    private Integer contractId;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
