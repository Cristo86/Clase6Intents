package com.example.cristianduarte.intentslesson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button sButton,pButton;
    public  final static String SER_KEY = "com.example.cristianduarte.intentslesson.ser";
    public  final static String PAR_KEY = "com.example.cristianduarte.intentslesson.par";
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();

    }

    public void setupViews(){
        sButton = (Button)findViewById(R.id.button1);
        pButton = (Button)findViewById(R.id.button2);
        sButton.setOnClickListener(this);
        pButton.setOnClickListener(this);
    }

    public void SerializeMethod(){
        Person mPerson = new Person();
        mPerson.setName("Leon");
        mPerson.setAge(25);
        Intent mIntent = new Intent(this,DetailSerializableActivity.class);
        Bundle mBundle = new Bundle();
        mBundle.putSerializable(SER_KEY,mPerson);
        mIntent.putExtras(mBundle);

        startActivity(mIntent);
    }

    public void PacelableMethod(){
        Book mBook = new Book();
        mBook.bookName = "Android Developer Guide";
        mBook.author = "Leon";
        mBook.publishTime = 2014;
        Intent mIntent = new Intent(this,DetailParcelableActivity.class);
        Bundle mBundle = new Bundle();
        mBundle.putParcelable(PAR_KEY, mBook);
        mIntent.putExtras(mBundle);

        startActivity(mIntent);
    }

    public void onClick(View v) {
        if(v == sButton){
            SerializeMethod();
        }else{
            PacelableMethod();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
