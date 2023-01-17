package com.example.demo.models;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserv")

public class Reservation {
	
	@Id
	@GeneratedValue
	private long id;
	private String nom;
	private String email;
	private String tel;
	private String title;
	private String start;
	private String end;
	private String date;
	private String hi;
	private String hf;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHi() {
		return hi;
	}
	public void setHi(String hi) {
		this.hi = hi;
	}
	public String getHf() {
		return hf;
	}
	public void setHf(String hf) {
		this.hf = hf;
	}
	
	
	
	
	

}
