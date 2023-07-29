package com.example.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Reply;

@Repository
public interface ReplyRepository extends CrudRepository<Reply,Long>{
     @Query(value = "select * from replies where question_Id=?1",nativeQuery = true)
	List<Reply> findRepliesbyQuestionId(long questionId); 
}
