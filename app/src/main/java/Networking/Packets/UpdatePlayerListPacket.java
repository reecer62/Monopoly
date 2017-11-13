package Networking.Packets;

import android.widget.ArrayAdapter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by honey on 11/9/2017.
 */

public class UpdatePlayerListPacket extends Packet {
    public ArrayList<String> players;

    public UpdatePlayerListPacket(ArrayList<String> players) {
        this.players = players;
    }

    public UpdatePlayerListPacket (DataInputStream in) {
        super(in);
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        int size = in.readInt();
        players = new ArrayList<String>(size);
        for (int i = 0; i < size; size++) players.add(in.readUTF());
    }

    @Override
    public void write(DataOutputStream out) throws IOException {
        out.writeByte(3);
        out.writeInt(players.size());
        for (String player : players) out.writeUTF(player);
    }
}
