package com.example.restapiBingewatch.controllers;


import com.example.restapiBingewatch.models.Customized;
import com.example.restapiBingewatch.models.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
@CrossOrigin("https://bingewatch-ott.herokuapp.com/")
@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/auth")
    public ResponseEntity userlogin(@RequestBody users usr)
    {
        Customized c = null;
        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usr.getUsername(),usr.getPassword()));
            Customized response = new Customized("You Have Logged in",null);
            return new ResponseEntity(response,HttpStatus.OK);

        } catch (BadCredentialsException e) {
            Customized response = new Customized("Username or Password is Wrong",null);
            return new ResponseEntity(response, HttpStatus.UNAUTHORIZED);
        }

    }




}
