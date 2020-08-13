// Same thing as before, same setters and getters for teams as Vaadin
public class Team{
	public int TeamRank;
	public String Team;
	public String TeamId;
	public int Played; 
	public int Points;
	public String League_Name;
	
	
		public Team(int TeamRank, String teamId,String Team, int played, int points, String league_Name ) {
		this.TeamRank = TeamRank;
		this.TeamId = teamId;
		this.Team = Team;
		this.Played = played;
		this.Points = points;
		this.League_Name = league_Name;
		}

	
	// Getters and Setters
	
	public String getTeamId() {
		return TeamId;
	}
	
	public void setTeamRank(String teamId) 
	{
		 this.TeamId = teamId;
	}
	
	public int getTeamRank() {
		return TeamRank;
	}
	
	public void setTeamRank(int TeamRank) 
	{
		 this.TeamRank = TeamRank;
	}
	
	public String getTeam() {
		return Team;
	}

	public void setTeam(String lName) {
		this.League_Name = lName;
	}
	
	public String getLeague_Name() {
		return this.League_Name;
	}

	public void setLeague_Name(String Team) {
		this.Team = Team;
	}

	public int getPlayed() {
		return Played;
	}

	public void setPlayed(int Played) {
		this.Played = Played;
	}

	public int getPoints() {
		return Points;
	}

	public void setPoints(int Points) {
		this.Points = Points;
	}
	
	
	
	@Override
	public String toString() {
		return String.format("Teams[TeamRank=%d, TeamId='%s',Team='%s', Played='%d', Points='%d', League_Name='%s' ]", 
				TeamRank, TeamId, Team, Played, Points, League_Name );
	}

}