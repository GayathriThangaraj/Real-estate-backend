package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Agent {
    @Id
    private int agent_id;
    private String name;
    private String address;

    public Agent() {
    }
    public Agent(int agent_id, String name, String address) {
        this.agent_id = agent_id;
        this.name = name;
        this.address = address;
    }
    public int getId() {
        return agent_id;
    }
    public void setId(int agent_id) {
        this.agent_id = agent_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
   
}
