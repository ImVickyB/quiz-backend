package com.vicky.Quiz.App.Microservices.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vicky.Quiz.App.Microservices.Model.Question;
import com.vicky.Quiz.App.Microservices.Model.Quiz;



public interface QuizDao extends JpaRepository<Quiz,Integer> {
	
//	@Query(value = "SELECT * FROM question WHERE category=:cat ORDER BY RANDOM() LIMIT :nQuestions",nativeQuery=true)
//	List<Question> findRandomQuestionsByDifficulty(String cat, int nQuestions);
	
	
//	@Query(value = "SELECT * FROM question WHERE difficulty_level=:difficultyLevel ORDER BY RAND() LIMIT 3",nativeQuery=true)
//	List<Question> findRandomQuestionsByDifficulty(String difficultyLevel, int nQuestions);
	


}
