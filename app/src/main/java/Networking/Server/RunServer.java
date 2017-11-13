package Networking.Server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;

import Networking.Clients.*;

/**
 * Created by honey on 11/9/2017.
 */

public class RunServer {
    public static ArrayList<Game> games = new ArrayList<Game>();
    public static HashMap<String, Game> lobbies = new HashMap<String, Game>();

    public static void main(String args[]) throws IOException {
        ServerSocket server = new ServerSocket(7539);
        while (!server.isClosed()) {
            final Socket clientSocket = server.accept();
            new Thread(new Player(clientSocket)).start();
        }
    }
}