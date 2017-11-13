package Networking.Clients;

import java.net.Inet4Address;
import java.util.ArrayList;

/**
 * Created by honey on 11/9/2017.
 */

public abstract class Client {
    public static final int PORT = 7539;
    public static final String HOST = "128.153.198.162";
    public static Client mainClient;

    public ArrayList<String> players = new ArrayList<String>();

    String lobbyName;
    String username;

    public Client(String lobbyName, String username) {
        this.lobbyName = lobbyName;
        this.username = username;
    }

    public abstract boolean start();
}
