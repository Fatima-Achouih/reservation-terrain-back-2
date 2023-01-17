package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.models.Event;
import com.example.demo.models.Reservation;

import com.example.demo.repository.ResRepository;
import com.example.demo.repository.TerrainRepository;
import com.example.demo.service.ResService;


@Service
public class ResServiceImp implements ResService {
	@Autowired
	ResRepository res;
	@Autowired
	TerrainRepository tr;

	@Override
	public Reservation createRes(Reservation resRequest) {
		
		Reservation r = new Reservation();
		r.setTitle("TITLE");
		
		r.setNom(resRequest.getNom());
		r.setEmail(resRequest.getEmail());
	    r.setTel(resRequest.getTel());
	    
	    r.setDate(resRequest.getDate());
	    r.setHi(resRequest.getHi());
	    r.setHf(resRequest.getHf());
	    
	    r.setStart(resRequest.getDate()+"T"+resRequest.getHi());
	    r.setEnd(resRequest.getDate()+"T"+resRequest.getHf());
	    
	    r.setTerrId(resRequest.getTerrId());
	    
	    r.setTer(tr.findById(resRequest.getTerrId()));
		
		Reservation newR = res.save(r);
		
		return newR;
	}

	@Override
	public List<Event> getres() {
		List<Event> events = new ArrayList<>();
		List<Reservation>ters=res.findAll();
		
for(Reservation r: ters) {
			
			Event ev = new Event();
			
			BeanUtils.copyProperties(r, ev);
		
			events.add(ev);
		}
		return events;
	}

	@Override
	public List<Event> getResByTer(String id) {
		List<Event> events = new ArrayList<>();
		List<Reservation>ters=res.findAllByTerrId(id);
for(Reservation r: ters) {
			
			Event ev = new Event();
			
			BeanUtils.copyProperties(r, ev);
		
			events.add(ev);
		}
		return events;
	}
	
	

}
