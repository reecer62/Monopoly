package Networking.Packets;

import android.os.Bundle;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by honey on 11/5/2017.
 */

public abstract class Packet {
    public void getPacketID() {

    }

    public Packet(){}

    public Packet(DataInputStream in){
        try {
            read(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void read(DataInputStream in) throws IOException;

    /**
     * First writes a single byte with a value -1, 0, or 1.
     *  <ol start="-1">
     * 		<li>Tells the server to close the game (maybe?)</li>
     * 		<li>Tells the server that the client is not the host.</li>
     * 		<li>Tells the server that the client is the host.</li>
     * </ol>
     * @param out
     * @throws IOException
     */
    public abstract void write(DataOutputStream out) throws IOException;
}
