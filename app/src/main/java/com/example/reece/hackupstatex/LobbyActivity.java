package com.example.reece.hackupstatex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import Networking.Clients.Client;

public class LobbyActivity extends AppCompatActivity implements View.OnClickListener {
    //TODO: update the list of players whenever a new player joins

    Bundle bundle = new Bundle();
    String hostName;
    String lobbyName;
    String clientName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        Button buttonRunGame = (Button) findViewById(R.id.buttonRunGame);
        buttonRunGame.setOnClickListener(this);
        Button buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(this);

        TextView textViewLobbyName = (TextView) findViewById(R.id.textViewLobbyName);
        TextView textViewHostName = (TextView) findViewById(R.id.textViewHostName);

        bundle = getIntent().getExtras();
        if (bundle.getString("type") == "host") {
            hostName = bundle.getString("hostName");
            lobbyName = bundle.getString("lobbyName");
        } else if (bundle.getString("type") == "player") {
            clientName = bundle.getString("clientName");
            lobbyName = bundle.getString("lobbyName");
            buttonRunGame.setVisibility(View.INVISIBLE);
        }

        textViewHostName.setText("HostClient name is " + hostName);
        textViewLobbyName.setText("Lobby name is " + lobbyName);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.buttonRunGame: {
                startActivity(new Intent(LobbyActivity.this, MainGameActivity.class));
                break;
            }

            case R.id.buttonBack: {
                finish();
                break;
            }
        }
    }
}
