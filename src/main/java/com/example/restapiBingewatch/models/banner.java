package com.example.restapiBingewatch.models;

import org.springframework.data.annotation.Id;

public class banner {
    @Id
    private String id;
    private String filetitle;


    public banner(String id, String filetitle) {
        this.id = id;
        this.filetitle = filetitle;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFiletitle() {
        return filetitle;
    }

    public void setFiletitle(String filetitle) {
        this.filetitle = filetitle;
    }

    @Override
    public String toString() {
        return "banner{" +
                "id='" + id + '\'' +
                ", filetitle='" + filetitle + '\'' +
                '}';
    }
}
