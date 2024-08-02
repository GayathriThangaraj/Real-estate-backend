package com.example.demo.model;



import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity
public class Property {
    @Id
    private int property_id;
    private String location;
    private int budget;
    private String type;
    private String agent;


    public Property() {
    }
    public Property(int property_id, String location, int budget, String type, String agent) {
        this.property_id = property_id;
        this.location = location;
        this.budget = budget;
        this.type = type;
        this.agent = agent;
    }
    public int getProperty_id() {
        return property_id;
    }
    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getBudget() {
        return budget;
    }
    public void setBudget(int budget) {
        this.budget = budget;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getAgent() {
        return agent;
    }
    public void setAgent(String agent) {
        this.agent = agent;
    }
}
