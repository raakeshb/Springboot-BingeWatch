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

@CrossOrigin("https://bingewatch-ott.herokuapp.com/")
@RestController

public class MovieController {


    @Autowired
    private bwservice service;

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
