package com.example.reece.hackupstatex;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.example.reece.hackupstatex.error_dialogs.FieldIncorrectDialogFragment;

import Networking.Clients.*;

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
                EditText editTextHostName = (EditText) findViewById(R.id.editTextClientName);
                String hostName = editTextHostName.getText().toString();
                EditText editTextLobbyName = (EditText) findViewById(R.id.editTextLobbyName);
                String lobbyName = editTextLobbyName.getText().toString();

                if (!hostName.isEmpty() && !lobbyName.isEmpty()) {
                    Intent intent = new Intent(StartNewGameActivity.this, LobbyActivity.class);

                    editTextHostName.getText().clear();
                    editTextLobbyName.getText().clear();

                    Bundle bundle = new Bundle();
                    bundle.putString("type", "host");
                    bundle.putString("hostName", hostName);
                    bundle.putString("lobbyName", lobbyName);
                    intent.putExtras(bundle);
                    Client.mainClient = new HostClient(lobbyName, hostName);
                    if (Client.mainClient.start()) startActivity(intent);
                    else {
                        //TODO: error message saying that the lobby could not be created
                    }
                    break;
                } else {
                    DialogFragment incorrectHostLobbyNum = new FieldIncorrectDialogFragment();
                    incorrectHostLobbyNum.show(getFragmentManager(), "HostLobbyNum");
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
