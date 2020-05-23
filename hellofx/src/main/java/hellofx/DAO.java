// Implementing the Same DAO interface
// Creating an interface called Data Access Organization aka DAO
package hellofx;

public interface DAO {
   public static final String DB_URL =
		// Offering the program the database connection to find data for JavaFx	   
      "jdbc:mysql://localhost:3306/soccerdb";
   public static final String DRIVER =
		// Offering the JDBC Driver
      "com.mysql.jdbc.Driver";
// Giving the program access to extract variables with User password, accessible in production mode
   public static final String USER = "AppUser";
   public static final String PASS = "Welcome@123";
}