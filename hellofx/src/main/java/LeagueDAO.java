// League Data Access Organization, same thing as the Vaadin files in Demo2
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LeagueDAO{
	
	// Clearing the previous session with the user from production 
    private Connection connection =null;
    
    public LeagueDAO() throws SQLException, ClassNotFoundException {
    	// Acquiring the JDBC drivers
        Class.forName("com.mysql.jdbc.Driver");
        if(connection==null)
        	// If the connection was cleared already, the program re-establishes the connection with the database
        	connection = DriverManager.getConnection("Absent for security reasons");
    }
    
    public void shutdown() throws SQLException {
        if (connection != null) {
        	// Abandoning the program if the connection is still null
            connection.close();
        }
    }
  
   
   public List<League> getAllLeagues() {
	  // Applying case sensitive data types and data names from DB
	  // Limiting to 100 records because there are thousands of records 
      String sql = ("SELECT  LEAGUE_NAME, COUNTRY, RANK2018, RANK2019 FROM soccerdb.worldleague limit 100");  
      List<League> list = new ArrayList<>();
      try {
    	 // Manually creating a stmt when connected
         Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(sql);
         while (rs.next()) {
            League p = new League(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
            list.add(p);
         }
         rs.close();
      } catch (SQLException ex) {
      }
      return list;
   }

}
