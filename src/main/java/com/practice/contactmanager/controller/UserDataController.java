package com.practice.contactmanager.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.contactmanager.Dao.ProductRespository;
import com.practice.contactmanager.Dao.UserRespository;
import com.practice.contactmanager.entities.Product;
import com.practice.contactmanager.entities.User;

@RestController
@RequestMapping("/user")
public class UserDataController {

    @Autowired
    UserRespository userRespository;

    @Autowired
    ProductRespository productRespository;

    @GetMapping(path = "/getproducts")
    public ResponseEntity<?> getproducts(Principal principal) {
        try {
        User u = userRespository.getUserByUsername(principal.getName().toString());
        List<Product> list_of_product = new ArrayList<Product>();
        System.out.println(u.getId());
        list_of_product = productRespository.findProductByUserId(u.getId());
        return ResponseEntity.ok(list_of_product);
        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
