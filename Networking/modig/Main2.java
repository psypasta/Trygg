package modig;

import java.io.IOException;
import java.net.ServerSocket;

public class Main2 {

	public static void main(String[] args) {
		System.out.println("Server");
		try(ServerSocket serverSocket = new ServerSocket(5555)){		
			while(true) {
		//		Socket socket = serverSocket.accept();
		//		Echoer echoer = new Echoer(socket);
		//		echoer.start();
				new Echoer(serverSocket.accept()).start();
			}
					
		} catch (IOException e) {
			System.out.println("Server exception " + e.getMessage());
		}
		

	}

}
