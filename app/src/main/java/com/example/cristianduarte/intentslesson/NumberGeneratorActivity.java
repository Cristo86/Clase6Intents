package com.example.cristianduarte.intentslesson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class NumberGeneratorActivity extends AppCompatActivity {

    private int mInvented;
    private int mInventedColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_generator);

        mInvented = (int) (Math.random()*1000);
        mInventedColor = new Random().nextInt();
        ((TextView) findViewById(R.id.numberTxt)).setText("Created number: " + mInvented);
        ((TextView) findViewById(R.id.numberTxt)).setBackgroundColor(mInventedColor);

    }

    public void doReturnValue(View v) {
        Intent intent = new Intent();
        intent.putExtra("number", mInvented);
        intent.putExtra("color", mInventedColor);
        setResult(RESULT_OK, intent);
        finish();
    }

}
