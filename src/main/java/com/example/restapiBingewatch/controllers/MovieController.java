package com.example.restapiBingewatch.controllers;


import com.example.restapiBingewatch.models.*;
import com.example.restapiBingewatch.services.bwservice;
import com.example.restapiBingewatch.services.movieservice;
import com.example.restapiBingewatch.services.tvservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class bwcontroller {


    @Autowired
    private bwservice service;

    @Autowired
    private tvservice tvservices;
    @Autowired
    private movieservice mvservice;

    @GetMapping("/bannerdata")
    public ResponseEntity getallBanner() {

        return new ResponseEntity(service.getbannerfromrepo(), HttpStatus.OK);
    }


    @PostMapping(value = "/bannerdata", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity insertBanner(@RequestBody banner bandata) {
        service.insertbannerintorepo(bandata);
        return new ResponseEntity(HttpStatus.OK);
    }
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

    //Search For Movie
    @GetMapping(value = "/tv/find")
    public ResponseEntity searchtvBytitle(@RequestParam("name") String title,@RequestParam("keys") String key)
    {
        Customized c = new Customized("List of Movies Matching String "+title, tvservices.searchbytitle(title,key));
        return new ResponseEntity(c,HttpStatus.OK);
    }

    /**************************TV EndPoints************************/

    /**************************Movie EndPoints************************/
    //Get All Movie
    @GetMapping("/movies")
    public ResponseEntity getAllMovies() {

        Customized c = new Customized("List of Movies", mvservice.getAllmovies());
        return new ResponseEntity(c, HttpStatus.OK);

    }

    //Create Movie
    @PostMapping(value = "/movies", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity insertMovies(@RequestBody movies mv) {
        mvservice.insertMovie(mv);
        return new ResponseEntity(HttpStatus.OK);

    }

    //Get Movies By id
    @GetMapping("/movies/{id}")
    public ResponseEntity getMoviebyid(@PathVariable("id") String id) {
        Customized c = null;
        try {
            c = new Customized("Found the Movie", Collections.singletonList(mvservice.getMoviebyId(id)));
        } catch (Exception e) {
            c = new Customized(e.getMessage(), null);
            return new ResponseEntity(c, HttpStatus.NOT_FOUND);
        }


        return new ResponseEntity(c, HttpStatus.OK);
    }


    //Update Movie

    @PutMapping(value = "/movies/put/{id}", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity updatemovies(@RequestBody movies mv, @PathVariable("id") String id) {
        Customized c = new Customized("We have Update the data of movie " + mv.getTitle(), Collections.singletonList(mvservice.updatemoviess(mv, id)));
        mvservice.updatemoviess(mv, id);

        return new ResponseEntity(c, HttpStatus.OK);
    }

    //Delete Movie by Id
    @DeleteMapping("/movies/{id}")
    public ResponseEntity deleteMoviebyid(@PathVariable("id") String id) {

        mvservice.deleteMovie(id);
        return new ResponseEntity(HttpStatus.OK);


    }

    //Search For Movie
    @GetMapping(value = "/movies/find")
    public ResponseEntity searchmovieBytitle(@RequestParam("name") String title,@RequestParam("keys") String key)
    {
        Customized c = new Customized("List of Movies Matching String "+title, mvservice.searchbytitle(title,key));
        return new ResponseEntity(c,HttpStatus.OK);
    }
/**************************Movie EndPoints************************/

}
