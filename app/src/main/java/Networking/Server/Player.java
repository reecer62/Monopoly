package Networking.Server;

import java.io.*;
import java.net.Socket;

import Networking.Clients.HostClient;
import Networking.Clients.PlayerClient;
import Networking.Packets.InitiateLobbyPacket;
import Networking.Packets.JoinLobbyPacket;
import Networking.Packets.LobbyPacket;

/**
 * Created by honey on 11/9/2017.
 */

public class Player implements Runnable {
    Socket client;
    Game game;
    String username;

    public DataOutputStream output;
    public DataInputStream input;

    public Player(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            input = new DataInputStream(new BufferedInputStream(client.getInputStream()));
            output = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));

            while (!client.isClosed()) {
                int val = input.readByte();
                if (val == -1) break;
                else switch (val) {
                    case 0:
                        JoinLobbyPacket joinLobby = new JoinLobbyPacket(input);
                        synchronized (RunServer.lobbies) {
                            game = RunServer.lobbies.get(joinLobby.lobbyName);
                            if (game == null){
                                new LobbyPacket(false).write(output);
                                client.close();
                            } else {
                                new LobbyPacket(true).write(output);
                                game.addPlayer(this);
                            }
                        }
                        break;
                    case 1:
                        InitiateLobbyPacket initLobby = new InitiateLobbyPacket(input);
                        synchronized (RunServer.lobbies) {
                            if (RunServer.lobbies.containsKey(initLobby.lobbyName)) {
                                new LobbyPacket(false).write(output);
                                client.close();
                            } else {
                                new LobbyPacket(true).write(output);
                                game = new Game(initLobby.lobbyName, this);
                                RunServer.lobbies.put(initLobby.lobbyName, game);
                                synchronized (RunServer.games){
                                    RunServer.games.add(game);
                                }
                            }
                        }
                        break;
                }
            }
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
