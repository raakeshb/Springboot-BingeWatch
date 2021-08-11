package com.example.restapiBingewatch.controllers;


import com.example.restapiBingewatch.models.Customized;
import com.example.restapiBingewatch.models.loginbanner;
import com.example.restapiBingewatch.models.movies;
import com.example.restapiBingewatch.services.loginbannerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin("*")
@Controller
public class LoginBannerController {

    @Autowired
    private loginbannerservice service;

    @GetMapping("/LoginBanner")
    public ResponseEntity getAll()
    {   Customized c= new Customized("List of Login Banner Data",service.getallBanner());
        return new ResponseEntity(c, HttpStatus.OK);
    }


    @PostMapping(value = "/LoginBanner", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity insertMovies(@RequestBody loginbanner mv) {
        service.insertLoginBanner(mv);
        return new ResponseEntity(HttpStatus.OK);

    }
}
