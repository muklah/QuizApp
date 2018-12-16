package com.example.muklahhn.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public EditText answer1;
    public RadioButton answer2;
    public RadioButton answer3;
    public CheckBox answer4a;
    public CheckBox answer4b;
    public CheckBox answer4c;

    String Answer1;

    String Correct;
    String Recorrect;
    String Four;

    String ans1;
    String ans2;
    String ans3;
    String ans4;

    int numberOfPoints = 0;

    ArrayList<String> incorrectAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answer1 = (EditText) findViewById(R.id.answer1);
        answer2 = (RadioButton) findViewById(R.id.answer2);
        answer3 = (RadioButton) findViewById(R.id.answer3);
        answer4a = (CheckBox) findViewById(R.id.answer4a);
        answer4b = (CheckBox) findViewById(R.id.answer4b);
        answer4c = (CheckBox) findViewById(R.id.answer4c);

        Answer1 = getString(R.string.answer1);
        Correct = getString(R.string.correct);
        Recorrect = getString(R.string.recorrect);
        Four = getString(R.string.four);

        ans1 = getString(R.string.ans1);
        ans2 = getString(R.string.ans2);
        ans3 = getString(R.string.ans3);
        ans4 = getString(R.string.ans4);
    }

    public void onClick(View view) {

        incorrectAnswers = new ArrayList<String>();

        Question1();
        Question2();
        Question3();
        Question4();

        StringBuilder sbIncorrectAnswers = new StringBuilder();
        for(int i =0;i<incorrectAnswers.size();i++) {

                sbIncorrectAnswers.append(incorrectAnswers.get(i));
                sbIncorrectAnswers.append("\n");
        }

        Toast.makeText(MainActivity.this, Correct + numberOfPoints + Four + "\n" + Recorrect +
                "\n" + sbIncorrectAnswers, Toast.LENGTH_LONG).show();
        numberOfPoints = 0;

    }

    private void Question1() {
        boolean fAnswer1 = answer1.getText().toString().equalsIgnoreCase(Answer1);
        if (fAnswer1) {
            numberOfPoints++;
        }
        else {
            incorrectAnswers.add(ans1);
        }
        return ;
    }

    private void Question2() {
        boolean fAnswer2 = answer2.isChecked();
        if (fAnswer2) {
            numberOfPoints++;
        }
        else {
            incorrectAnswers.add(ans2);
        }
        return ;
    }

    private void Question3() {
        boolean fAnswer3 = answer3.isChecked();
        if (fAnswer3) {
            numberOfPoints++;
        }
        else {
            incorrectAnswers.add(ans3);
        }
        return ;
    }

    private void Question4() {
        boolean fAnswer4a = answer4a.isChecked();
        boolean fAnswer4b = answer4b.isChecked();
        boolean fAnswer4c = answer4c.isChecked();
        if (fAnswer4a && fAnswer4b && !fAnswer4c) {
            numberOfPoints++;
        }
        else {
            incorrectAnswers.add(ans4);
        }
        return ;
    }

}
