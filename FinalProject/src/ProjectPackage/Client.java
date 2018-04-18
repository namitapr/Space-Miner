import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends Applet implements Runnable, KeyListener{
	private static Socket socket;
	private static DataInputStream in;
	private static DataOutputStream out;
	int playerid;
	int[] x= new int[10];
	int[] y = new int[10];
	boolean left, right, up, down;
	int playerx;//local coordinates
	int playery;
	public void init() {
		setSize(600,400);
		addKeyListener(this);
		try{
			System.out.println("Connecting...");
			socket = new Socket("localhost", 7777);
			System.out.println("Connection Successful!");
			in = new DataInputStream(socket.getInputStream());
			playerid = in.readInt();
			out = new DataOutputStream(socket.getOutputStream());
			Input input = new Input(in, this);
			Thread thread = new Thread(input);
			thread.start();
			Thread thread2 = new Thread(this);
			thread2.start();
		}catch(Exception e){
			System.out.println("Unable to start client.");
		}
		
	}
	public void updateCoordinates(int pid, int x2, int y2){
		this.x[pid] = x2;
		this.y[pid] = y2;
	}

	public void paint(Graphics g){
		for(int i =0; i< 10; i++){
			g.drawOval(x[i], y[i], 15, 15);
		}
	}
	public void run(){
		while(true){
			if(right == true){
				playerx += 10;
			}
			if(left == true){
				playerx -= 10;
			}
			if(up == true){
				playery -= 10;
			}
			if(down == true){
				playery += 10;
			}
			if(left||right||up||down){
				try{
					out.writeInt(playerid);
					out.writeInt(playerx);
					out.writeInt(playery);
				}catch(Exception e){
					System.out.println("Error Sending Coordinates");
				}
			}
			repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 65){ //A
			left = true;
		}
		if(e.getKeyCode() == 87){ //W
			up = true;
		}
		if(e.getKeyCode() == 68){ //D
			right = true;
		}
		if(e.getKeyCode() == 83){ //S
			down = true;
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == 65){
			left = false;
		}
		if(e.getKeyCode() == 87){
			up = false;
		}
		if(e.getKeyCode() == 68){
			right = false;
		}
		if(e.getKeyCode() == 83){
			down = false;
		}
		
	}
	public void keyTyped(KeyEvent e) {
		
	}

}

class Input implements Runnable{
	DataInputStream in;
	Client client;
	public Input(DataInputStream in, Client c){
		this.in = in;
		this.client = c;

	}
	public void run() {
		while(true) {
			try{
				int playerid = in.readInt();
				int x = in.readInt();
				int y = in.readInt();
				client.updateCoordinates(playerid, x ,y);
			}catch(IOException e){
				this.in = null;
			}
		}
	}
}
