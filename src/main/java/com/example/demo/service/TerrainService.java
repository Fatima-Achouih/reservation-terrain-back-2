package com.example.demo.service;

import java.util.List;

import com.example.demo.models.Terrain;

public interface TerrainService {

	Terrain createTer(Terrain terrainRequest);

	List<Terrain> searchTer(Terrain terrainRequest);

	List<Terrain> getTers();

}
