package com.example.restapiBingewatch.services;

import com.example.restapiBingewatch.models.images;
import com.example.restapiBingewatch.models.imgrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bwimageservice {

    @Autowired
    private imgrepo repos;


    public List<images> imagesgetall(){
        return repos.findAll();
    }

    public void imagesinsert(images img){ repos.insert(img);}


}
