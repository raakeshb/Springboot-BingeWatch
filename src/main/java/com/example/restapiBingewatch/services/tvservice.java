package com.example.restapiBingewatch.services;


import com.example.restapiBingewatch.models.tv;
import com.example.restapiBingewatch.models.tvrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class tvservice {

    @Autowired
    private tvrepo repo;

    public List<tv> gettv(){return repo.findAll();}

    public void inserttv(tv tvdata){
        repo.insert(tvdata);
    }
}
