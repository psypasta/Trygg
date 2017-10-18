package modig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends Thread{

	private Socket socket;
	private String echoString;
	
	public Echoer(Socket socket) {
		this.socket = socket;
	}
	
	public String getEchoString() {
		return this.echoString;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader input = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
			
			while(true) {
				
				echoString = input.readLine();
				System.out.println(echoString);
				
				if(echoString.equals("exit")) {
					break;
				}
				
				try {
					Thread.sleep(15000);
				} catch(InterruptedException e) {
					System.out.println("Thread interupted");
				}
				output.println(echoString);
			}
		} catch(IOException e) {
			System.out.println("Oops: " + e.getMessage());
		} finally {
			try {
				socket.close();
			} catch(IOException e) {
				// wot
			}
		}
	}
}
