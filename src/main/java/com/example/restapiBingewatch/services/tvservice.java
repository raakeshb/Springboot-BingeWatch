package com.example.restapiBingewatch.services;


import com.example.restapiBingewatch.models.movies;
import com.example.restapiBingewatch.models.tv;
import com.example.restapiBingewatch.models.tvrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class tvservice {

    @Autowired
    private tvrepo repo;

    public List<tv> gettv() {
        return repo.findAll();
    }

    public void inserttv(tv tvdata) {
        repo.insert(tvdata);
    }

    public Optional<tv> getTvbyId(String id) throws Exception {
        Optional<tv> otv = repo.findById(id);
        if (!otv.isPresent()) {
            throw new Exception("TV with id " + id + " is not Found");
        }
        return otv;

    }

    public tv updatetv(tv mv, String id) {

        Optional<tv> searchit = repo.findById(id);

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

        tv updatedone = repo.save(searchit.get());
        return updatedone;


    }

    public void deletetv(String id) {
        repo.deleteById(id);
    }
}
