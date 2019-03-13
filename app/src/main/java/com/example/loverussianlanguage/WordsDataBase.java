package com.example.loverussianlanguage;

import android.content.Context;

import java.util.ResourceBundle;

/**
 * Created by the best android developer on 11.08.2018.
 */

public class WordsDataBase {

    private int choose;
    private Context context;

    //Передавай сюда число от 1-3(тема)
    public WordsDataBase(int choose, Context context) {
        this.choose = choose;
        this.context = context;
    }

    //Забирай свои слова обратно)00)))0
    public String[] getWords() {
        String[] words_and_number, all_words;
        switch(choose) {
            case 1:
                words_and_number = context.getResources().getStringArray(R.array.words_rule_1);
                all_words = new String[words_and_number.length];

                for(int i = 0; i < words_and_number.length; i++) {
                    String[] word_with_num = words_and_number[i].split("\\s+"); //Пробел удаляем, получая слово и цифру
                    //в 0 элементе слово
                    //в 1 цифра
                    all_words[i] = word_with_num[0];
                }
            break;

            case 2:
                words_and_number = context.getResources().getStringArray(R.array.words_rule_2);
                all_words = new String[words_and_number.length];

                for(int i = 0; i < words_and_number.length; i++) {
                    String[] word_with_num = words_and_number[i].split("\\s+"); //Пробел
                    all_words[i] = word_with_num[0];
                }
            break;

            case 3:
                words_and_number = context.getResources().getStringArray(R.array.words_rule_3);
                all_words = new String[words_and_number.length];

                for(int i = 0; i < words_and_number.length; i++) {
                    String[] word_with_num = words_and_number[i].split("\\s+"); //Пробел
                    all_words[i] = word_with_num[0];
                }
            break;

            default:
                all_words = new String[0]; //Без этого нельзя, т.к. вдруг ты как-то передашь число не от 1-3
        }

        return all_words;
    }

    //Забирай свои циферки
    public String[] getNumbers() {
        String[] words_and_number, all_numbers;
        switch(choose) {
            case 1:
                words_and_number = context.getResources().getStringArray(R.array.words_rule_1);
                all_numbers = new String[words_and_number.length];

                for(int i = 0; i < words_and_number.length; i++) {
                    String[] word_with_num = words_and_number[i].split("\\s+"); //Пробел
                    all_numbers[i] = word_with_num[1];
                }
                break;

            case 2:
                words_and_number = context.getResources().getStringArray(R.array.words_rule_2);
                all_numbers = new String[words_and_number.length];

                for(int i = 0; i < words_and_number.length; i++) {
                    String[] word_with_num = words_and_number[i].split("\\s+"); //Пробел
                    all_numbers[i] = word_with_num[1];
                }
                break;

            case 3:
                words_and_number = context.getResources().getStringArray(R.array.words_rule_3);
                all_numbers = new String[words_and_number.length];

                for(int i = 0; i < words_and_number.length; i++) {
                    String[] word_with_num = words_and_number[i].split("\\s+"); //Пробел
                    all_numbers[i] = word_with_num[1];
                }
                break;

            default:
                all_numbers = new String[0]; //Без этого нельзя, т.к. вдруг ты как-то передашь число не от 1-3
        }

        return all_numbers;
    }

}
