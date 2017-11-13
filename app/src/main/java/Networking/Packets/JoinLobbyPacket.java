package Networking.Packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by honey on 11/9/2017.
 */

public class JoinLobbyPacket extends Packet {
    public String username;
    public String lobbyName;

    public JoinLobbyPacket(String username, String lobbyName) {
        this.username = username;
        this.lobbyName = lobbyName;
    }

    public JoinLobbyPacket(DataInputStream input) {
        super(input);
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        username = in.readUTF();
        lobbyName = in.readUTF();
    }

    @Override
    public void write(DataOutputStream out) throws IOException {
        out.writeByte(0);
        out.writeUTF(username);
        out.writeUTF(lobbyName);
    }
}
