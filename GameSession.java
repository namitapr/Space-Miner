import java.util.ArrayList;
import java.util.List;

public class GameSession {
	
	private String name = "";
	private int numPlayers = 0;
	private Users[] players= new Users[4];
	private int id ;
	private int level;
	
	public GameSession(String name, int numPlayers, int id) {
		this.setName(name);
		this.setNumPlayers(numPlayers);
		this.setId(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumPlayers() {
		return numPlayers;
	}

	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}

	public Users[] getPlayers() {
		return players;
	}
	
	public void addPlayer(Users user) {
		if(numPlayers < 4) {
			players[numPlayers] = user;
		}
		numPlayers++;
	}
	
	public void removeUser(Users user) {
		if(numPlayers > 0) {
			for(int i =0; i < 4; i++) {
				if(players[i] == user) {
					players[i] = null;
					break;
				}
			}
			numPlayers--;
		}
	}

	public void setPlayers(Users[] players) {
		this.players = players;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
}
