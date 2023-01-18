package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.models.Event;
import com.example.demo.models.Reservation;

import com.example.demo.service.ResService;





@RestController
@RequestMapping("/res")

public class ResController {
	
	@Autowired
	
	ResService rs;

	@PostMapping
	public  ResponseEntity<Reservation> createEmploye(@RequestBody Reservation resRequest) {

		

		//Reservation res = rs.createRes(resRequest);
		
		

		return rs.createRes(resRequest);
	}
	
	@GetMapping
	  public ResponseEntity<List<Event>>
	  getAllters() {
	  
	  List<Event> demResponses =rs.getres();
	  
	  
	  
	  
	  
	  return new ResponseEntity<List<Event>>(demResponses,
	  HttpStatus.OK); }
	
	@GetMapping(path = "/{id}")
	  public ResponseEntity<List<Event>>
	  getAllResT(@PathVariable String id) {
	  
	  List<Event> demResponses =rs.getResByTer(id);
	  
	  
	  
	  return new ResponseEntity<List<Event>>(demResponses,
	  HttpStatus.OK); }
	
}
