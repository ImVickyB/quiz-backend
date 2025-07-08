package com.vicky.Quiz.App.Microservices.Model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor   //will have both NoArgs and AllArgs 
public class Response {
	
	private int id;
	private String response;
}
