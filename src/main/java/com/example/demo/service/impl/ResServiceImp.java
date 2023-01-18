package com.example.demo.service.impl;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.exeption.UsernameNotFoundException;
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
	
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:MM");
	DateFormat formatter = new SimpleDateFormat("HH:mm");
	DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	@Override
	public ResponseEntity<Reservation> createRes(Reservation resRequest) {
		
		Reservation r = new Reservation();
		r.setTitle("Réservé");
		
		r.setNom(resRequest.getNom());
		r.setEmail(resRequest.getEmail());
	    r.setTel(resRequest.getTel());
	    
	    //compaire hi/hf
	    
	    
	    try {
			java.sql.Time d = new java.sql.Time(formatter.parse(resRequest.getHi()).getTime());
			java.sql.Time f = new java.sql.Time(formatter.parse(resRequest.getHf()).getTime());
			
			
			
			if(d.after(f)) {
				throw new UsernameNotFoundException("Heure début est inferieur à heure fin");
			}
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    //compaire date
	    
	   
	    LocalDate date = LocalDate.parse(resRequest.getDate(), form);
	    
	    if(date.isBefore(java.time.LocalDate.now())) {
	    	throw new UsernameNotFoundException("Entrez une date valide");
	    }
	    r.setDate(resRequest.getDate());
	    
	    r.setHi(resRequest.getHi());
	    r.setHf(resRequest.getHf());
	    
	    r.setStart(resRequest.getDate()+"T"+resRequest.getHi());
	    r.setEnd(resRequest.getDate()+"T"+resRequest.getHf());
	    
	    r.setTerrId(resRequest.getTerrId());
	    
	    r.setTer(tr.findById(resRequest.getTerrId()));
	    
	    
	    r.setBackgroundColor("rgb(234,220,249)");
		r.setBorderColor("#8732de");
		
		Reservation newR = res.save(r);
		throw new UsernameNotFoundException("Réservation réussi");
		
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
