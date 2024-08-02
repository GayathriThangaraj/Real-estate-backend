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

import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

     @PostMapping("/post/admin")
    public Admin add( @RequestBody Admin admin)
    {
       return adminService.addProperty(admin);
    }

     @PostMapping("/post/admin/agent")
    public Admin add1( @RequestBody Admin admin)
    {
       return adminService.addAgent(admin);
    }

    //get
    @GetMapping("/get/admin")
    public ResponseEntity<List<Admin>> show()
    {
        return new ResponseEntity<>(adminService.gett1(),HttpStatus.OK);
    }

    //get by id
    @GetMapping("/get/admin/{id}")
    public ResponseEntity<Admin> show(@PathVariable("id") int admin_id)
    {
        return new ResponseEntity<>(adminService.generateReport(admin_id),HttpStatus.OK);
    }

    //put
    @SuppressWarnings("null")
    @PutMapping("/put/admin/{id}")
    public ResponseEntity<Admin> updateLogin(@PathVariable("id") int admin_id,@RequestBody Admin admin )
    {   
        if(adminService.approvePayment(admin_id, admin)==true)
        {

            return new ResponseEntity<>(admin,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    //DELETE
    @DeleteMapping("/delete/admin/{id}")
    public ResponseEntity<Boolean> deleteLogin(@PathVariable("id") int admin_id)
    {
        if(adminService.deleteAgent(admin_id)==true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
