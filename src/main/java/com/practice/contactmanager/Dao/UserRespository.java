package com.practice.contactmanager.Dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practice.contactmanager.entities.User;

public interface UserRespository extends JpaRepository<User,Integer>{

    @Query("select u from User u where u.username=:username")
    public User getUserByUsername(@Param("username") String username);
}
