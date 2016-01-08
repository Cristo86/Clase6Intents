package com.example.cristianduarte.intentslesson;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

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
        mBundle.putSerializable(SER_KEY, mPerson);
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

    private static final int REQUEST_NEW_NUMBER = 1243;
    private static final int REQUEST_NEW_COLOR = 1244;
    private static final int REQUEST_IMAGE_CAPTURE = 1245;

    public void askNumber(View v) {
        Intent askNumberIntent = new Intent(this, NumberGeneratorActivity.class);
        startActivityForResult(askNumberIntent, REQUEST_NEW_NUMBER);
    }

    public void askColor(View v) {
        Intent askNumberIntent = new Intent(this, NumberGeneratorActivity.class);
        startActivityForResult(askNumberIntent, REQUEST_NEW_COLOR);
    }

    public void askPhoto(View v) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }
    }


    private void setBackground(View v, Drawable d) {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN) {
            setBackgroundJellyBean(v,d);
        } else {
            setBackgroundPreJellyBean(v,d);
        }
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setBackgroundJellyBean(View v, Drawable d) {
        v.setBackground(d);
    }

    private void setBackgroundPreJellyBean(View v, Drawable d) {
        v.setBackgroundDrawable(d);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_NEW_NUMBER:
                    int n = data.getIntExtra("number", 0);
                    Toast.makeText(this, "Valor elegido: " + n, Toast.LENGTH_LONG).show();
                    break;
                case REQUEST_NEW_COLOR:
                    int color = data.getIntExtra("color", 0xFFFFFF);
                    findViewById(R.id.content_layout).setBackgroundColor(color);
                    break;
                case REQUEST_IMAGE_CAPTURE:
                    Bundle extras = data.getExtras();
                    Bitmap imageBitmap = (Bitmap) extras.get("data");
                    ((ImageView) findViewById(R.id.imageView)).setImageBitmap(imageBitmap);
                    /*setBackground(findViewById(R.id.content_layout),
                            new BitmapDrawable(getResources(), imageBitmap));*/
                default:
                    break;
            }
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Usuario canceló", Toast.LENGTH_LONG).show();
        } else {

        }
    }
}
