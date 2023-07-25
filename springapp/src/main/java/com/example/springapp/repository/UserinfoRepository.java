package com.example.springapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Userinfo;



@Repository

public interface UserinfoRepository extends CrudRepository<Userinfo,String>{

}
