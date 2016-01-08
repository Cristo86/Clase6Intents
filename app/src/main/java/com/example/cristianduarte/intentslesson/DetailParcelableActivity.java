package com.example.cristianduarte.intentslesson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by cduarte on 1/8/16.
 */
public class DetailParcelableActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView mTextView = new TextView(this);

        Book mBook = (Book) getIntent().getParcelableExtra(MainActivity.PAR_KEY);

        mTextView.setText("Book name is: " + mBook.bookName+"/n"+
                "Author is: " + mBook.author + "/n" +
                "PublishTime is: " + mBook.publishTime);

        setContentView(mTextView);
    }

}
