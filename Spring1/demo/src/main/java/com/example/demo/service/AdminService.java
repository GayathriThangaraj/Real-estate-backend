package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepo;

@Service
public class AdminService {

    @Autowired
    AdminRepo adminRepo;

     //post
    public Admin addProperty(Admin admin)
    {
       return adminRepo.save(admin);
    }

     //post
    public Admin addAgent(Admin admin)
    {
       return adminRepo.save(admin);
    }

    //get
    public List<Admin> gett1()
    {
       return adminRepo.findAll();
    }

    //getbyid
    public Admin generateReport(int admin_id)
    {
       return adminRepo.findById(admin_id).orElse(null);
    }

     //update
     public boolean approvePayment(int admin_id,Admin admin)
     {
         if(this.generateReport(admin_id)==null)
         {
             return false;
         }
         try{
               adminRepo.save(admin);
         }
         catch(Exception e)
         {
             return false;
         }
         return true;
     }
 
     //delete
     public boolean deleteAgent(int admin_id)
     {
         if(this.generateReport(admin_id)==null)
         {
             return false;
         }
         adminRepo.deleteById(admin_id);
         return true;
     }
    
    
}
