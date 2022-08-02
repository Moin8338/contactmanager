package com.practice.contactmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.practice.contactmanager.Dao.UserRespository;
import com.practice.contactmanager.entities.User;
import com.practice.contactmanager.entities.follower;
import com.practice.contactmanager.entities.message;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class homecontroller {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRespository userRespository;

    

    @GetMapping("/home")
    public String home(Model model) {
        try {
        //     User user1=userRespository.getUserByUsername("faizal8338");

        // follower fo=new follower();
        // fo.setFollowinguser(user1);
        // fo.setFollower_id(22);
        // user1.getFollowers().add(fo);
        // userRespository.save(user1);
        // model.addAttribute("user", new User());
        // model.addAttribute("title", "smart contact manager");
        return "/index";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "/index";
        }
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("message", new message());
        return "register";
    }

    @GetMapping("protofolio")
    public String protofolio() {
        return "protofolio";
    }

    @GetMapping("about")
    public String about() {
        return "about";
    }

    @GetMapping("contact")
    public String contact() {
        return "contact";
    }

    @PostMapping("signup")
    public String postMethodName(@ModelAttribute User user,
            @RequestParam(value = "agree-term", defaultValue = "false") boolean agreement, Model model) {
        try {
            model.addAttribute("user", user);
            if (user.getUsername().isBlank()) {
                throw new Exception("username can not be blank !!");
            } else if (user.getName().isBlank()) {
                throw new Exception("Enter Your Name !!!");
            } else if (user.getEmail().isBlank()) {
                throw new Exception("Enter your Email !!");
            } else if (user.getPassword().isBlank()) {
                throw new Exception("Please Create Password !!");
            } else if (!agreement) {
                throw new Exception("you have not agreed terms and condition");
            }
            System.out.println("\n\n\n\n\n" + user + "\n\n\n\n\n");
            user.setRole("ROLE_USER");
            user.setEnabled(true);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user = userRespository.save(user);
            model.addAttribute("message", new message("successfuly register !!", "success"));
            return "/login";
        } catch (Exception e) {
            model.addAttribute("user", user);
            model.addAttribute("message", new message(e.getMessage(), "error"));
            return "register";
        }
    }


}
