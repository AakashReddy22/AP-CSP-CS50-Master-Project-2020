package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.demo.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class PlayerService implements Serializable {
	private static final long serialVersionUID = 7228016096756071380L;
	// Applying the conditional to zero
	public int firstP=0; 
	public List<Player> players=new ArrayList<Player>();
				
	    public List<Player> getPlayerStats() 
	    {
	    	
	    	// First condition
	    	if(firstP<=0)
	    	{
		    	try{  
		    		Class.forName("com.mysql.jdbc.Driver"); 
		    		//  Establishing a connection with the database
	   			 	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/soccerdb","AppUser","Welcome@123"); 
					Statement stmt=con.createStatement();  
					// Exact select statement from the database that would print put the table
					ResultSet rs=stmt.executeQuery("SELECT p.FirstName,p.LastName,p.LeagueRank, t.Team, w.LEAGUE_NAME  "
							+ "FROM soccerdb.playerstats p, soccerdb.teamstanding t, soccerdb.worldleague w "
							+ "where p.TeamId=t.TeamId and p.LeagueId=w.LeagueId and t.LeagueId = p.LeagueId "
							+ "order by p.LeagueRank limit 10");  
					
					while(rs.next()) 
			    	{		// Setting the different parameters based upon their data type
				    		Player ps = new Player(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4), rs.getString(5)); 
				    		this.players.add(ps);
			    	}
					
						
					con.close();
				// Prints if an error has occurred, such as a lost connection etc.
				}catch(Exception e){ System.out.println("Database Access Error PLAYER. Check the DB is up and running");}  
		    	firstP = 1; 
	    	}
	    	return players;
	    }

    
}
 


