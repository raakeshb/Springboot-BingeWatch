package com.example.restapiBingewatch.services;

import com.example.restapiBingewatch.models.banner;
import com.example.restapiBingewatch.models.bwrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class bwservice {

    @Autowired
    private bwrepo repo;


    public List<banner> getbannerfromrepo(){
        return repo.findAll();
    }


    public void insertbannerintorepo(banner data){

        repo.insert(data);
    }




}
