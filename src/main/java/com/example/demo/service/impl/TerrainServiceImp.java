package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.models.Terrain;
import com.example.demo.repository.TerrainRepository;
import com.example.demo.service.TerrainService;

@Service

public class TerrainServiceImp implements TerrainService {

	@Autowired
	TerrainRepository ter;
	
	@Override
	public Terrain createTer(Terrain terrainRequest) {
		terrainRequest.setNom("Nom du terrain");
		terrainRequest.setPrix(50);
		terrainRequest.setDescr("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras quis malesuada nisl. Phasellus ac lorem id metus luctus aliquet. In hac habitasse platea dictumst.");
	Terrain newT = ter.save(terrainRequest);
		
		return newT;
	}

	@Override
	public List<Terrain> searchTer(Terrain terrainRequest) {
		List<Terrain> res= new ArrayList<>();
		List<Terrain> terrains = ter.findAll();
		for(Terrain t : terrains) {
			double result= distFrom(t.getLat(), t.getLng(), terrainRequest.getLat(), terrainRequest.getLng());
			if( result<15) {
				res.add(t);
			}
		}
		return res;
	}
	
	
	public static double distFrom(double lat1, double lng1, double lat2, double lng2) {
	    double earthRadius = 6371.0; // miles (or 6371.0 kilometers)
	    double dLat = Math.toRadians(lat2-lat1);
	    double dLng = Math.toRadians(lng2-lng1);
	    double sindLat = Math.sin(dLat / 2);
	    double sindLng = Math.sin(dLng / 2);
	    double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
	            * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	    double dist = earthRadius * c;

	    return dist;
	    }

	@Override
	public List<Terrain> getTers() {
		List<Terrain>ters=ter.findAll();
		return ters;
	}

}
