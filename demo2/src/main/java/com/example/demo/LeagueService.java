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

public class LeagueService implements Serializable {
	private static final long serialVersionUID = 7528116096756071380L;
	public int firstP=0; 
	// Implementation if List<> into a dynamic array (ArrayList<>)
	public List<Leagues> leagues=new ArrayList<Leagues>();
		
	    public List<Leagues> getLeagueStats() 
	    {
	    	
	    	if(firstP<=0)
	    	{
		    	try{  
		    		Class.forName("com.mysql.jdbc.Driver"); 
		    		// Establishing a connection between the user and database
	   			 	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/soccerdb","AppUser","Welcome@123"); 
										
					Statement stmt2=con.createStatement();  
					// Pasting the select statement from the database into the program, so the table gets printed
					ResultSet rs2=stmt2.executeQuery("SELECT  LEAGUE_NAME, COUNTRY, RANK2018, RANK2019"
							+ " FROM soccerdb.worldleague limit 10");  
					
					while(rs2.next()) 
			    	{
						Leagues l = new Leagues(rs2.getString(1),rs2.getString(2),rs2.getInt(3),rs2.getInt(4)); 
				    	this.leagues.add(l);
			    	}
					
					con.close();
				// Error statement if fields aren't applicable
				}catch(Exception e){ System.out.println("Database Access Error LEAGUES. Check the DB is up and running");}  
		    	firstP = 1; 
	    	}
	    	// Returning the array
	    	return this.leagues;
	    }
    
}


