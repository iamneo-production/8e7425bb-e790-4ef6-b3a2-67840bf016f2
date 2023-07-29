package com.example.springapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="replies")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long questionId;
    private String replierName;
    private String role;
    private String reply;
    
    public Reply() {
    }
    
    public Reply(long id, long questionId, String replierName, String role, String reply) {
        this.id = id;
        this.questionId = questionId;
        this.replierName = replierName;
        this.role = role;
        this.reply = reply;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getQuestionId() {
        return questionId;
    }
    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }
    public String getReplierName() {
        return replierName;
    }
    public void setReplierName(String replierName) {
        this.replierName = replierName;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getReply() {
        return reply;
    }
    public void setReply(String reply) {
        this.reply = reply;
    }
    

}
