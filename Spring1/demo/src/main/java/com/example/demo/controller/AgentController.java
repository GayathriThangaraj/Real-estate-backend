package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Agent;
import com.example.demo.service.AgentService;

@RestController
public class AgentController 
{
    @Autowired
    AgentService as;
     
    @PostMapping("/post/agent")
    public Agent add( @RequestBody Agent a)
    {
       return as.updateProfile(a) ;
    }

    //get
    @GetMapping("/get/agent")
    public ResponseEntity<List<Agent>> show()
    {
        return new ResponseEntity<>(as.gett1(),HttpStatus.OK);
    }

    //get by id
    @GetMapping("/get/agent/{agent_id}")
    public ResponseEntity<Agent> show(@PathVariable("agent_id") int agent_id)
    {
        return new ResponseEntity<>(as.manageProperty(agent_id),HttpStatus.OK);
    }

    //put
    @SuppressWarnings("null")
    @PutMapping("/put/agent/{agent_id}")
    public ResponseEntity<Agent> updateLogin(@PathVariable("agent_id") int agent_id,@RequestBody Agent a )
    {   
        if(as.approveAppointment(agent_id, a)==true)
        {

            return new ResponseEntity<>(a,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    //DELETE
    @DeleteMapping("/delete/agent/{agent_id}")
    public ResponseEntity<Boolean> deleteLogin(@PathVariable("agent_id") int agent_id)
    {
        if(as.delete(agent_id)==true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
