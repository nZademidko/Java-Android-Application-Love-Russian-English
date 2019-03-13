package com.example.loverussianlanguage;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private Character character;
    private Button btnFisrtChoice;
    private Button btnSecondChoice;
    private TextView DisplayedWord;
    private String[] words;
    private String[] letters;
    private int correct = 0;
    private int incorrect = 0;
    private int type;
    private Game game;
    private char firstChar;
    private char secondChar;
    private final static Object lock = new Object();
    private final static Object timer = new Object();
    private int time = 0;
    private Timer timer1;
    private char choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        character = new Character(this);
        btnFisrtChoice = findViewById(R.id.btnFirstChoice);
        btnFisrtChoice.setOnClickListener(this);
        btnSecondChoice = findViewById(R.id.btnSecondChoice);
        btnSecondChoice.setOnClickListener(this);
        words = getIntent().getStringArrayExtra("Words");
        letters = getIntent().getStringArrayExtra("Letters");
        type = getIntent().getIntExtra("Type", 1);
        DisplayedWord = findViewById(R.id.DisplayedWord);
        fillLetters(type);
        chooseGradient(character.getGradient());
        isStart();
        timer1 = new Timer();
        timer1.start();
    }

    private void chooseGradient(int gradient) {
        if (gradient == 2) {
            btnFisrtChoice.setTextColor(ContextCompat.getColor(this, R.color.mainBlue));
            btnSecondChoice.setTextColor(ContextCompat.getColor(this, R.color.mainBlue));
            ConstraintLayout l = findViewById(R.id.GameLayout);
            l.setBackgroundColor(ContextCompat.getColor(this, R.color.mainBlue));
        }
    }

    private void isStart() {
        game = new Game();
        game.execute();
    }


    private void fillLetters(int type) {
        switch (type) {
            case 1:
                firstChar = 'Ы';
                secondChar = 'И';
                btnFisrtChoice.setText("Ы");
                btnSecondChoice.setText("И");
                break;
            case 2:
                firstChar = 'О';
                secondChar = 'А';
                btnFisrtChoice.setText("О");
                btnSecondChoice.setText("А");
                break;
            case 3:
                firstChar = 'И';
                secondChar = 'Е';
                btnFisrtChoice.setText("И");
                btnSecondChoice.setText("Е");
                break;
        }
    }


    @Override

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnFirstChoice:
                synchronized (lock) {
                    choice = firstChar;
                    lock.notify();
                }
                break;
            case R.id.btnSecondChoice:
                synchronized (lock) {
                    choice = secondChar;
                    lock.notify();
                }
                break;
        }
    }

    private class Game extends AsyncTask<Void, String, Void> {
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            timer1.interrupt();
            Intent i = new Intent(GameActivity.this, EndGameActivity.class);
            i.putExtra("Correct", correct);
            i.putExtra("InCorrect", incorrect);
            i.putExtra("Time", time / 3600 + ":" + time / 60 + ":" + time % 60);
            startActivity(i);
            finish();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            DisplayedWord.setText(values[0]);
            super.onProgressUpdate(values);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            synchronized (lock) {
                for (int i = 0; i < words.length; i++) {

                    String curWord = words[i];
                    curWord = curWord.toUpperCase();
                    int curLetter = Integer.parseInt(letters[i]) - 1;
                    String newWord = "";
                    char CurChar = 0;
                    for (int j = 0; j < curWord.length(); j++) {
                        if (curLetter == j) {
                            CurChar = curWord.charAt(j);
                            newWord += "...";
                            continue;
                        }
                        newWord += curWord.charAt(j);
                    }
                    publishProgress(newWord);
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (CurChar == choice) {
                        correct++;
                    } else {
                        incorrect++;
                    }
                }
            }
            return null;
        }
    }

    private class Timer extends Thread {

        @Override
        public void run() {
            synchronized (timer) {
                while (true) {
                    time++;
                    try {
                        timer.wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
