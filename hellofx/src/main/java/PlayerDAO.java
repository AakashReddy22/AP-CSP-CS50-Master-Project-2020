// League Data Access Organization, same thing as the Vaadin files in Demo2
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PlayerDAO {
	
	// Clearing the previous session with the user from production
    private Connection connection =null;
    
    public PlayerDAO() throws SQLException, ClassNotFoundException {
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
    

	private Player createPlayer(ResultSet rs) {
      Player p = new Player("","",0,"","");
      try {
    	  // Manually acquiring data because it wouldn't acquire like the other DAO files
         p.setFirstName(rs.getString("FirstName"));
         p.setLastName(rs.getString("LastName"));
         p.setLeagueRank(rs.getInt("LeagueRank"));
         p.setTeam(rs.getString("Team"));
         p.setLeague_Name(rs.getString("LEAGUE_NAME"));
          } catch (SQLException ex) {
      }
      return p;
   }
   
   public List<Player> getAllPlayers() {
	// Applying case sensitive data types and data names from DB
		  // Limiting to 100 records because there are thousands of records 
      String sql = ("SELECT p.FirstName,p.LastName,p.LeagueRank, t.Team, w.LEAGUE_NAME  "
				+ "FROM soccerdb.playerstats p, soccerdb.teamstanding t, soccerdb.worldleague w "
				+ "where p.TeamId=t.TeamId and p.LeagueId=w.LeagueId and t.LeagueId = p.LeagueId "
				+ "order by p.LeagueRank limit 100");  
      List<Player> list = new ArrayList<>();
      try {
    	// Manually creating a stmt when connected
         Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(sql);
         while (rs.next()) {
            Player p = new Player(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4), rs.getString(5));
            list.add(p);
         }
         rs.close();
         //con.close();
      } catch (SQLException ex) {
      }
      return list;
   }

}

