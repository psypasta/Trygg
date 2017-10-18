package modig;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	private static String ipcon = null;;

	public static void main(String[] args) {

		//System.out.println("Server ip: ");
		//Scanner scan = new Scanner(System.in);
		//ipcon = scan.nextLine();
		
		try(Socket socket = new Socket("localhost", 5555)){
			
			BufferedReader echoes = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);
			
			Scanner scanner = new Scanner(System.in);
			String echoString;
			String response;
			
			do {
				System.out.println("Enter string to be echoed");
				echoString = scanner.nextLine();
				
				stringToEcho.println(echoString);
				if(!echoString.equals("exit")) {
					response = echoes.readLine();
					System.out.println(response);
				}
			} while(!echoString.equals("exit"));
			
		}catch(IOException e){
			System.out.println("Client error: " + e.getMessage());
		}

	}

}
