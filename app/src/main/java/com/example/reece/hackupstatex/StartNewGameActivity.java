package com.example.reece.hackupstatex;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class StartNewGameActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_new_game);

        Button buttonNext = (Button) findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(this);
        Button buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.buttonNext: {
                Intent intent = new Intent(StartNewGameActivity.this, HostLobbyActivity.class);
                EditText editTextUsername = (EditText) findViewById(R.id.editTextUsername);
                String username = editTextUsername.getText().toString();
                EditText editTextLobbyName = (EditText) findViewById(R.id.editTextLobbyName);
                String lobbyName = editTextLobbyName.getText().toString();
                EditText editTextNumPlayers = (EditText) findViewById(R.id.editTextNumPlayers);
                int numPlayers;
                try {
                    numPlayers = Integer.parseInt(editTextNumPlayers.getText().toString());
                } catch (NumberFormatException nfe){
                    //TODO: make an alert dialogue box pop up saying that this can't be done
                    numPlayers = 1;
                }
                editTextUsername.getText().clear();
                editTextLobbyName.getText().clear();
                editTextNumPlayers.getText().clear();
                Bundle bundle = new Bundle();
                bundle.putString("username", username);
                bundle.putString("lobbyName", lobbyName);
                bundle.putInt("numPlayers", numPlayers);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            }

            case R.id.buttonBack: {
                finish();
                break;
            }
        }
    }
}
