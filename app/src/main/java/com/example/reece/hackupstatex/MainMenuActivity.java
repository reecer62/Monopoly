package com.example.reece.hackupstatex;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button startButton = (Button) findViewById(R.id.buttonStart);
        startButton.setOnClickListener(this);
        Button joinButton = (Button) findViewById(R.id.buttonJoin);
        joinButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonStart: {
                startActivity(new Intent(MainMenuActivity.this, StartNewGameActivity.class));
                break;
            }
            case R.id.buttonJoin: {
                startActivity(new Intent(MainMenuActivity.this, JoinGameActivity.class));
                break;
            }
        }
    }
}
