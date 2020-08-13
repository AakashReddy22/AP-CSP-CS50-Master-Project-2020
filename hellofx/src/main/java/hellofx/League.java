package hellofx;


public class League{
	
	private String LEAGUE_NAME;
	private String COUNTRY;
	private int RANK2018; 
	private int RANK2019;

	public League(String LEAGUE_NAME, String COUNTRY, int RANK2018, int RANK2019 ) {
		
		this.LEAGUE_NAME = LEAGUE_NAME;
		this.COUNTRY = COUNTRY;
		this.RANK2018 = RANK2018;
		this.RANK2019 = RANK2019;
	}
	
		
	// Getters and Setters
	public String getLEAGUE_NAME() {
		return LEAGUE_NAME;
	}
	
	public void setLEAGUE_NAME(String LEAGUE_NAME) 
	{
		 this.LEAGUE_NAME = LEAGUE_NAME;
	}
	
	public String getCOUNTRY() {
		return COUNTRY;
	}

	public void setCOUNTRY(String COUNTRY) {
		this.COUNTRY = COUNTRY;
	}

	public int getRANK2018() {
		return RANK2018;
	}

	public void setRANK2018(int RANK2018) {
		this.RANK2018 = RANK2018;
	}

	public int getRANK2019() {
		return RANK2019;
	}

	public void setRANK2019(int RANK2019) {
		this.RANK2019 = RANK2019;
	}
	
	
	
	
}