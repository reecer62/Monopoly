package Networking.Clients;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import Networking.Packets.JoinLobbyPacket;
import Networking.Packets.LobbyPacket;
import Networking.Packets.UpdatePlayerListPacket;

/**
 * Created by honey on 11/9/2017.
 */

public class PlayerClient extends Client implements Runnable {
    DataInputStream input;
    DataOutputStream output;
    Socket socket = null;

    public PlayerClient(String lobbyName, String username) {
        super(lobbyName, username);
    }

    @Override
    public boolean start() {
        try {
            socket = new Socket(HOST, PORT);
            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            output = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

            new JoinLobbyPacket(username, lobbyName).write(output);
            if (input.readByte() == 2) {
                if (new LobbyPacket(input).successful) {
                    new Thread(this).start();
                    return true;
                } else {
                    socket.close();
                    return false;
                }
            }
            socket.close();
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
