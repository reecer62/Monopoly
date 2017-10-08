package com.example.reece.hackupstatex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.reece.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        configureNextButton();
    }

    public void configureNextButton(){
        Button nextButton = (Button) findViewById(R.id.buttonStart);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenuActivity.this, StartNewGameActivity.class));
            }
        });
    }
}
