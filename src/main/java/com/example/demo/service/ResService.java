package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.models.Event;
import com.example.demo.models.Reservation;

public interface ResService {

	ResponseEntity<Reservation> createRes(Reservation resRequest);

	List<Event> getres();

	List<Event> getResByTer(String id);

}
