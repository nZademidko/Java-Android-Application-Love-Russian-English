package com.example.loverussianlanguage;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;

public class HelpActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnBack;
    private Character character;
    private int gradient = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
        character = new Character(this);
        gradient = character.getGradient();
        chooseGradient(gradient);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnBack:
                backToLobby();
                break;
        }
    }

    private void backToLobby() {
        Intent intent = new Intent(HelpActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void chooseGradient(int i) {
        if (i == 2) {
            ConstraintLayout l = findViewById(R.id.HelpLayout);
            l.setBackgroundColor(ContextCompat.getColor(this,R.color.mainBlue));
            btnBack.setTextColor(ContextCompat.getColor(this,R.color.mainBlue));
        }
    }
}
