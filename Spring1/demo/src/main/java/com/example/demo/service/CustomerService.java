package com.example.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepo;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo cr;

    
    //post
    public Customer create1(Customer c)
    {
       return cr.save(c);
    }

    //get
    public List<Customer> gett1()
    {
       return cr.findAll();
    }

    //getbyid
    public Customer get11(String cust_addr)
    {
       return cr.findById(cust_addr).orElse(null);
    }

     //update
     public boolean update1(String cust_addr,Customer c)
     {
         if(this.get11(cust_addr)==null)
         {
             return false;
         }
         try{
               cr.save(c);
         }
         catch(Exception e)
         {
             return false;
         }
         return true;
     }
 
     //delete
     public boolean delete(String cust_addr)
     {
         if(this.get11(cust_addr)==null)
         {
             return false;
         }
         cr.deleteById(cust_addr);
         return true;
     }
    
}


