package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Agent;

public interface AgentRepo extends JpaRepository<Agent,Integer>{

    
} 
