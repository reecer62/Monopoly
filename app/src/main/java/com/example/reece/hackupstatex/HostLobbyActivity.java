package com.example.reece.hackupstatex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HostLobbyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String username;
        int numPlayers;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_lobby);


        Bundle bundle = getIntent().getExtras();
        if (!bundle.isEmpty()) {
            if (bundle.containsKey("username") && bundle.containsKey("numPlayers")) {
                username = bundle.getString("username");
                numPlayers = bundle.getInt("numPlayers");
            } else {
                //TODO: make an alert dialogue box pop up saying that this can't be done
                username = "Default Username Inner";
                numPlayers = 1;
            }
        } else {
            //TODO: make an alert dialogue box pop up saying that this can't be done
            username = "Default Username Outer";
            numPlayers = 1;
        }

        TextView textViewUsername = (TextView) findViewById(R.id.textViewUsername);
        TextView textViewNumPlayers = (TextView) findViewById(R.id.textViewNumPlayers);

        textViewUsername.setText("Username is " + username);
        textViewNumPlayers.setText("Number of players is " + numPlayers);
    }
}
