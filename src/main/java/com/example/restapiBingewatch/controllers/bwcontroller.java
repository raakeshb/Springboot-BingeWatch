package com.example.restapiBingewatch.controllers;


import com.example.restapiBingewatch.models.banner;
import com.example.restapiBingewatch.models.images;
import com.example.restapiBingewatch.models.tv;
import com.example.restapiBingewatch.services.bwimageservice;
import com.example.restapiBingewatch.services.bwservice;

import com.example.restapiBingewatch.services.tvservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class bwcontroller {


    @Autowired
    private bwservice service;
    @Autowired
    private bwimageservice imgservice;
    @Autowired
    private tvservice tvservices;

    @GetMapping("/bannerdata")
    public List<banner> getall(){

    return service.getbannerfromrepo();
    }

    @GetMapping("/imagesdata")
    public List<images> imagesgetall(){
        return imgservice.imagesgetall();
    }




    @PostMapping(value = "/bannerdata", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public void insertbanner(@RequestBody banner bandata)
    {
            service.insertbannerintorepo(bandata);
    }

    @PostMapping(value = "/imagesdata", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })

    public void insertimage(@RequestBody images imgdata)
    {
        imgservice.imagesinsert(imgdata);
    }

    @GetMapping("/tvdata")
    public List<tv> gettvdata(){
        return tvservices.gettv();
    }

    @PostMapping("/tvdata")
    public void inserttvdata(tv tvdata)
    {
       tvservices.inserttv(tvdata);
    }



}
