package com.example.SpringBootRest.service;

import com.example.SpringBootRest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.SpringBootRest.model.User;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    public User saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println("Encrypted Password: " + user.getPassword());
        return userRepo.save(user);
    }


}
