package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Reservation;

@Repository
public interface ResRepository extends JpaRepository<Reservation, Long>{

}
