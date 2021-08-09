package com.example.restapiBingewatch.models;

import org.springframework.data.annotation.Id;

import java.util.Locale;

public class movies {
    @Id
    private String id;
    private String category;
    private String title;
    private String filetitle;
    private String description;
    private String titlepic;
    private String youtube;
    private String rating;
    private float rentprice;
    private float buyprice;
    private String featured;


    public movies(String id, String category, String title, String filetitle, String description, String titlepic, String youtube, String rating, float rentprice, float buyprice, String featured) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.filetitle = filetitle;
        this.description = description;
        this.titlepic = titlepic;
        this.youtube = youtube;
        this.rating = rating;
        this.rentprice = rentprice;
        this.buyprice = buyprice;
        this.featured = featured;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFiletitle() {
        return filetitle;
    }

    public void setFiletitle(String filetitle) {
        this.filetitle = filetitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitlepic() {
        return titlepic;
    }

    public void setTitlepic(String titlepic) {
        this.titlepic = titlepic;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getRating() {
        return rating.toUpperCase();
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public float getRentprice() {
        return Math.round(rentprice);
    }

    public void setRentprice(float rentprice) {
        this.rentprice = rentprice;
    }

    public float getBuyprice() {
        return Math.round(buyprice);
    }

    public void setBuyprice(float buyprice) {
        this.buyprice = buyprice;
    }

    public String getFeatured() {
        return featured;
    }

    public void setFeatured(String featured) {
        this.featured = featured;
    }
}
