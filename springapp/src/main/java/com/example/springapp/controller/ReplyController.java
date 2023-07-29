package com.example.springapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Reply;
import com.example.springapp.service.ReplyService;

@RestController
@RequestMapping("/reply")
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

public class ReplyController {
    @Autowired
    public ReplyService replyService;

    @PostMapping("/addreply")
    public ResponseEntity<List<Reply>> addreply(@RequestBody Reply receivedReply){
        try {
            replyService.postReply(receivedReply);
            List<Reply> replies = replyService.getAllRepliesByQuestionId(receivedReply.getQuestionId());
            return new ResponseEntity<List<Reply>>(replies,HttpStatus.OK);
        } 
        catch (Exception e) {
            throw new RuntimeException("Error is posting reply", e);
        }
    }
    

    @GetMapping("/getAllreplies/{questionId}")
    public ResponseEntity<List<Reply>> getAllreplies(@PathVariable("questionId") Long questionId){
        List<Reply> replies = replyService.getAllRepliesByQuestionId(questionId);
        if(replies!=null){
            return new ResponseEntity<List<Reply>>(replies,HttpStatus.OK);
        }
        throw new RuntimeException("Error in getting replies");
    }
}