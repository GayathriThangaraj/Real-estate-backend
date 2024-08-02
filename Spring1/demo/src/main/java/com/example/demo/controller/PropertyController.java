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

import com.example.demo.model.Property;
import com.example.demo.service.PropertyService;

@RestController
public class PropertyController {
    @Autowired
    PropertyService ps;

    @PostMapping("/post/property")
    public Property add( @RequestBody Property p)
    {
       return ps.create1(p) ;
    }

    //get
    @GetMapping("/get/property")
    public ResponseEntity<List<Property>> show()
    {
        return new ResponseEntity<>(ps.gett1(),HttpStatus.OK);
    }

    //get by id
    @GetMapping("/get/property/{id}")
    public ResponseEntity<Property> show(@PathVariable("id") int property_id)
    {
        return new ResponseEntity<>(ps.get11(property_id),HttpStatus.OK);
    }

    //put
    @SuppressWarnings("null")
    @PutMapping("/put/property/{id}")
    public ResponseEntity<Property> updateLogin(@PathVariable("id") int property_id,@RequestBody Property p )
    {   
        if(ps.update1(property_id, p)==true)
        {

            return new ResponseEntity<>(p,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    //DELETE
    @DeleteMapping("/delete/property/{id}")
    public ResponseEntity<Boolean> deleteLogin(@PathVariable("id") int property_id)
    {
        if(ps.delete(property_id)==true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
    
}
