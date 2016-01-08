package com.example.cristianduarte.intentslesson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by cduarte on 1/8/16.
 */
public class DetailSerializableActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView mTextView = new TextView(this);
        Person mPerson = (Person)getIntent().getSerializableExtra(MainActivity.SER_KEY);
        mTextView.setText("You name is: " + mPerson.getName() + "/n"+
                "You age is: " + mPerson.getAge());

        setContentView(mTextView);
    }

}
