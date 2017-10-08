package com.example.reece.hackupstatex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HostLobbyActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String hostName;
        String lobbyName;
        int numPlayers;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_lobby);


        Bundle bundle = getIntent().getExtras();
        if (!bundle.isEmpty()) {
            if (bundle.containsKey("hostName") && bundle.containsKey("numPlayers") && bundle.containsKey("lobbyName")) {
                hostName = bundle.getString("hostName");
                lobbyName = bundle.getString("lobbyName");
                numPlayers = bundle.getInt("numPlayers");
            } else {
                //TODO: make an alert dialogue box pop up saying that this can't be done
                hostName = "Default Host Name Inner";
                lobbyName = "Default Lobby Name Inner";
                numPlayers = 1;
            }
        } else {
            //TODO: make an alert dialogue box pop up saying that this can't be done
            hostName = "Default Host Name Outer";
            lobbyName = "Default Lobby Name Outer";
            numPlayers = 1;
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
                //here
                break;
            }

            case R.id.buttonBack: {
                finish();
                break;
            }
        }
    }
}
