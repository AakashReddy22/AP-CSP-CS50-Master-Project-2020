/*
Aakash Reddy
CS50 MAster Project
Footer Data
*/

package com.example.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class FooterData {
	
	// Creating a range of parameters fir the user to enter at bottom of JavaFx page to subscribe to WS+
	public MainView mainView; 
	public TextField firstName = new TextField("First Name");
	public TextField lastName = new TextField("Last Name");
	public TextField email = new TextField("Email");
	// Saving users email's in User Subscriptions
	public Button save = new Button("Save");
	
	public FooterData(MainView mainView)
	{
		this.mainView = mainView;
		
		// Adding the aforementioned parameters into manView
		this.mainView.add(firstName, lastName, email);
	}
	
}

