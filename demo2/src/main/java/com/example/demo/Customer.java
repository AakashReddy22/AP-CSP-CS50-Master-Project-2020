package com.example.demo;

import java.io.Serializable;
import javax.persistence.Entity;

public class Customer implements Serializable{
	private static final long serialVersionUID = 6128016096756071380L;
	
    public String id;
    private String firstName; 
    private String lastName;
    public Customer(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
	public Object getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public Object getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}
	public Object getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
  
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return String.format("Customer[id=%s, firstName='%s', lastName='%s']", id,
				firstName, lastName);
	}
}