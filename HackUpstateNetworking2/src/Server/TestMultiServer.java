package Server;

import java.io.IOException;
import java.net.ServerSocket;

public class TestMultiServer {
	//Port number is 7001
	private final static int PORT = 7001;
	
	public static void main(String[] args) {
		//Declare a boolean assigned true
		boolean listening = true;
		try {
			//Create server socket with port number
			ServerSocket sskt = new ServerSocket(PORT);
			//Keep listening for connection requests
			while(listening) {
				//When a request comes in, creates new MultiServerThread object to process it, hands it the socket returned from accept(), and starts the thread
				new MultiServerThread(sskt.accept()).start();
			}
		} catch (IOException ioe) {
			System.err.println("Could not listen on port number " + PORT);
		}
	}
}
