/*
Aakash Reddy
CS50 Master Project
Main File
*/

package com.example.demo;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.font.TextAttribute;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.hibernate.boot.model.source.internal.hbm.ResultSetMappingBinder;
import org.hibernate.resource.beans.container.spi.BeanContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.SelectionMode;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.selection.SingleSelect;
import com.vaadin.flow.router.Route;

import elemental.css.CSSStyleDeclaration.Unit;

import com.example.demo.Player;
import com.example.demo.Teams;
import com.example.demo.Leagues;
import com.example.demo.PlayerService;
import com.example.demo.TeamService;
import com.example.demo.LeagueService;
import com.vaadin.shared.ui.label.ContentMode;


@Route
public class MainView extends VerticalLayout {

	// Originally setting to NULL
	private static final String String = null;
	//@Autowired
    
	public PlayerService pservice = new PlayerService();
	public List<Player> players=new ArrayList<Player>();
	public Grid<Player> gridP = new Grid<>(Player.class);
	
	public TeamService tservice = new TeamService();
	public List<Teams> teams=new ArrayList<Teams>();
	public Grid<Teams> gridT = new Grid<>(Teams.class);
	
	public LeagueService lservice = new LeagueService();
	public List<Leagues> leagues=new ArrayList<Leagues>();
	public Grid<Leagues> gridL = new Grid<>(Leagues.class);	
	
	public java.lang.String fileAsString;
	public String pFName;
	public String pLName;
	
	interface StringConcat{

	    public String sconcat(String a, String b);
	}
	
	public MainView() throws SQLException 
	{
			
    	// MAIN CONTAINER
		getStyle().set("background-color", "lightblue");
		getStyle().set("border","1px solid blue");
		getStyle().set("overflow", "auto");
		setSizeUndefined();
		
		// Using a lambda function to concatenate strings together
		StringConcat s = (string1, string2) -> string1 + string2;
		Label formatText = new Label("Title: "+s.sconcat("CS50 Master Project 2020 :  ", "World Soccer Plus")); 
		add(formatText);
        
			// Printing the copyright statement into the Web layout
		 final File file = new File("/Users/Aakas/Desktop/CopyRight.txt");
		 // Reading the contents of the file
    	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    	String fileAsString;
		    	
					while ((fileAsString = br.readLine()) != null) {
						add(fileAsString);
					}
				} catch (IOException e) 
		     {
					e.printStackTrace();
				}
	     // Creating a label for the copyright statement to be placed in   
	     Label emptyLabel2 = new Label("");
	     emptyLabel2.setHeight("1em");
	     add(emptyLabel2);
	     
		// Styling the customization and player contents of the Vaadin UI
		this.players = pservice.getPlayerStats();
		this.gridP.setItems(this.players);
		this.gridP.setVisible(true);
		//this.gridP.setSizeUndefined();
		this.gridP.setSelectionMode(SelectionMode.SINGLE);
		this.gridP.setWidth("98%");
		this.gridP.setHeight("50%");
		this.gridP.setEnabled(true);
	
		// Implementing the title of the first grid 
		add("\n\n");
		// Starting with players and then Teams, Leagues etc. 
		add("World Soccer Plus - World Soccer Standings by Players");
		add(this.gridP);
		add("\n\n");
		
		// Posting the team stats of the program
		this.teams = tservice.getTeamStats();
		this.gridT.setItems(this.teams);
		this.gridT.setVisible(true);
		//this.gridT.setSizeUndefined();
		this.gridT.setWidth("98%");
		this.gridT.setHeight("40%");
		this.gridT.setEnabled(true);
		
		// Creating the second grid title
		add("World Soccer Plus - World Soccer Standings by Teams");
		add(this.gridT);
		add("\n\n");
		
		// Customizing the leagues grid
		this.leagues = lservice.getLeagueStats();
		this.gridL.setItems(this.leagues);
		this.gridL.setVisible(true);
		//this.gridL.setSizeUndefined();
		this.gridL.setWidth("98%");
		this.gridL.setHeight("40%");
		this.gridL.setEnabled(true);
		// Final header for the last grid			 
		add("World Soccer Plus - World Soccer Standings by Leagues");
		add(this.gridL);
		
		// Setting desired characteristics
		setSizeFull();
		setMargin(true);
		setSpacing(false);
		setPadding(false);
		
	 
	}

		
   }



