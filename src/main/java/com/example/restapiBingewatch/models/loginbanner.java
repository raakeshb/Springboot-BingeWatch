package com.example.restapiBingewatch.models;

import org.springframework.data.annotation.Id;

public class loginbanner {

 @Id
    private String id;
    private String logBanner;

    public loginbanner(String id, String logBanner) {
        this.id = id;
        this.logBanner = logBanner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogBanner() {
        return logBanner;
    }

    public void setLogBanner(String logBanner) {
        this.logBanner = logBanner;
    }
}
