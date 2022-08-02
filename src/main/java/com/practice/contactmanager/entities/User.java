package com.practice.contactmanager.entities;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,unique = true)
    private int id;

    @Column(nullable = true)
    private String name;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false,unique = true) 
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private boolean enabled;

    @Column(nullable = true)
    private String role;

    @Column(nullable = true,unique = true)
    private String imageurl;
    
    @Column(nullable = true)
    private String about; 

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
    private List<Product> resources=new ArrayList<Product>();

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "followinguser")
    private List<follower> followers=new ArrayList<follower>();

    private int followings;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<Product> getResources() {
        return resources;
    }

    public void setResources(List<Product> resources) {
        this.resources = resources;
    }

    public List<follower> getFollowers() {
        return followers;
    }

    public void setFollowers(List<follower> followers) {
        this.followers = followers;
    }

    public int getFollowings() {
        return followings;
    }

    public void setFollowings(int followings) {
        this.followings = followings;
    }

    public User(String name, String username, String email, String password, boolean enabled, String role,
            String imageurl, String about, List<Product> resources, List<follower> followers, int followings) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
        this.imageurl = imageurl;
        this.about = about;
        this.resources = resources;
        this.followers = followers;
        this.followings = followings;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User [about=" + about + ", email=" + email + ", enabled=" + enabled + ", followers=" + followers
                + ", followings=" + followings + ", id=" + id + ", imageurl=" + imageurl + ", name=" + name
                + ", password=" + password + ", resources=" + resources + ", role=" + role + ", username=" + username
                + "]";
    }

    

}
