package org.example.bookmyshow.services;

import org.example.bookmyshow.models.User;
import org.example.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User signUpUser(String name,String email,String password){
        Optional<User> optionalUser=userRepository.findByEmail(email);
        if(optionalUser.isPresent())throw new RuntimeException("User Already Exists");
        User user=new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        return userRepository.save(user);
    }
}
