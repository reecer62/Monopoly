package com.example.reece.hackupstatex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainGameActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        Button buttonRoll = (Button) findViewById(R.id.buttonRoll);
        buttonRoll.setOnClickListener(this);
    }

    @Override
    public void onClick (View v) {
        switch (v.getId()) {
            case R.id.buttonRoll: {
                startActivity(new Intent(MainGameActivity.this, RollActivity.class));
                break;
            }
        }
    }
}
