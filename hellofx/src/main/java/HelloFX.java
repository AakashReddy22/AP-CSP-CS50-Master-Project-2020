import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import hellofx.DAO;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.beans.value.*;
import javafx.collections.*;
import javafx.collections.transformation.*;
import javafx.geometry.Insets;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class HelloFX extends Application {
	  // Originally setting all program variables to NULL whenever program gets recompiled and run
	  private PlayerDAO playerDA = null; 
	  private LeagueDAO leagueDA = null;
	  private TeamDAO teamDA = null; 

    @Override
    public void start(Stage priorityPresent) {
    	// Setting the title for the JavaFx application
    	priorityPresent.setTitle("World Soccer Plus - Welcome to the Soccer World!!");
    	
    	StaticLambdaClass.StaticlStrCat lambdaCall 
        = new StaticLambdaClass.StaticlStrCat(); 
    	
    	
    	String s;
        // USing lambda function from static class concatenate two string and return header text
        String formatText = lambdaCall.returnStrCat();
        // Posting the CopyRight disclaimer at the top of the page once more
        List<String> headerText = new ArrayList<String>();
        final File file = new File("/Users/Aakas/Desktop/CopyRight.txt");
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	    	String fileAsString;
	    	
				while ((fileAsString = br.readLine()) != null) {
					headerText.add(fileAsString+"\n");
				}
			} catch (IOException e) 
	     {
				e.printStackTrace();
			}
		
	    headerText.add("\n"); 
        
        // Styling the header to make it pop out
		 formatText = formatText + "\n"+ headerText; 
		 Label headerTop = new Label(formatText);
		 headerTop.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
  	  
	    //Read and set header text from local file
		VBox header = new VBox(headerTop); 
		// Setting hexadecimal color for header
		String style = "-fx-background-color: #B9D2EB";
		header.setStyle(style);
		
		// Set the header as the top pane
		BorderPane root = new BorderPane();
	    StackPane top = new StackPane(header);
        top.setPrefHeight(100);
	    root.setTop(top);
		
		// Creating Footer section here. It has text, text field for email and asve button
        Label label = new Label("Enter Email to subscribe to monthly World Soccer Plus Newsletter: 	");
    	label.setFont(new Font("Arial", 14));
    	TextField textField = new TextField();
    	textField.setPrefWidth(250);
    	
    	FileInputStream input=null;
		try {
			// Getting a picture of an external image, icon in this case, and placing it in the save box
			input = new FileInputStream("C:/Users/Aakas/Desktop/SaveIcon.png");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		// Placing the image on the label
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
    	
        Button button = new Button("Save", imageView);

        button.setOnAction(action -> {
            
        	FileWriter fileWriter;
			try {
				// Writing the USer input into UserSubscriptions in JavaFx
				fileWriter = new FileWriter("C:/Users/Aakas/Desktop/UserSubscriptions.txt", true);
				fileWriter.write(textField.getText());
				fileWriter.write("\n");
	            fileWriter.close();
	            textField.setText("");
			} catch (IOException e) {
				// Placeholder for catch exception
				e.printStackTrace();
			}
            
        });
		
	    // Setting the same exact color for the footer as well
	    label.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        //Set footer controls to capture user email in a local text file
	    HBox hbox = new HBox(label, textField, button);
	    String styleFooter = "-fx-background-color: #B9D2EB";
	    hbox.setStyle(styleFooter);
	    
	    // Set the footer on bottom pane 
        root.setBottom(hbox);
        
            	
    	try {
			playerDA = new PlayerDAO();
			leagueDA = new LeagueDAO();
			teamDA = new TeamDAO();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	// Setting League standings on the left of the display 
        TableView<League> leagueTable = new TableView<>();
        TableColumn<League, String> lName = new TableColumn<>("World League Name");
        lName.setCellValueFactory(new PropertyValueFactory<>("LEAGUE_NAME"));
        TableColumn<League, String> cntry = new TableColumn<>("League Country");
        cntry.setCellValueFactory(new PropertyValueFactory<>("COUNTRY"));
        TableColumn<League, String> rank18 = new TableColumn<>("League Rank in 2018");
        rank18.setCellValueFactory(new PropertyValueFactory<>("RANK2018"));
        TableColumn<League, String> rank19 = new TableColumn<>("League Rank in 2019");
        rank19.setCellValueFactory(new PropertyValueFactory<>("RANK2019"));
        
        leagueTable.getColumns().addAll(lName, cntry, rank18, rank19);
        leagueTable.getItems().addAll(leagueDA.getAllLeagues());
        
    	
    	// Set player standings in the center of the display 
    	 TableView<Player> playerTable = new TableView<>();
         TableColumn<Player, String> firstNameCol = new TableColumn<>("Player First Name");
         firstNameCol.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
         TableColumn<Player, String> lastNameCol = new TableColumn<>("Player Last Name");
         lastNameCol.setCellValueFactory(new PropertyValueFactory<>("LastName"));
         TableColumn<Player, String> teamCol = new TableColumn<>("Player Team Name");
         teamCol.setCellValueFactory(new PropertyValueFactory<>("Team"));
         TableColumn<Player, String> leagueRankCol = new TableColumn<>("Player League Rank");
         leagueRankCol.setCellValueFactory(new PropertyValueFactory<>("LeagueRank"));
         TableColumn<Player, String> leagueNameCol = new TableColumn<>("Player League Name");
         leagueNameCol.setCellValueFactory(new PropertyValueFactory<>("League_Name"));
         
         playerTable.getColumns().addAll(firstNameCol, lastNameCol, leagueRankCol, teamCol, leagueNameCol);
         playerTable.getItems().addAll(playerDA.getAllPlayers());
         
                        
         // Set Team standings on the Right of the display 
         TableView<Team> TeamTable = new TableView<>();
         TableColumn<Team, String> tRank = new TableColumn<>("Team Rank");
         tRank.setCellValueFactory(new PropertyValueFactory<>("TeamRank"));
         TableColumn<Team, String> tID = new TableColumn<>("Team ID");
         tID.setCellValueFactory(new PropertyValueFactory<>("TeamId"));
         TableColumn<Team, String> tName = new TableColumn<>("Team Name");
         tName.setCellValueFactory(new PropertyValueFactory<>("Team"));
         TableColumn<Team, String> played = new TableColumn<>("Games Played");
         played.setCellValueFactory(new PropertyValueFactory<>("Played"));
         TableColumn<Team, String> points = new TableColumn<>("Total Points Scored");
         points.setCellValueFactory(new PropertyValueFactory<>("Points"));
         TableColumn<Team, String> tlName = new TableColumn<>("Team League Name");
         tlName.setCellValueFactory(new PropertyValueFactory<>("League_Name"));
         
         // Compiling all of the graphs 
         TeamTable.getColumns().addAll(tRank, tID, tName, played, points,tlName );
         TeamTable.getItems().addAll(teamDA.getTeamStandings());
      
         StackPane left = new StackPane(leagueTable);
         left.setPrefWidth(550);
         root.setLeft(left);
         root.setCenter(playerTable);
         
         StackPane right = new StackPane(TeamTable);
         right.setPrefWidth(800);
         root.setRight(right);
         
         // Creating a color base for the background
         Scene scene = new Scene(root, 600, 400, Color.LIGHTBLUE);
         
         // phenomenalizing the scene of the JavaFx application
         priorityPresent.setScene(scene);
         priorityPresent.setMaximized(true);
         priorityPresent.show();
    	
    	      
        
    }
    
    @Override
    public void stop() throws Exception {
        if (this.playerDA != null) {
        	this.playerDA.shutdown();
        }
    }


    public static void main(String[] args) {
        launch();
    }

}