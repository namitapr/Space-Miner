package ProjectPackage;

public class Statistics {
	
	int gamesPlayed;
	int gamesWon;
	int pointsAccumulated;
	
	public Statistics(int gamesPlayed, int gamesWon, int pointsAccumulated) {
		
		this.gamesPlayed = gamesPlayed;
		this.gamesWon = gamesWon;
		this.pointsAccumulated = pointsAccumulated;
		
	}
	// ------------------------------------------ //
	public void setGamesPlayed(int gamesPlayed) {
		
		this.gamesPlayed = gamesPlayed;
		
	}
	
	public void addGamesPlayed(int amountToAdd) {
		
		this.gamesPlayed += amountToAdd;
		
	}
	
	public void removeGamesPlayed(int amountToRemove) {
		
		if (this.gamesPlayed - amountToRemove >= 0) {
			this.gamesPlayed -= amountToRemove;
		}
		else {
			this.gamesPlayed = 0;
		}
		
	}
	
	public int getGamesPlayed() {
		
		return this.gamesPlayed;
		
	}
	// ------------------------------------------ //
	public void setGamesWon(int gamesWon) {
		
		this.gamesWon = gamesWon;
		
	}
	
	public void addGamesWon(int amountToAdd) {
		
		this.gamesWon += amountToAdd;
		
	}
	
	public void removeGamesWon(int amountToRemove) {
		
		if (this.gamesWon - amountToRemove >= 0) {
			this.gamesWon -= amountToRemove;
		}
		else {
			this.gamesWon = 0;
		}
		
	}
	
	public int getGamesWon() {
		
		return this.gamesWon;
		
	}
	// ------------------------------------------ //
	public void setPointsAccumulated(int pointsAccumulated) {
		
		this.pointsAccumulated = pointsAccumulated;
		
	}
	
	public void addPointsAccumulated(int amountToAdd) {
		
		this.pointsAccumulated += amountToAdd;
		
	}
	
	public void removePointsAccumulated(int amountToRemove) {
		
		if (this.pointsAccumulated - amountToRemove >= 0) {
			this.pointsAccumulated -= amountToRemove;
		}
		else {
			this.pointsAccumulated = 0;
		}
		
	}
	
	public int getPointsAccumulated() {
		
		return this.pointsAccumulated;
		
	}
	// ------------------------------------------ //
	
}
