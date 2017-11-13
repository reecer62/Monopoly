package Networking.Packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by honey on 11/9/2017.
 */

public class LobbyPacket extends Packet {
    public boolean successful;

    public LobbyPacket(boolean successful) {
        this.successful = successful;
    }

    public LobbyPacket (DataInputStream in) {
        super(in);
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        successful = in.readByte() != 0;
    }

    @Override
    public void write(DataOutputStream out) throws IOException {
        out.writeByte(2);
        out.writeByte(successful ? 1 : 0);
    }
}
