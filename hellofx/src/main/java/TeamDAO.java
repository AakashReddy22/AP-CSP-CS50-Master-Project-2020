import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//League Data Access Organization, same thing as the Vaadin files in Demo2
public class TeamDAO {

	// Clearing the previous session with the user from production 
    private Connection connection =null;
    
    public TeamDAO() throws SQLException, ClassNotFoundException {
    	// Acquiring the JDBC drivers
        Class.forName("com.mysql.jdbc.Driver");
        if(connection==null)
        	// If the connection was cleared already, the program re-establishes the connection with the database
        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/soccerdb", "AppUser", "Welcome@123");
    }
    
    public void shutdown() throws SQLException {
        if (connection != null) {
        	// Abandoning the program if the connection is still null
            connection.close();
        }
    }
    
    
    public List<Team> getTeamStandings() {
    	// Applying case sensitive data types and data names from DB
  	  // Limiting to 100 records because there are thousands of records 
        String sql = ("SELECT  t.teamrank, t.teamid, t.Team, t.played, t.Points, w.LEAGUE_NAME "
        		+ "FROM soccerdb.teamstanding t, soccerdb.worldleague w "
        		+ "where t.LeagueId = w.LeagueId  order by t.teamrank limit 100");  
        List<Team> list = new ArrayList<>();
        try {
       	 // Manually creating a stmt when connected
            Statement stmt = connection.createStatement();
           ResultSet rs2 = stmt.executeQuery(sql);
           while (rs2.next()) {
              Team p = new Team(rs2.getInt(1),rs2.getString(2),rs2.getString(3), rs2.getInt(4),rs2.getInt(5),rs2.getString(6));
              list.add(p);
           }
           rs2.close();
        } catch (SQLException ex) {
        }
        return list;
     }
    
	
}






