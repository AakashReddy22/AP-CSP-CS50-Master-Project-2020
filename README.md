# AP-CSP-CS50-Master-Project-2020
Abstract: I have built an application that displays world soccer standing across leagues, teams and players in top leagues. I designed table schema and imported select data into MySQL database. I then designed and built a client server application using JAVA, JavaFX, Vaadin UI, Maven project, Eclipse IDE and Tomcat Web Server.  

The play (Warning lots of grammatical errors (Couldnt be asked to resolve)):

1. Organization of code
There are 3 parts in my application: UI, server side data objects and JDBC connection manager and MySQL database for data storage.  
  Frontend development: The user interface consists of JavaFX/Vaadin components like BorderPane, StackPane to create scrollable data grids, 
TextField, Label, Button, HBox to group components and enable data entry.   
  Backend development:  I created 3 POCO data object classes with getters and setters for each database column for Player.class, 
Team.class and League.class. I also created data access objects (PlayerDAO.class, TeamDAO.class and LeagueDAO.class) that connect to MySQL
using JDBC Connection and I selected the data using SQL statements. I additionally compiled 3 SQL queries to feed data to 3 display grids 
in the UI.  
  Database development:  Using MySQL Workbench, I created SOCCERDB database, table schema for 
soccer data(PLAYERSTATS, TEAMSTANDING. WORLDLEAGUE), and used table import wizard to import data from FIFA website using csv 
files(Player Standing.csv, PremL Teams.csv etc.). I also tested the SQL queries before using them in the data access classes in JAVA and 
verified the data was accurate before using the queries. I created two text files(CopyRight.txt and UserSubscriptions.txt) 
with static text to be loaded for header display  and to save the user data entry in to a dynamic text file. I used JAVA and JavaFX 
components like File, BufferedReader , FileInputStream, Image, ImageView etc. to read and write from text and image files.  

2. Data Model
I built a data model using MySQL Workbench. First, created a new database schema SOCCERDB for my project. 
I then created PLAYERSTATS table and designed the columns I needed to store in database, their data types and key elements for player table like First Name, Last Name etc.  
I then created TEAMSTANDING table, columns and data types for storing team data and, finally, created WORLDLEAGUE table for league data. 
I then created a primary key for each table so the data I loaded is unique. I used comma delimited csv files to export data from the offical FIFA database. 
I then imported soccer data into the individual tables using data import wizard. From the JAVA data access classes, I used JDBC Connection class to connect to the MySQL database, 
furthermore, I used Statement class to create SQL statement and ResultSet container for saving data results from queries. 
I also used while loop to iterate through the result set and store the data into List container. 
I used the List container to bind the data from database TableView and then added the TableView to specific positions in the BorederPane(example League on left). 
One of the data inputs I’m capturing from the user and storing in a text file is an email that user can enter for subscribing to newsletter. I have not put any checks and validations to make sure user is entering a valid email. 
This is where the data entry is vulnerable.

3. Reparations and Greivances with my program
If I were given the opportunity to restart this program, I would definitely have just started with JavaFX. 
The process of learning Vaadin and adapting Spring Boot was educational, however the process just took way too long as I found my self debugging the program for hours upon hours every day for the last couple of weeks. 
When using JavaFX, the system and organization of labels, buttons and headers were all much more intuitive and I really feel that I could have made a fantastic JavaFX application with the time I spent debugging on the web server. 
Although I learned how to use services used by developers in software engineering companies, I really feel that I could have made an excellent project on JavaFX if I got the time back from debugging Vaadin.
