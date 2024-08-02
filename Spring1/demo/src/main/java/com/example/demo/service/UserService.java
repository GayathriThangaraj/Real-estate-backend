package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    //post
    public User register(User u)
    {
       return userRepo.save(u);
    }

    //get
    public List<User> Login()
    {
       return userRepo.findAll();
    }

    //getbyid
    public User verifyLogIn(int id)
    {
       return userRepo.findById(id).orElse(null);
    }

     //update
     public boolean updateLogin(int Id,User u)
     {
         if(this.verifyLogIn(Id)==null)
         {
             return false;
         }
         try{
               userRepo.save(u);
         }
         catch(Exception e)
         {
             return false;
         }
         return true;
     }
 
     //delete
     public boolean delete(int Id)
     {
         if(this.verifyLogIn(Id)==null)
         {
             return false;
         }
         userRepo.deleteById(Id);
         return true;
     }
    
}
