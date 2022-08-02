package com.practice.contactmanager.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.practice.contactmanager.entities.User;

public class UserDetailService implements UserDetailsService{
    
    @Autowired
    private UserRespository userRespository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        //fetch User details From databse

        User user=userRespository.getUserByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("could not found !!");
        }
        CustomeUserDetails customeUserDetails=new CustomeUserDetails(user);
        
        return customeUserDetails;
    }
    
}
