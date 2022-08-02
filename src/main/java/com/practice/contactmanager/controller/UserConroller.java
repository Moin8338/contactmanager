package com.practice.contactmanager.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.practice.contactmanager.Dao.ProductRespository;
import com.practice.contactmanager.Dao.UserRespository;
import com.practice.contactmanager.entities.Product;
import com.practice.contactmanager.entities.User;
import com.practice.contactmanager.entities.message;

@Controller
@RequestMapping("/user")
public class UserConroller {

    @Autowired
    UserRespository userRespository;

    @Autowired
    ProductRespository productRespository;

    @ModelAttribute
    public void comman_part(Model model, Principal principal) {
        String username = principal.getName();
        User user = userRespository.getUserByUsername(username);
        model.addAttribute("user", user);
    }

    // open user dashboard
    @GetMapping("/dashboard")
    public String user_dashboard(Model model, Principal principal) {
        return "/user/user_dashboard";
    }

    // get all product

    // @GetMapping("/getproducts")
	// public @ResponseBody List<Product> getAllStudent(Principal principal)
	// {
    //     User u = userRespository.getUserByUsername(principal.getName().toString());
	// 	List<Product> products=productRespository.findProductByUserId(u.getId());
		
	// 	return products;
	// }

    // open user profile page
    @GetMapping("/profile")
    public String user_profile(Model model, Principal principal) {
        return "/user/user_profile";
    }

    // open add product form page
    @GetMapping("/add-product")
    public String add_product_form(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("message", new message());
        return "/user/add_product";
    }

    // add product from user
    @PostMapping("/do_add_process")
    public String doAdd(Model model,
            Principal principal,
            @RequestParam("product_file") MultipartFile file,
            @RequestParam("image") MultipartFile img,
            @ModelAttribute Product product) {

        try {
            // processing and uploading file

            if (file.isEmpty()) {
                throw new Exception("please select project file !!");
            }
            if (img.isEmpty()) {
                throw new Exception("please select project image !!");
            }

            // upload project Resources
            File saveFile = new ClassPathResource("static/images/").getFile();
            product.setResource_path("../images/"+file.getOriginalFilename());
            Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            // upload project img
            product.setView_image_path(img.getOriginalFilename());
            saveFile = new ClassPathResource("static/images/").getFile();
            product.setView_image_path("../images/"+img.getOriginalFilename());
            path = Paths.get(saveFile.getAbsolutePath() + File.separator + img.getOriginalFilename());
            Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            User user = userRespository.getUserByUsername(principal.getName());
            product.setUser(user);
            user.getResources().add(product);
             userRespository.save(user);
            model.addAttribute("message", new message("Successfully Added", "success"));
            // System.out.println(userx);
            return "redirect:/add_product";
        } catch (Exception e) {
            model.addAttribute("product", product);
            model.addAttribute("message", new message(e.getMessage(), "error"));
            System.out.println(e.getMessage());
            return "/user/add_product";
        }
    }

}
