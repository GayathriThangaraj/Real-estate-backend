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

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {
    @Autowired
    CustomerService cs;

     @PostMapping("/post/customer")
    public Customer add( @RequestBody Customer c)
    {
       return cs.create1(c) ;
    }

    //get
    @GetMapping("/get/customer")
    public ResponseEntity<List<Customer>> show()
    {
        return new ResponseEntity<>(cs.gett1(),HttpStatus.OK);
    }

    //get by id
    @GetMapping("/get/customer/{cust_addr}")
    public ResponseEntity<Customer> show(@PathVariable("cust_addr") String cust_addr)
    {
        return new ResponseEntity<>(cs.get11(cust_addr),HttpStatus.OK);
    }

    //put
    @SuppressWarnings("null")
    @PutMapping("/put/customer/{cust_addr}")
    public ResponseEntity<Customer> updateLogin(@PathVariable("cust_addr") String cust_addr,@RequestBody Customer c )
    {   
        if(cs.update1(cust_addr, c)==true)
        {

            return new ResponseEntity<>(c,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    //DELETE
    @DeleteMapping("/delete/customer/{cust_addr}")
    public ResponseEntity<Boolean> deleteLogin(@PathVariable("cust_addr") String cust_addr)
    {
        if(cs.delete(cust_addr)==true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    
}
