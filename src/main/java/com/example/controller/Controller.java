package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.services.contracts.IWeatherServices;

@RestController
@RequestMapping("weather")
public class Controller {

	@Autowired
	IWeatherServices weatherServices;
	
	@GetMapping("/{city}")
	public ResponseEntity<?> getAllLibraries(@PathVariable String city){
		try {
			return new ResponseEntity<>(weatherServices.getHttpConnection(city) ,  HttpStatus.ACCEPTED);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error, no cinemas were found", HttpStatus.NOT_FOUND);
		}
	}
	
	
}

