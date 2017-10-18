package modig;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main2 {

	public static void main(String[] args) {
		System.out.println("Server");
		try(ServerSocket serverSocket = new ServerSocket(5555)){		
			while(true) {
				Socket socket = serverSocket.accept();
				Echoer echoer = new Echoer(socket);
				echoer.start();
				
				
			//	socket.
				
				System.out.println(socket.getInetAddress());
				echoer.getEchoString();
			}
					
		} catch (IOException e) {
			System.out.println("Server exception " + e.getMessage());
		}
		

	}

}
