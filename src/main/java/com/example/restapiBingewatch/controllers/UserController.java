package com.example.restapiBingewatch.controllers;

import com.example.restapiBingewatch.models.Customized;
import com.example.restapiBingewatch.models.users;
import com.example.restapiBingewatch.services.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
@CrossOrigin("*")
@Controller
public class UserController {


    @Autowired
    private userservice usrservice;


    @GetMapping("/users")
    public ResponseEntity getAllUsers()
    {   Customized c = new Customized("List of Users",usrservice.getAll());

        return new ResponseEntity(c,HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity getuserById(@PathVariable("id") String id)
    {
        Customized c = null;
        try {
            c= new Customized("Found the User", Collections.singletonList(usrservice.getuser(id)));
        } catch (Exception e) {
            c = new Customized("Not found the user",null);
            return new ResponseEntity(c, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(c,HttpStatus.OK);
    }

    @PostMapping(value = "/users",consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity insertNewUser(@RequestBody users usr)
    {   usrservice.insertUser(usr);
        Customized c = new Customized("The User data "+usr.getFirstname() +" has been successfully added",null);
        return new ResponseEntity(c,HttpStatus.OK);

    }
}
