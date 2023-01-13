package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.models.Terrain;
import com.example.demo.service.TerrainService;

@RestController
@RequestMapping("/terrain")

public class TerrainController {
	
	@Autowired
	TerrainService ter;
	
	@PostMapping
	public  ResponseEntity<Terrain> createEmploye(@RequestBody Terrain terrainRequest) {

		

		Terrain terrainRes = ter.createTer(terrainRequest);
		

		return new ResponseEntity<Terrain>(terrainRes,HttpStatus.CREATED);
	}
	
	@PostMapping(path = "/near")
	  public ResponseEntity<List<Terrain>>
	  searchTerrain(@RequestBody Terrain terrainRequest) {
	  
	  List<Terrain> terResponses =ter.searchTer(terrainRequest);
	  
	  
	  
	  return new ResponseEntity<List<Terrain>>(terResponses,
	  HttpStatus.OK); }
	
	@GetMapping
	  public ResponseEntity<List<Terrain>>
	  getAllters() {
	  
	  List<Terrain> demResponses =ter.getTers();
	  
	  
	  
	  return new ResponseEntity<List<Terrain>>(demResponses,
	  HttpStatus.OK); }

}
