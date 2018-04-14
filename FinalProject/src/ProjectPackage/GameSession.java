package ProjectPackage;

import java.util.ArrayList;
import java.util.List;

public class GameSession {
	
	private String name = "";
	private int numPlayers = 0;
	private List<User> players = null;
	private String id = "";
	
	public GameSession(String name, int numPlayers, String id) {
		this.setName(name);
		this.setNumPlayers(numPlayers);
		this.setId(id);
		players = new ArrayList<User>();
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

	public List<User> getPlayers() {
		return players;
	}
	
	public void addPlayer(User user) {
		players.add(user);
	}
	
	public void removeUser(User user) {
		players.remove(user);
	}

	public void setPlayers(List<User> players) {
		this.players = players;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
