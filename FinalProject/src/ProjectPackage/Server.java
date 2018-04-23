package ProjectPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server {
	private static ServerSocket serverSocket;
	private static Socket socket;
	private static DataOutputStream out;
	private static DataInputStream in;
	private static Users[] user= new Users[10];
	
	
	public static void main(String[] args) throws IOException {
		System.out.println("Starting the server...");
		serverSocket = new ServerSocket(7777);
		System.out.println("Server started...");
		while(true) {
			socket = serverSocket.accept();
			for(int i =0; i < 10; i++) {
				System.out.println("Connection from"+ socket.getInetAddress());
				out = new DataOutputStream(socket.getOutputStream());
				in = new DataInputStream(socket.getInputStream());
				if(user[i] == null) {
					user[i] = new Users(out, in, user,i);
					Thread th = new Thread(user[i]);
					th.start();
					break;
				}
			}

		}
	}
}

/*A class that holds a map of the string game code and an object containing all data about the game 
 * */
//Holds games! This is the main container 
public class Games {
	private static Map<String, Game> games = new HashMap<String, Game>();
	
	public Game getGame(String gameCode) {
		return games.get(gameCode);
	}
	public void broadcastMessage(String gameCode, String message) {
		// TODO 
	}
}
//Holds all the data about a game
class Game {
	//List of Clients associated with this game
	private List<Client> players = new ArrayList<Client>();
	
	public List<Client> getPlayers(){
		return this.players;
	}
	public void broadcastMessage(String message) {
		// TODO
	}
}

class Users implements Runnable{
	DataOutputStream out;
	DataInputStream in;
	Users[] user = new Users[10];
	String name;
	int playerid;
	int playeridin;
	int xin;
	int yin;
	public Users(DataOutputStream out, DataInputStream in, Users[] user, int pid) {
		this.out = out;
		this.in = in;
		this.user = user;
		this.playerid = pid;
	}
	public void run() {
		try{
			out.writeInt(playerid);
		}catch(IOException e){
			System.out.println("Failed to send PlayerID.");
		}
		while(true) {
			try {
				playeridin = in.readInt();
				xin = in.readInt();
				yin = in.readInt();
				for(int i = 0; i < 10; i++) {
					if(user[i] != null ) {
						user[i].out.writeInt(playeridin);
						user[i].out.writeInt(xin);
						user[i].out.writeInt(yin);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				user[playerid] = null;
				break;
			}
		}
	}
}
