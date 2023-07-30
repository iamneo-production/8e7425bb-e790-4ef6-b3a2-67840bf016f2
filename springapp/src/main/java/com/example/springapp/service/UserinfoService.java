package com.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Userinfo;
import com.example.springapp.repository.UserinfoRepository;

@Service
public class UserinfoService {
    @Autowired
    public UserinfoRepository userinfoRepository;

    public Userinfo addUserinfo(Userinfo userinfo){
        return userinfoRepository.save(userinfo);
    }

    public Userinfo getById(String email){
        return userinfoRepository.findById(email).get();
    }
}
