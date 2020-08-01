
package hellofx;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import hellofx.League;

public class LeagueDAO implements DAO {
	
    private Connection connection =null;
    
    public LeagueDAO() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        if(connection==null)
        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/soccerdb", "AppUser", "Welcome@123");
    }
    
    public void shutdown() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
    
   
   public List<League> getAllLeagues() {
      String sql = ("SELECT  LEAGUE_NAME, COUNTRY, RANK2018, RANK2019 FROM soccerdb.worldleague limit 100");  
      List<League> list = new ArrayList<>();
      try {
         Class.forName(DRIVER);
         Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(sql);
         while (rs.next()) {
            League p = new League(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
            list.add(p);
         }
         rs.close();
      } catch (ClassNotFoundException | SQLException ex) {
      }
      return list;
   }

}