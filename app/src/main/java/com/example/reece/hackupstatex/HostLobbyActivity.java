package com.example.reece.hackupstatex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HostLobbyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String username;
        String lobbyName;
        int numPlayers;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_lobby);


        Bundle bundle = getIntent().getExtras();
        if (!bundle.isEmpty()) {
            if (bundle.containsKey("username") && bundle.containsKey("numPlayers") && bundle.containsKey("lobbyName")) {
                username = bundle.getString("username");
                lobbyName = bundle.getString("lobbyName");
                numPlayers = bundle.getInt("numPlayers");
            } else {
                //TODO: make an alert dialogue box pop up saying that this can't be done
                username = "Default Username Inner";
                lobbyName = "Default Lobby Name Inner";
                numPlayers = 1;
            }
        } else {
            //TODO: make an alert dialogue box pop up saying that this can't be done
            username = "Default Username Outer";
            lobbyName = "Default Lobby Name Outer";
            numPlayers = 1;
        }

        TextView textViewUsername = (TextView) findViewById(R.id.textViewUsername);
        TextView textViewLobbyName = (TextView) findViewById(R.id.textViewLobbyName);
        TextView textViewNumPlayers = (TextView) findViewById(R.id.textViewNumPlayers);

        textViewUsername.setText("Username is " + username);
        textViewLobbyName.setText("Lobby name is " + lobbyName);
        textViewNumPlayers.setText("Number of players is " + numPlayers);
    }
}
