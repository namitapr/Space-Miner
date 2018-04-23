package ProjectPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*A class that holds a map of the string game code and an object containing all data about the game 
 * Holds games! This is the main container
 * */ 
public class Game {
	//Mapping of Game Code to a Session of a game
	private static Map<String, Session> games = new HashMap<String, Session>();
	
	//function to start a new game
	public void newGame(String gameCode, Player p) {
		
	}
	//function to add a player to a game
	public void addPlayer(String gameCode, Player p) {
		
	}
	public Session getGame(String gameCode) {
		return games.get(gameCode);
	}
	public void broadcastMessage(String gameCode, String message) {
		// TODO 
	}
}
//Holds all the data about a game
//Is a session of a game
class Session {
	//List of Clients associated with this game
	private List<Client> players = new ArrayList<Client>();
	
	public List<Client> getPlayers(){
		return this.players;
	}
	public void broadcastMessage(String message) {
		// TODO
	}
}

