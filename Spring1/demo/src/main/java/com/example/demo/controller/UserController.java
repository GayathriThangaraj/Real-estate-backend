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

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {
    @Autowired
    UserService us;

    @PostMapping("/post")
    public User addLoginData( @RequestBody User ul)
    {
       return us.register(ul) ;
    }

    //get
    @GetMapping("/get")
    public ResponseEntity<List<User>> showLoginDate()
    {
        return new ResponseEntity<>(us.Login(),HttpStatus.OK);
    }
    //get by id
    @GetMapping("/get/{id}")
    public ResponseEntity<User> show(@PathVariable("id") int id )
    {
        return new ResponseEntity<>(us.verifyLogIn(id),HttpStatus.OK);
    }

    //put
    @SuppressWarnings("null")
    @PutMapping("/put/{Id}")
    public ResponseEntity<User> updateLogin(@PathVariable("Id") int Id,@RequestBody User u )
    {   
        if(us.updateLogin(Id, u)==true)
        {

            return new ResponseEntity<>(u,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    //DELETE
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<Boolean> deleteLogin(@PathVariable("Id") int Id)
    {
        if(us.delete(Id)==true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    
}
