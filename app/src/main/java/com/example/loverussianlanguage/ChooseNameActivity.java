package com.example.loverussianlanguage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChooseNameActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnStartToLobby;
    private EditText editTextName;
    private Character start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_name);
        start = new Character(this);
        if(start.getCheck()){
            nextToLobby();
            return;
        }
        btnStartToLobby = findViewById(R.id.btnStartToLobby);
        btnStartToLobby.setOnClickListener(this);
        editTextName = findViewById(R.id.editTextName);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStartToLobby:
                onClickStartButton(editTextName.getText().toString());
                break;
        }
    }

    private void onClickStartButton(final String name) {
        if (name.length() == 0) {
            Toast.makeText(this, "Введите ваше имя!", Toast.LENGTH_SHORT).show();
            return;
        }

        start.setName(name);
        start.setCheck(true);
        nextToLobby();
    }

    private void nextToLobby() {
        Intent intent = new Intent(ChooseNameActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
