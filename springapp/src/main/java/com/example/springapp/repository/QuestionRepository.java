package com.example.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question,Long>{
   @Query(value = "select * from questions where course_Id=?1",nativeQuery = true)
	List<Question> findQuestionsbyCourseId(long courseId); 
}
