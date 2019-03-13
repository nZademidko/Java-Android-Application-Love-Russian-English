package com.example.loverussianlanguage;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndGameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewCorrect;
    private TextView textViewInCorrect;
    private TextView textViewTime;
    private Character character;
    private Button btnGoHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        textViewCorrect = findViewById(R.id.textViewCorrect);
        textViewInCorrect = findViewById(R.id.textViewInCorrect);
        textViewTime = findViewById(R.id.textViewTime);
        String s = "Правильных ответов: " + getIntent().getIntExtra("Correct",-1);
        textViewCorrect.setText(s);
        s = "Неправильных ответов:" + String.valueOf(getIntent().getIntExtra("InCorrect",-1));
        textViewInCorrect.setText(s);
        s = "Время игры: " + getIntent().getStringExtra("Time");
        textViewTime.setText(s);
        character = new Character(this);
        btnGoHome = findViewById(R.id.btnGoHome);
        btnGoHome.setOnClickListener(this);
        chooseGradient(character.getGradient());

    }
    private void chooseGradient(int gradient){
        if(gradient == 2){
            ConstraintLayout l = findViewById(R.id.EndLayout);
            l.setBackgroundColor(ContextCompat.getColor(this,R.color.mainBlue));
            btnGoHome.setTextColor(ContextCompat.getColor(this,R.color.mainBlue));
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnGoHome:
                Intent i = new Intent(EndGameActivity.this,MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
                break;
        }
    }
}
