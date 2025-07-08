package com.vicky.Quiz.App.Microservices.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String questionTitle;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String rightAnswer;
	private String difficultyLevel;
	private String category;
	
//	@Version  // Add this annotation for optimistic locking
//    private Integer version;
	
	public Question(String questionTitle, String option1, String option2, String option3, String option4, String rightAnswer, String difficultyLevel, String category) {
	    this.questionTitle = questionTitle;
	    this.option1 = option1;
	    this.option2 = option2;
	    this.option3 = option3;
	    this.option4 = option4;
	    this.rightAnswer = rightAnswer;
	    this.difficultyLevel = difficultyLevel;
	    this.category = category;
	}
}


