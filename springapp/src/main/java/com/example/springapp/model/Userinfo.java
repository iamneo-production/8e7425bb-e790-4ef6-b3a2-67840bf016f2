package com.example.springapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Userinfo {
    
    @Id
    private String email;
    private String username;
    private String education;
    private String occupation;
    private String domain;
    private String organization;
    private float totaltime;


    public Userinfo() {
    }


    public Userinfo(String email, String username, String education, String occupation, String domain,
            String organization, float totaltime) {
        this.email = email;
        this.username = username;
        this.education = education;
        this.occupation = occupation;
        this.domain = domain;
        this.organization = organization;
        this.totaltime = totaltime;
    }

    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEducation() {
        return education;
    }
    public void setEducation(String education) {
        this.education = education;
    }
    public String getOccupation() {
        return occupation;
    }
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    public String getDomain() {
        return domain;
    }
    public void setDomain(String domain) {
        this.domain = domain;
    }
    public String getOrganization() {
        return organization;
    }
    public void setOrganization(String organization) {
        this.organization = organization;
    }
    public float getTotaltime() {
        return totaltime;
    }
    public void setTotaltime(float totaltime) {
        this.totaltime = totaltime;
    }

    
}