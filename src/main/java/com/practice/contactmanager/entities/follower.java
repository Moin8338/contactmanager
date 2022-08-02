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
@Table
public class follower {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private int follower_id;

    @ManyToOne
    @JsonIgnore
    private User followinguser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFollower_id() {
        return follower_id;
    }

    public void setFollower_id(int follower_id) {
        this.follower_id = follower_id;
    }

    public User getFollowinguser() {
        return followinguser;
    }

    public void setFollowinguser(User followinguser) {
        this.followinguser = followinguser;
    }

    public follower(int follower_id, User followinguser) {
        this.follower_id = follower_id;
        this.followinguser = followinguser;
    }

    public follower() {
    }

    
}
