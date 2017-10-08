package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import Protocol.ApplicationProtocol;

public class ServerTest {
	//Port number is 7001
	private final static int PORT = 7001;
	
	public static void main(String[] args) {
		
		try {
			//Create a server socket with port number
			ServerSocket sskt = new ServerSocket(PORT);
			//Accept an incoming connection from a client
			Socket clientSkt = sskt.accept();
			//Open a reader on client's stream
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSkt.getInputStream()));
			//Open a writer on client's stream
			PrintWriter outToClient = new PrintWriter(clientSkt.getOutputStream(), true);
			
			String inputLine;
			String outputLine;
			
			//Create a protocol so that the client and server can communicate
			ApplicationProtocol ap = new ApplicationProtocol();
			//Process input
			outputLine = ap.processInput(null);
			//Print the processed input that application protocol handled to the client
			outToClient.println(outputLine);
			
			//While still reading input from client
			while((inputLine = inFromClient.readLine()) != null) {
				//set a string outputLine to get the processed input application protocol handles
				outputLine = ap.processInput(inputLine);
				//Print that outputLine to the client
				outToClient.println(outputLine);
				//If that outputLine equals "!quit", then break reading from client
				if(outputLine.equals("!quit")) break;
			}
		} catch (IOException ioe) {
			System.err.println("Error IO");
		}
		
	}
}
