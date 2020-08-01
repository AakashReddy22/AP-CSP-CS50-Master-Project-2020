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

public class TeamService implements Serializable {
	private static final long serialVersionUID = 7528016096756071380L;
	// Applying the conditional to zero
	public int firstP=0; 
	public List<Teams> teams=new ArrayList<Teams>();
	
	
			
	    public List<Teams> getTeamStats() 
	    {
	    	// First condition
	    	if(firstP<=0)
	    	{
		    	try{  
		    		Class.forName("com.mysql.jdbc.Driver"); 
		    	//  Establishing a connection with the database
	   			 	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/soccerdb","AppUser","Welcome@123"); 
										
					Statement stmt2=con.createStatement();  
					// Exact select statement from the database that would print put the table
					ResultSet rs2=stmt2.executeQuery("SELECT  t.teamrank, t.teamid, t.Team, t.played, t.Points, w.LEAGUE_NAME "
							+ "FROM soccerdb.teamstanding t, soccerdb.worldleague w "
							+ "where t.LeagueId = w.LeagueId  order by t.teamrank limit 10");  
					
					while(rs2.next()) 
			    	{		// Setting the different parameters based upon their data type
				    		Teams t = new Teams(rs2.getInt(1),rs2.getString(2),rs2.getString(3), rs2.getInt(4),rs2.getInt(5),rs2.getString(6)); 
				    		this.teams.add(t);
			    	}
					
					con.close();
					// Prints if an error has occurred, such as a lost connection etc.	
				}catch(Exception e){ System.out.println("Database Access Error for TEAMS. Check the DB is up and running");}  
		    	firstP = 1; 
	    	}
	    	return this.teams;
	    }
    
	 
}
 


