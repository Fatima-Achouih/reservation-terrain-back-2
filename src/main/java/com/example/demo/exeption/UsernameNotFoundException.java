package com.example.demo.exeption;

public class UsernameNotFoundException extends RuntimeException{
	   public UsernameNotFoundException(String message){
	    super(message);
	   }
	  }
