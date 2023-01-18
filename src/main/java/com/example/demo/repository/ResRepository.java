package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.models.Reservation;

@Repository
public interface ResRepository extends JpaRepository<Reservation, Long>{
	
	List<Reservation> findAllByTerrId(String id);
	
	List<Reservation> findAllByTerrIdAndDate(String id,String date);
	


}
