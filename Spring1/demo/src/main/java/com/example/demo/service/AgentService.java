package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Agent;
import com.example.demo.repository.AgentRepo;

@Service
public class AgentService {
    @Autowired
    AgentRepo ar;

    //post
    public Agent updateProfile(Agent a)
    {
       return ar.save(a);
    }

    //get
    public List<Agent> gett1()
    {
       return ar.findAll();
    }

    //getbyid
    public Agent manageProperty(int agent_id)
    {
       return ar.findById(agent_id).orElse(null);
    }

     //update
     public boolean approveAppointment(int agent_id,Agent a)
     {
         if(this.manageProperty(agent_id)==null)
         {
             return false;
         }
         try{
               ar.save(a);
         }
         catch(Exception e)
         {
             return false;
         }
         return true;
     }
 
     //delete
     public boolean delete(int agent_id)
     {
         if(this.manageProperty(agent_id)==null)
         {
             return false;
         }
         ar.deleteById(agent_id);
         return true;
     }
    
}

