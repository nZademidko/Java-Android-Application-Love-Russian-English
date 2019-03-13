package com.example.loverussianlanguage;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LobbyActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnFirstQuest;
    private Button btnSecondQuest;
    private Button btnThirdQuest;
    private TextView textViewName;
    private Character character;
    private int gradient = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);
        btnFirstQuest = findViewById(R.id.btnFirstQuest);
        btnFirstQuest.setOnClickListener(this);
        btnSecondQuest = findViewById(R.id.btnSecondQuest);
        btnSecondQuest.setOnClickListener(this);
        btnThirdQuest = findViewById(R.id.btnThirdQuest);
        btnThirdQuest.setOnClickListener(this);
        textViewName = findViewById(R.id.TextViewName);
        character = new Character(this);
        textViewName.setText("Отлично, \n" + character.getName());
        gradient = character.getGradient();
        chooseGradient(gradient);
    }
    private void chooseGradient(int gradient){
        if(gradient == 2){
            btnFirstQuest.setTextColor(ContextCompat.getColor(this, R.color.mainBlue));
            btnSecondQuest.setTextColor(ContextCompat.getColor(this, R.color.mainBlue));
            btnThirdQuest.setTextColor(ContextCompat.getColor(this, R.color.mainBlue));
            ConstraintLayout l = findViewById(R.id.ConstraintLayout2);
            l.setBackgroundColor(ContextCompat.getColor(this, R.color.mainBlue));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnFirstQuest:
                startGame(1);
                break;
            case R.id.btnSecondQuest:
                startGame(2);
                break;
            case R.id.btnThirdQuest:
                startGame(3);
                break;
        }
    }

    private void startGame(int type){
        WordsDataBase wordsDataBase = new WordsDataBase(type,this);
        Intent intent = new Intent(LobbyActivity.this, GameActivity.class);
        intent.putExtra("Words", wordsDataBase.getWords());
        intent.putExtra("Letters",wordsDataBase.getNumbers());
        intent.putExtra("Type", type);
        startActivity(intent);
        finish();
    }

}
