/*
Aakash Reddy
CS50 MAster Project
POCO class #1
*/
package com.example.demo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Leagues implements Serializable {
	private static final long serialVersionUID = 6228916096756071880L;
	@Id
	@GeneratedValue
	// Acquiring data from MySql database
	private String LEAGUE_NAME;
	private String COUNTRY;
	private int RANK2018; 
	private int RANK2019;


	public Leagues(String LEAGUE_NAME, String COUNTRY, int RANK2018, int RANK2019 ) {
		
		this.LEAGUE_NAME = LEAGUE_NAME;
		this.COUNTRY = COUNTRY;
		this.RANK2018 = RANK2018;
		this.RANK2019 = RANK2019;
	}
	
		
	// Getters and Setters
	public String getLEAGUE_NAME() {
		return LEAGUE_NAME;
	}
	
	public void setLEAGUE_NAME(String LEAGUE_NAME) 
	{
		 this.LEAGUE_NAME = LEAGUE_NAME;
	}
	
	public String getCOUNTRY() {
		return COUNTRY;
	}

	public void setCOUNTRY(String COUNTRY) {
		this.COUNTRY = COUNTRY;
	}

	public int getRANK2018() {
		return RANK2018;
	}

	public void setRANK2018(int RANK2018) {
		this.RANK2018 = RANK2018;
	}

	public int getRANK2019() {
		return RANK2019;
	}

	public void setRANK2019(int RANK2019) {
		this.RANK2019 = RANK2019;
	}
	
	
	
	@Override
	// Assigning the variables to Leagues and printing if they are Strings or Ints
	public String toString() {
		return String.format("Leagues[LEAGUE_NAME='%s', COUNTRY='%s', RANK2018='%d', RANK2019='%d' ]", LEAGUE_NAME, COUNTRY, RANK2018, RANK2019);
	}

}