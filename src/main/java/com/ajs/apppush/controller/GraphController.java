package com.ajs.apppush.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajs.apppush.component.GraphUseCase;

import graphql.ExecutionResult;

@RestController
@RequestMapping("/graphql")
public class GraphController {
	
	private final GraphUseCase graphUseCase;
	
	public GraphController(GraphUseCase graphUseCase) {
		this.graphUseCase = graphUseCase;
	}
	
	@PostMapping
	public ResponseEntity<Object> graphByQuery(@RequestBody String query){
		ExecutionResult execute = graphUseCase.execute(query);
		
		return new ResponseEntity<>(execute, HttpStatus.OK);
	}
	
}
