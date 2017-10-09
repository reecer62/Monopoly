package com.example.reece.hackupstatex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class LobbyActivity extends AppCompatActivity implements View.OnClickListener {

    Bundle bundle = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String hostName;
        String lobbyName;
        int numPlayers;
        String clientName;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);


        bundle = getIntent().getExtras();
        if (!bundle.isEmpty()) {
            if (bundle.containsKey("hostName") && bundle.containsKey("numPlayers") && bundle.containsKey("lobbyName")) {
                hostName = bundle.getString("hostName");
                lobbyName = bundle.getString("lobbyName");
                numPlayers = bundle.getInt("numPlayers");
                //These Variables will be removed once we implement retrieving data from the server
                clientName = "Default Client Name";
            } else if (bundle.containsKey("clientName") && bundle.containsKey("lobbyName")) {
                clientName = bundle.getString("clientName");
                lobbyName = bundle.getString("lobbyName");
                //These Variables will be removed once we implement retrieving data from the server
                hostName = "Default Host Name";
                numPlayers = 1;
            } else {
                //TODO: make an alert dialogue box pop up saying that this can't be done
                hostName = "Default Host Name Inner";
                lobbyName = "Default Lobby Name Inner";
                numPlayers = 1;
                clientName = "Default Client Name Inner";
            }
        } else {
            //TODO: make an alert dialogue box pop up saying that this can't be done
            hostName = "Default Host Name Outer";
            lobbyName = "Default Lobby Name Outer";
            numPlayers = 1;
            clientName = "Default Client Name Outer";
        }

        TextView textViewLobbyName = (TextView) findViewById(R.id.textViewLobbyName);
        TextView textViewHostName = (TextView) findViewById(R.id.textViewHostName);
        //TextView textViewNumPlayers = (TextView) findViewById(R.id.textViewNumPlayers);

        textViewHostName.setText("Host name is " + hostName);
        textViewLobbyName.setText("Lobby name is " + lobbyName);
        //textViewNumPlayers.setText("Number of players is " + numPlayers);

        Button buttonRunGame = (Button) findViewById(R.id.buttonRunGame);
        buttonRunGame.setOnClickListener(this);
        Button buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.buttonRunGame: {
                //Calls connectToHost, only called once per client because each connects only once

                //Get host name from user
                String host_Name = bundle.getString("hostName");
                //Port number that is going to be used
                int port = 7001;
                try {
                    //Open a socket
                    Socket skt = new Socket(host_Name, port);
                    //Open an output stream to the socket
                    PrintWriter outToServer = new PrintWriter(skt.getOutputStream(), true); //Sets autoFlush() to true so you don't have to flush the output stream every time you print to server
                    //Open an input stream from the socket
                    BufferedReader inFromServer = new BufferedReader(new InputStreamReader(skt.getInputStream()));
                } catch (UnknownHostException uhe) {
                    //Can't find host
                    System.err.println("Don't know the h*ckin host " + host_Name);
                    System.exit(1);
                } catch (IOException ioe) {
                    //IO error
                    System.err.println("I/O error in connecting to " + host_Name);
                    System.exit(1);
                }
                break;
            }

            case R.id.buttonBack: {
                finish();
                break;
            }
        }
    }
}
