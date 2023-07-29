package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Userinfo;
import com.example.springapp.service.UserinfoService;


@RestController
@RequestMapping("/userinfo")
//santhosh
@CrossOrigin(origins = "https://8081-cbbdbceccaaadcdddffaedcbcabfdfafdade.project.examly.io")

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
//@CrossOrigin(origins = "https://8081-ddefcefdabfbdadcdddffaeeaeaadbdbabf.project.examly.io")

//rishik
//@CrossOrigin(origins = "https://8081-caccdedfdbdccefeadcdddffaedcbcabfdfafdade.project.examly.io")

public class UserinfoController {
    @Autowired
    public UserinfoService userinfoService;

    @PostMapping("/add")
    public ResponseEntity<Userinfo> adduserinfo(@RequestBody Userinfo receiveddata){
        Userinfo userinfo=userinfoService.addUserinfo(receiveddata);
        return new ResponseEntity<>(userinfo,HttpStatus.OK);  
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Userinfo> getuserbyid(@PathVariable("id") String email){
        Userinfo user=userinfoService.getById(email);
        return new ResponseEntity<>(user,HttpStatus.OK);  
    }
    
    @PutMapping("/update")
    public ResponseEntity<Userinfo> updateuserbyid(@RequestBody Userinfo receiveddata){
        Userinfo user=userinfoService.getById(receiveddata.getEmail());
        user=receiveddata;
        userinfoService.addUserinfo(user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}