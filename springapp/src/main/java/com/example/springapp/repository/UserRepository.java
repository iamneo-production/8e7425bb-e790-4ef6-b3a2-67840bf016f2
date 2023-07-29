package com.example.springapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.User;


@Repository
public interface UserRepository extends CrudRepository<User,Long>{

@Query(value = "select * from user where email=?1",nativeQuery = true)
	User findUserByEmail(String email);
}