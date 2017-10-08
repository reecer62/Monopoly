package com.example.reece.hackupstatex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainMenuActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.reece.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, StartNewGameActivity.class);
        EditText editText = (EditText) findViewById(R.id.editTextTitle);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
