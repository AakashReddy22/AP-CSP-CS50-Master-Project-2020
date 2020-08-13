/*
Aakash Reddy
CS50 MAster Project
POCO class # 2
*/

package com.example.demo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Player implements Serializable {
	private static final long serialVersionUID = 6228016096756071380L;
	@Id
	@GeneratedValue
	// Getting these vales/data from the MySql database
	private String firstName;
	private String lastName;
	private int LeagueRank;
	private String Team;
	private String League_Name;
	

	// Referring to the current objects, which are the data figures from the databse
	public Player(String firstName, String lastName, int LeagueRank, String Team, String LeagueName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.LeagueRank = LeagueRank;
		this.Team = Team;
		this.League_Name = LeagueName;
		}
	
	// Getters and Setters
	public int getLeagueRank() {
		return LeagueRank;
	}

	public void setLeagueRank(int LeagueRank) 
	{
		 this.LeagueRank = LeagueRank;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTeam() {
		return Team;
	}

	public void setTeam(String Team) {
		this.Team = Team;
	}
	
	public String getLeague_Name() {
		return League_Name;
	}

	public void setLeague_Name(String League_Name) {
		this.League_Name = League_Name;
	}
	
	@Override
	public String toString() {
		return String.format("Player[LeagueRank=%d, firstName='%s', lastName='%s', League_Name='%s', Team='%s']", LeagueRank,
				firstName, lastName, League_Name, Team);
	}

}