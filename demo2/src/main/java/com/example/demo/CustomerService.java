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

import com.example.demo.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class CustomerService implements Serializable {
	private static final long serialVersionUID = 7128016096756071380L;
	public int first=0; 
	public List<Customer> customers=new ArrayList<Customer>();
	
    public List<Customer> findAll() {
    	
           	if(first<=0)
    	{
	    	try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","AppUser","Welcome@123");  
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("SELECT id, first_name, last_name FROM customers");  
				
				while(rs.next()) 
		    	{
			    		Customer cs = new Customer(rs.getString(1),rs.getString(2),rs.getString(3)); 
			    		this.customers.add(cs);
		    	}
				con.close(); 
			}catch(Exception e){ System.out.println("This program has self terminated. Please review your database connection");}  
	    	first = 1; 
    	}
		 
    	return customers;
    }
    
 }


