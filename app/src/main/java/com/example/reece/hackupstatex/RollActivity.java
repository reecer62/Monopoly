package com.example.reece.hackupstatex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static com.example.reece.hackupstatex.R.id.buttonBack;

public class RollActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll);

        ImageView imageViewDie = (ImageView) findViewById(R.id.imageViewDie);
        TextView textViewDie = (TextView) findViewById(R.id.textViewDie);
        //int rollResult = (int) Math.random() * 6 + 1;
        int rollResult = 3;
        switch(rollResult) {
            case 1: {
                imageViewDie.setImageResource(R.drawable.d1);
                textViewDie.setText(Integer.toString(rollResult));
                break;
            }
            case 2: {
                imageViewDie.setImageResource(R.drawable.d2);
                textViewDie.setText(Integer.toString(rollResult));
                break;
            }
            case 3: {
                imageViewDie.setImageResource(R.drawable.d3);
                textViewDie.setText(Integer.toString(rollResult));
                break;
            }
            case 4: {
                imageViewDie.setImageResource(R.drawable.d4);
                textViewDie.setText(Integer.toString(rollResult));
                break;
            }
            case 5: {
                imageViewDie.setImageResource(R.drawable.d5);
                textViewDie.setText(Integer.toString(rollResult));
                break;
            }
            case 6: {
                imageViewDie.setImageResource(R.drawable.d6);
                textViewDie.setText(Integer.toString(rollResult));
                break;
            }
        }

        Button buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.buttonBack: {
                finish();
                break;
            }
        }
    }
}
