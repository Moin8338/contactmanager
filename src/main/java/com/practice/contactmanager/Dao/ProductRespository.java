package com.practice.contactmanager.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practice.contactmanager.entities.Product;

public interface ProductRespository extends JpaRepository<Product, Integer>{

    @Query("from Product as p where p.user.id=:user_id")
    public List<Product> findProductByUserId(@Param("user_id") int Userid);

    public Product findByTitle(String title);
    
}
