package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Reply;
import com.example.springapp.repository.ReplyRepository;

@Service
public class ReplyService {
    @Autowired
    public ReplyRepository replyRepository;

    public Reply postReply(Reply reply){
        return replyRepository.save(reply);
    }
    
    public List<Reply> getAllRepliesByQuestionId(Long questionId){
        return replyRepository.findRepliesbyQuestionId(questionId);
    }
}