package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.models.Event;
import com.example.demo.models.Reservation;

import com.example.demo.repository.ResRepository;
import com.example.demo.service.ResService;


@Service
public class ResServiceImp implements ResService {
	@Autowired
	ResRepository res;

	@Override
	public Reservation createRes(Reservation resRequest) {
		Reservation newR = res.save(resRequest);
		
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
	
	

}