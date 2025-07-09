package com.vicky.Quiz.App.Microservices.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vicky.Quiz.App.Microservices.Model.Question;
import com.vicky.Quiz.App.Microservices.Service.QuestionService;

@CrossOrigin(origins = "https://deft-taffy-f418cf.netlify.app")
@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;

	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions()
	{
		return questionService.getAllQuestions();
	}
	
	@RequestMapping("saveAll")
	public void saveAll()
	{
		questionService.saveAll();
	}
	
	@DeleteMapping("deleteById/{id}")
	public void deleteById(@PathVariable int id)
	{
		questionService.deleteById(id);
	}
	
	@PostMapping("addQuestion")
	public void addQuestion(@RequestBody Question question)
	{
		questionService.addQuestion(question);
	}
	
	@GetMapping("category/{cat}")
	public List<Question> getByCategory(@PathVariable String cat)
	{
		return questionService.getByCategory(cat);
	}
}
