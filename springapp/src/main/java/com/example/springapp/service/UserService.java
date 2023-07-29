package com.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.User;
import com.example.springapp.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User getUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }

    public void deletUser(Long id){
        userRepository.deleteById(id);
    }
}
