package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.User;
import com.example.springapp.repository.UserRepository;

@RestController
@RequestMapping("/users")
//santhosh
//@CrossOrigin(origins = "https://8081-cbbdbceccaaadcdddffaedcbcabfdfafdade.project.examly.io")

//ramesh
//@CrossOrigin(origins = "https://8081-febcaabfefeacfadcdddffaedcbcabfdfafdade.project.examly.io")

//rithick
//@CrossOrigin(origins = "https://8081-ccfbbdadfbadcdddffaedcbcabfdfafdade.project.examly.io")

//oviya
//@CrossOrigin(origins = "https://8081-bfbbbeacbadcdddffaedcbcabfdfafdade.project.examly.io")

//joshika
//@CrossOrigin(origins = "https://8081-fdfedfdaaaacfedbadcdddffaedcbcabfdfafdade.project.examly.io")

//sumanth
//@CrossOrigin(origins = "https://8081-daeacaadbcfaeadcdddffaedcbcabfdfafdade.project.examly.io")

//mrinal
//@CrossOrigin(origins = "https://8081-fbbfbccabebadcdddffaedcbcabfdfafdade.project.examly.io")

//muskan
@CrossOrigin(origins = "https://8081-ddefcefdabfbdadcdddffaedcbcabfdfafdade.project.examly.io")

//rishik
//@CrossOrigin(origins = "https://8081-caccdedfdbdccefeadcdddffaedcbcabfdfafdade.project.examly.io")

public class UserController {
    @Autowired
    public UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User receivedData) {
        User user = userRepository.findUserByEmail(receivedData.getEmail());
        if (user.getPassword().equals(receivedData.getPassword())) {
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("")
    public ResponseEntity<?> forgotUser(@RequestBody User receivedData) {
        User user = userRepository.findUserByEmail(receivedData.getEmail());
        if (user != null) {
            user.setPassword(receivedData.getPassword());
            userRepository.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/register")
    public ResponseEntity<?> signup(@RequestBody User receivedData) {
        User user = userRepository.findUserByEmail(receivedData.getEmail());
        if (user == null) {
            user = userRepository.save(receivedData);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @GetMapping("/id")
    public ResponseEntity<User> getUserById(@RequestParam("id") long id) {
        User user = userRepository.findById(id).get();
        if (user != null) {
            user.setPassword(null);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("")
    public ResponseEntity<?> DeleteUserById(@RequestParam("id") long id) {
        User user = userRepository.findById(id).get();
        if (user != null) {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}