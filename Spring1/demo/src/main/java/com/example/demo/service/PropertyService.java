package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Property;
import com.example.demo.repository.PropertyRepo;

@Service
public class PropertyService {
    @Autowired
    PropertyRepo pr;

    //post
    public Property create1(Property p)
    {
       return pr.save(p);
    }

    //get
    public List<Property> gett1()
    {
       return pr.findAll();
    }

    //getbyid
    public Property get11(int property_id)
    {
       return pr.findById(property_id).orElse(null);
    }

     //update
     public boolean update1(int property_id,Property p)
     {
         if(this.get11(property_id)==null)
         {
             return false;
         }
         try{
               pr.save(p);
         }
         catch(Exception e)
         {
             return false;
         }
         return true;
     }
 
     //delete
     public boolean delete(int property_id)
     {
         if(this.get11(property_id)==null)
         {
             return false;
         }
         pr.deleteById(property_id);
         return true;
     }
    
}


//sortAccordingToLocation()
//sortAccordingToPrice()
