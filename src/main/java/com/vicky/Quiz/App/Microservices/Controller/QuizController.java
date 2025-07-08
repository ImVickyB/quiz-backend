package com.vicky.Quiz.App.Microservices.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vicky.Quiz.App.Microservices.Model.Question;
import com.vicky.Quiz.App.Microservices.Model.QuestionWrapper;
import com.vicky.Quiz.App.Microservices.Model.Response;
import com.vicky.Quiz.App.Microservices.Service.QuizService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	QuizService quizService;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int nQuestions, @RequestParam String quizTitle)
	{
//		return new ResponseEntity<>("I'm Working!!!!", HttpStatus.OK);
		return quizService.createQuiz(category,nQuestions, quizTitle) ;
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id)
	{
		return quizService.getQuizQuestions(id);
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<Response> response)
	{
		return quizService.calculateResult(id, response);
	}
}
