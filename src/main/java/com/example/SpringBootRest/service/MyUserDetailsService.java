package com.example.SpringBootRest.service;

import com.example.SpringBootRest.model.User;
import com.example.SpringBootRest.model.UserPrincipal;
import com.example.SpringBootRest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userRepo.findByUsername(userName);

        System.out.println("Hello user: " + user);

        if (user == null) {
            System.out.println("user not found");
            throw new UsernameNotFoundException("User 404");
        }

        return new UserPrincipal(user);
    }
}