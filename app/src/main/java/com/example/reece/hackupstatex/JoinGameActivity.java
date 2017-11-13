package com.example.reece.hackupstatex;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.reece.hackupstatex.error_dialogs.FieldIncorrectDialogFragment;

import Networking.Clients.Client;
import Networking.Clients.PlayerClient;

public class JoinGameActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_game);

        Button buttonNext = (Button) findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(this);
        Button buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.buttonNext: {
                EditText editTextClientName = (EditText) findViewById(R.id.editTextClientName);
                String clientName = editTextClientName.getText().toString();
                EditText editTextLobbyName = (EditText) findViewById(R.id.editTextLobbyName);
                String lobbyName = editTextLobbyName.getText().toString();

                if (!clientName.isEmpty() && !lobbyName.isEmpty()) {
                    Intent intent = new Intent(JoinGameActivity.this, LobbyActivity.class);
                    editTextClientName.getText().clear();
                    editTextLobbyName.getText().clear();
                    Bundle bundle = new Bundle();
                    bundle.putString("type", "player");
                    bundle.putString("clientName", clientName);
                    bundle.putString("lobbyName", lobbyName);
                    intent.putExtras(bundle);
                    Client.mainClient = new PlayerClient(lobbyName, clientName);
                    if (Client.mainClient.start()) startActivity(intent);
                    else {
                        //TODO: error message saying that the lobby did not exist
                    }
                    break;
                } else {
                    DialogFragment incorrectClientLobby = new FieldIncorrectDialogFragment();
                    incorrectClientLobby.show(getFragmentManager(), "HostLobbyNum");
                    break;
                }
            }

            case R.id.buttonBack: {
                finish();
                break;
            }
        }
    }

}
