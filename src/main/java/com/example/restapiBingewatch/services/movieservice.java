package com.example.restapiBingewatch.services;

import com.example.restapiBingewatch.models.movierepo;
import com.example.restapiBingewatch.models.movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.stereotype.Service;


import java.util.List;

import java.util.Optional;

@Service
public class movieservice {


    @Autowired
    private movierepo mvrepo;


    @Autowired
    private MongoTemplate Mongos;


    public List<movies> getAllmovies() {
        return mvrepo.findAll();
    }

    public Optional<movies> getMoviebyId(String mv) throws Exception {
        Optional<movies> movie = mvrepo.findById(mv);

        if (!movie.isPresent()) {
            throw new Exception("Movie with id " + mv + " Not Found");
        }
        return movie;

    }

    public void insertMovie(movies mv) {
        mvrepo.insert(mv);
    }

    public void deleteMovie(String id) {
        mvrepo.deleteById(id);


    }

    public List<movies> searchbytitle(String name, String key) {
        String keyvalue = "";

        if (key == "category" || key == "title" || key == "rating" || key == "featured") {
            keyvalue = key;
        }

        Query query = new Query();
        query.addCriteria(Criteria.where(key).regex(name));
        List<movies> mv = Mongos.find(query, movies.class);
        return mv;
    }

    public movies updatemoviess(movies mv, String id) {

        Optional<movies> searchit = mvrepo.findById(id);

        searchit.get().setBuyprice(mv.getBuyprice());
        searchit.get().setCategory(mv.getCategory());
        searchit.get().setDescription(mv.getDescription());
        searchit.get().setFeatured(mv.getFeatured());
        searchit.get().setFiletitle(mv.getFiletitle());
        searchit.get().setRating(mv.getRating());
        searchit.get().setTitle(mv.getTitle());
        searchit.get().setTitlepic(mv.getTitlepic());
        searchit.get().setYoutube(mv.getYoutube());
        searchit.get().setRentprice(mv.getRentprice());

        movies updatedone = mvrepo.save(searchit.get());
        return updatedone;


    }
}
