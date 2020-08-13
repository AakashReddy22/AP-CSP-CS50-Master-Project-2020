// POCO class 5
public class Player{
	
	private String firstName;
	private String lastName;
	private int LeagueRank;
	private String Team;
	private String League_Name;
	

	public Player(String firstName, String lastName, int LeagueRank, String Team, String LeagueName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.LeagueRank = LeagueRank;
		this.Team = Team;
		this.League_Name = LeagueName;
		}
	
	// Getters and Setters
	public int getLeagueRank() {
		return LeagueRank;
	}

	public void setLeagueRank(int LeagueRank) 
	{
		 this.LeagueRank = LeagueRank;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTeam() {
		return Team;
	}

	public void setTeam(String Team) {
		this.Team = Team;
	}
	
	public String getLeague_Name() {
		return League_Name;
	}

	public void setLeague_Name(String League_Name) {
		this.League_Name = League_Name;
	}
	
	
}