package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


@Entity
public class Customer {
    @Id
    private String cust_addr;
    private float acc_bal;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private User user;

    public Customer() {
    }
    public Customer(String cust_addr, float acc_bal) {
        this.cust_addr = cust_addr;
        this.acc_bal = acc_bal;
    }
    public String getCust_addr() {
        return cust_addr;
    }
    public void setCust_addr(String cust_addr) {
        this.cust_addr = cust_addr;
    }
    public float getAcc_bal() {
        return acc_bal;
    }
    public void setAcc_bal(float acc_bal) {
        this.acc_bal = acc_bal;
    }
    
}
