package com.example.loverussianlanguage;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView btnBlue;
    private ImageView btnGreen;
    private Character character;
    private Button btnBackSettings;
    private int gradient = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        btnBlue = findViewById(R.id.btnBlue);
        btnBlue.setOnClickListener(this);
        btnGreen = findViewById(R.id.btnGreen);
        btnGreen.setOnClickListener(this);
        btnBackSettings = findViewById(R.id.btnBackSettings);
        btnBackSettings.setOnClickListener(this);
        character = new Character(this);
        gradient = character.getGradient();
        chooseGradient(gradient);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnBlue:
                character.setGradient(2);
                toMenu();
                break;
            case R.id.btnGreen:
                character.setGradient(1);
                toMenu();
                break;
            case R.id.btnBackSettings:
                toMenu();
                break;
        }
    }
    private void toMenu(){
        Intent intent = new Intent(SettingActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    private void chooseGradient(int gradient){
        if(gradient == 2){
            ConstraintLayout f = findViewById(R.id.ConstraitLayout1);
            f.setBackgroundColor(ContextCompat.getColor(this, R.color.mainBlue));
         }
    }
}
