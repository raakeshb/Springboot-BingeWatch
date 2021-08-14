package com.example.restapiBingewatch.controllers;

import com.example.restapiBingewatch.models.Customized;
import com.example.restapiBingewatch.models.tv;
import com.example.restapiBingewatch.services.tvservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
@CrossOrigin("https://bingewatch-ott.herokuapp.com/")
@Controller
public class TVController {

    @Autowired
    private tvservice tvservices;


    /**************************TV Controller************************/
    //Get All TV

    @GetMapping("/tv")
    public ResponseEntity getAlltv() {
        Customized c = new Customized("List of TV", tvservices.gettv());
        return new ResponseEntity(c, HttpStatus.OK);
    }

    //Get TV by id

    @GetMapping("/tv/{id}")
    public ResponseEntity getTVbyId(@PathVariable("id") String id) {
        Customized c = null;
        try {
            c = new Customized("Found the TV", Collections.singletonList(tvservices.getTvbyId(id)));
        } catch (Exception e) {
            c = new Customized(e.getMessage(), null);
            return new ResponseEntity(c, HttpStatus.NOT_FOUND);
        }


        return new ResponseEntity(c, HttpStatus.OK);
    }

    //Insert into TV

    @PostMapping(value = "/tv", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity inserttvbyId(@RequestBody tv tvdata) {
        tvservices.inserttv(tvdata);
        return new ResponseEntity(HttpStatus.OK);
    }

    //update TV

    @PutMapping(value = "/tv/put/{id}", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity updatetv(@RequestBody tv tvdata, @PathVariable("id") String id) {

        Customized c = new Customized("Update data of TV " + tvdata.getTitle(), Collections.singletonList(tvservices.updatetv(tvdata, id)));


        return new ResponseEntity(c, HttpStatus.OK);
    }

    //Delete TV by id
    @DeleteMapping("/tv/{id}")
    public ResponseEntity deleteTVbyId(@PathVariable("id") String id) {
        tvservices.deletetv(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    //Search For tv
    @GetMapping(value = "/tv/find")
    public ResponseEntity searchtvBytitle(@RequestParam("name") String title,@RequestParam("keys") String key)
    {
        Customized c = new Customized("List of Movies Matching String "+title, tvservices.searchbytitle(title,key));
        return new ResponseEntity(c,HttpStatus.OK);
    }

    /**************************TV EndPoints************************/




}
