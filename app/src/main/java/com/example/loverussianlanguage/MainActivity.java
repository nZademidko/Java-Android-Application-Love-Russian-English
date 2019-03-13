package com.example.loverussianlanguage;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnStartGame;
    private Button btnSettings;
    private Button btnHelp;
    private Button btnExit;
    private int gradient = 1;
    private Character character;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStartGame = findViewById(R.id.btnStartGame);
        btnStartGame.setOnClickListener(this);
        btnSettings = findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(this);
        btnHelp = findViewById(R.id.btnHelp);
        btnHelp.setOnClickListener(this);
        btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener(this);
        character = new Character(this);
        gradient = character.getGradient();
        chooseGradient(gradient);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnStartGame:
                onClickStartGame();
                break;
            case R.id.btnSettings:
                onClickSettings();
                break;
            case R.id.btnHelp:
                onClickHelp();
                break;
            case R.id.btnExit:
                onClickExit();
                break;
        }
    }

    private void onClickStartGame(){
        Intent intent = new Intent(MainActivity.this, LobbyActivity.class);
        startActivity(intent);
    }

    private void onClickSettings(){
        Intent intent = new Intent(MainActivity.this, SettingActivity.class);
        startActivity(intent);
    }
    private void onClickHelp() {
        Intent intent = new Intent(MainActivity.this, HelpActivity.class);
        startActivity(intent);
    }

    private void onClickExit(){
        System.exit(0);
    }

    private void chooseGradient(int gradient){
        if(gradient == 2){
            ConstraintLayout f = findViewById(R.id.constraintLayout);
            f.setBackgroundColor(ContextCompat.getColor(this, R.color.mainBlue));
            btnStartGame.setBackgroundResource(R.drawable.style_blue_button);
            btnHelp.setBackgroundResource(R.drawable.style_blue_button);
            btnSettings.setBackgroundResource(R.drawable.style_blue_button);
        }
    }
}
