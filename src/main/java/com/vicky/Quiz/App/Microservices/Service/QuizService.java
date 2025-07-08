package com.vicky.Quiz.App.Microservices.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vicky.Quiz.App.Microservices.Dao.QuestionDao;
import com.vicky.Quiz.App.Microservices.Dao.QuizDao;
import com.vicky.Quiz.App.Microservices.Model.Question;
import com.vicky.Quiz.App.Microservices.Model.QuestionWrapper;
import com.vicky.Quiz.App.Microservices.Model.Quiz;
import com.vicky.Quiz.App.Microservices.Model.Response;

@Service
public class QuizService {
	
	@Autowired
	QuizDao repo;
	
	@Autowired
	QuestionDao qrepo;

	public ResponseEntity<String> createQuiz(String category, int nQuestions, String quizTitle) {
		List<Question> questions = qrepo.findRandomQuestionsByDifficulty(category,nQuestions);
		Quiz obj = new Quiz();
		obj.setQuizTitle(quizTitle);
		obj.setQuestion(questions);
		repo.save(obj);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
		Optional<Quiz> quiz = repo.findById(id);
		List<Question> questionsFromDB = quiz.get().getQuestion();
		List<QuestionWrapper> questionsForUser = new ArrayList<>();
		for(Question q : questionsFromDB)
		{
			QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionsForUser.add(qw);
		}
		return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(int id, List<Response> response) {
		
		Quiz quiz = repo.findById(id).get();
		List<Question> questions = quiz.getQuestion();
		int right = 0;
		int i = 0;
		for(Response res : response)
		{
			if(res.getResponse().equals(questions.get(i).getRightAnswer()))
			{
				right++;
			}
			i++;
		}
		return new ResponseEntity<>(right,HttpStatus.OK);	
	}
}
