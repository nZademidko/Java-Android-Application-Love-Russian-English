package com.example.loverussianlanguage;


import android.content.Context;
import android.content.SharedPreferences;

public class Character {

    private static final String SHARED_KEY = "mySettings";
    private SharedPreferences sharedPreferences;
    private static final String NAME_KEY = "Name";
    private static final String CHECK_KEY = "Check";
    private static final String GRADIENT_KEY = "Gradient";

    Character(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_KEY, Context.MODE_PRIVATE);
    }

    public void setName(String name) {
        SharedPreferences.Editor ed = sharedPreferences.edit();
        ed.putString(NAME_KEY, name);
        ed.apply();
    }

    public String getName() {
        return sharedPreferences.getString(NAME_KEY, "name");
    }

    void setCheck(boolean check) {
        SharedPreferences.Editor ed = sharedPreferences.edit();
        ed.putBoolean(CHECK_KEY, check);
        ed.apply();
    }

    boolean getCheck() {
        return sharedPreferences.getBoolean(CHECK_KEY, false);
    }

    void setGradient(int i){
        SharedPreferences.Editor ed = sharedPreferences.edit();
        ed.putInt(GRADIENT_KEY, i);
        ed.apply();
    }
    int getGradient(){
        return sharedPreferences.getInt(GRADIENT_KEY, 1);
    }
}
