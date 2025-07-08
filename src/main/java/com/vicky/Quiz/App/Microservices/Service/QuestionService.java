package com.vicky.Quiz.App.Microservices.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vicky.Quiz.App.Microservices.Dao.QuestionDao;
import com.vicky.Quiz.App.Microservices.Model.Question;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao repo;
	

	
	public void saveAll() {
	    Question obj1 = new Question("Which one is not an ORM framework?", "Hibernate", "JDBC", "Spring ORM", "Spring DataJPA", "JDBC", "Easy", "Java");
	    Question obj2 = new Question("Which one is not a Functional Interface?", "Consumer", "Supplier", "Function", "Primitive", "Primitive", "Easy", "Java");
	    Question obj3 = new Question("Choose the correct answer related to Jackson API.", "Converts JSON to Object", "Converts Object to JSON", "Converts Object to XML", "All the above", "All the above", "Easy", "SpringBoot");

	    // More Java questions
	    Question obj4 = new Question("What is the size of int in Java?", "4 bytes", "2 bytes", "8 bytes", "Depends on OS", "4 bytes", "Easy", "Java");
	    Question obj5 = new Question("Which keyword is used to inherit a class in Java?", "extends", "implements", "inherit", "this", "extends", "Easy", "Java");

	    // More Spring Boot questions
	    Question obj6 = new Question("What is the default port for Spring Boot applications?", "8080", "80", "443", "9090", "8080", "Easy", "SpringBoot");
	    Question obj7 = new Question("Which annotation is used to create RESTful web services in Spring Boot?", "@RestController", "@Controller", "@Service", "@Repository", "@RestController", "Easy", "SpringBoot");

	    // Python questions
	    Question obj8 = new Question("Which of these is used to define a function in Python?", "def", "func", "function", "define", "def", "Easy", "Python");
	    Question obj9 = new Question("What does the len() function do in Python?", "Returns length of an object", "Adds numbers", "Checks type", "None of the above", "Returns length of an object", "Easy", "Python");
	    Question obj10 = new Question("Which data structure does a Python dictionary resemble?", "HashMap", "List", "Set", "Array", "HashMap", "Easy", "Python");

	    List<Question> questions = Arrays.asList(obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
	    repo.saveAll(questions);
	}

	
	
	public ResponseEntity<List<Question>> getAllQuestions() {
		try
		{
			return new ResponseEntity<>(repo.findAll(),HttpStatus.ACCEPTED);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}


	public void deleteById(int id) 
	{
		repo.deleteById(id);
	}


	public void addQuestion(Question question) {
		
		repo.save(question);
	}


	public List<Question> getByCategory(String cat) {
		
		return repo.findByCategory(cat);
	}
	
}
