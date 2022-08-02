package com.practice.contactmanager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)   
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String subtitle;


    @Column(nullable = false)
    private String description;

    private String resource_path;

    private String view_image_path;

    private String type;

    @Column(nullable = true)
    private String rating;

    @Column(nullable = true)
    private int likes;

    @Column(nullable = true)
    private int shares;

    @Column(nullable = true)
    private int comments;

    @Column(nullable = true)
    private int downloads;

    @ManyToOne
    @JsonIgnore
    private User user;


    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    @Column(nullable = true)
    private int price;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResource_path() {
        return resource_path;
    }

    public void setResource_path(String resource_path) {
        this.resource_path = resource_path;
    }

    public String getView_image_path() {
        return view_image_path;
    }

    public void setView_image_path(String view_image_path) {
        this.view_image_path = view_image_path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

   

    public Product(String title, String subtitle, String description, String resource_path, String view_image_path,
            String type, String rating, int likes, int shares, int comments, int downloads, int price, User user) {
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.resource_path = resource_path;
        this.view_image_path = view_image_path;
        this.type = type;
        this.rating = rating;
        this.likes = likes;
        this.shares = shares;
        this.comments = comments;
        this.downloads = downloads;
        this.price = price;
        this.user = user;
    }

    public Product() {
    }

   

}
