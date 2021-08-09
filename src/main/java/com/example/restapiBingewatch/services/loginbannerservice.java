package com.example.restapiBingewatch.services;


import com.example.restapiBingewatch.models.loginbanner;
import com.example.restapiBingewatch.models.loginbannerrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class loginbannerservice {


    @Autowired
    private loginbannerrepo loginbannerrepo;

    public List<loginbanner> getallBanner()
    {
        return loginbannerrepo.findAll();
    }

    public void insertLoginBanner(loginbanner mv) {
        loginbannerrepo.insert(mv);
    }

}
