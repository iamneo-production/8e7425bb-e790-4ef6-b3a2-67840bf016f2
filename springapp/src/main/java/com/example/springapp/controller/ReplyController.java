package com.example.springapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Reply;
import com.example.springapp.repository.ReplyRepository;

@RestController
@RequestMapping("/reply")
@CrossOrigin("http://localhost:4200")
public class ReplyController {
    @Autowired
    public ReplyRepository replyRepository;

    @PostMapping("/addreply")
    public List<Reply> addreply(@RequestBody Reply receivedReply){
        replyRepository.save(receivedReply);
        return replyRepository.findRepliesbyQuestionId(receivedReply.getQuestionId());
    }
    
    @GetMapping("/getAllreplies/{questionId}")
    public List<Reply> getAllreplies(@PathVariable("questionId") Long questionId){
        return replyRepository.findRepliesbyQuestionId(questionId);
    }
}