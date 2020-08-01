package hellofx;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import hellofx.Player;

public class PlayerDAO implements DAO {
	
    private Connection connection =null;
    
    public PlayerDAO() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        if(connection==null)
        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/soccerdb", "AppUser", "Welcome@123");
    }
    
    public void shutdown() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
    

	private Player createPlayer(ResultSet rs) {
      Player p = new Player("","",0,"","");
      try {
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
      String sql = ("SELECT p.FirstName,p.LastName,p.LeagueRank, t.Team, w.LEAGUE_NAME  "
				+ "FROM soccerdb.playerstats p, soccerdb.teamstanding t, soccerdb.worldleague w "
				+ "where p.TeamId=t.TeamId and p.LeagueId=w.LeagueId and t.LeagueId = p.LeagueId "
				+ "order by p.LeagueRank limit 100");  
      List<Player> list = new ArrayList<>();
      try {
         Class.forName(DRIVER);
         Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(sql);
         while (rs.next()) {
            Player p = new Player(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4), rs.getString(5));
            list.add(p);
         }
         rs.close();
         //con.close();
      } catch (ClassNotFoundException | SQLException ex) {
      }
      return list;
   }

}