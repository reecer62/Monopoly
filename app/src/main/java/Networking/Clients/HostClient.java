package Networking.Clients;

import java.io.*;
import java.net.Socket;

import Networking.Packets.*;

/**
 * Created by honey on 11/9/2017.
 */

public class HostClient extends Client implements Runnable {
    DataInputStream input;
    DataOutputStream output;
    Socket socket = null;

    public HostClient(String lobbyName, String username) { super(lobbyName, username); }

    @Override
    public boolean start() {
        try {
            socket = new Socket(HOST, PORT);
            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            output = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

            new InitiateLobbyPacket(username, lobbyName).write(output);
            if (input.readByte() == 2) {
                if (new LobbyPacket(input).successful) {
                    players.add(username);
                    new Thread(this).start();
                    socket.close();
                    return true;
                } else {
                    socket.close();
                    return false;
                }
            }
            return false;

        } catch (IOException e) {
            e.printStackTrace();
            try {
                socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public void run() {
        while(true) {
            try {
                switch (input.readByte()) {
                    case 2:
                        break;
                    case 3:
                        players = new UpdatePlayerListPacket(input).players;
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
