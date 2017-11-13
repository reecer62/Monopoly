package Networking.Server;

import java.io.IOException;
import java.util.ArrayList;

import Networking.Packets.UpdatePlayerListPacket;

/**
 * Created by honey on 11/9/2017.
 */

public class Game {
    String lobbyName;
    Player host;
    ArrayList<Player> players = new ArrayList<Player>();

    public Game(String lobbyName, Player host) {
        this.lobbyName = lobbyName;
        this.host = host;

        players.add(host);
    }

    public void addPlayer(Player player) {
        players.add(player);
        ArrayList<String> usernames = new ArrayList<String>(players.size());
        for(Player p : players) usernames.add(p.username);
        UpdatePlayerListPacket packet = new UpdatePlayerListPacket(usernames);
        for(Player p : players) {
            try {
                packet.write(p.output);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
