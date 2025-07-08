package com.vicky.Quiz.App.Microservices.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vicky.Quiz.App.Microservices.Model.Question;

public interface QuestionDao extends JpaRepository<Question,Integer> {

	List<Question> findByCategory(String cat);
	
	@Query(value = "SELECT * FROM question WHERE category=:cat ORDER BY RANDOM() LIMIT :nQuestions",nativeQuery=true)
	List<Question> findRandomQuestionsByDifficulty(String cat, int nQuestions);
}
