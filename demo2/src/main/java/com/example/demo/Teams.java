/*
Aakash Reddy
CS50 MAster Project
POCO class # 3
*/
package com.example.demo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Teams implements Serializable {
	private static final long serialVersionUID = 6228916096756071380L;
	@Id
	@GeneratedValue
	// Getting names from database of Teams
	public int TeamRank;
	public String Team;
	public String TeamId;
	public int Played; 
	public int Points;
	public String League_Name;
	
	
		public Teams(int TeamRank, String teamId,String Team, int played, int points, String league_Name ) {
		this.TeamRank = TeamRank;
		this.TeamId = teamId;
		this.Team = Team;
		this.Played = played;
		this.Points = points;
		this.League_Name = league_Name;
		}

	
	// Getters and Setters
	
	public String getTeamId() {
		return TeamId;
	}
	
	public void setTeamRank(String teamId) 
	{
		 this.TeamId = teamId;
	}
	
	public int getTeamRank() {
		return TeamRank;
	}
	
	public void setTeamRank(int TeamRank) 
	{
		 this.TeamRank = TeamRank;
	}
	
	public String getTeam() {
		return Team;
	}

	public void setTeam(String Team) {
		this.Team = Team;
	}

	public int getPlayed() {
		return Played;
	}

	public void setPlayed(int Played) {
		this.Played = Played;
	}

	public int getPoints() {
		return Points;
	}

	public void setPoints(int Points) {
		this.Points = Points;
	}
	
	
	
	@Override
	// Printing final String of data
	public String toString() {
		return String.format("Teams[TeamRank=%d, TeamId='%s',Team='%s', Played='%d', Points='%d', League_Name='%s' ]", 
				TeamRank, TeamId, Team, Played, Points, League_Name );
	}

}