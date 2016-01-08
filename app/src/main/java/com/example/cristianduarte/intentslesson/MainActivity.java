package com.example.cristianduarte.intentslesson;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Crear un mensaje de texto con un string
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Mensaje desde Android");
        sendIntent.setType("text/plain");

        // Verificar que el intent resuelve a un activity
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendIntent);
        }

        // "Main Activity"
        // Nueva instancia de intent
        Intent detailsIntent = new Intent(this, DetailActivity.class);
        // Agregamos un array de float   .putExtra(String, float[]);
        detailsIntent.putExtra(
                "COORDINATES",
                new float[]{30.4f, -19.5f, -45.6f, 55.0f});
        // Enviamos un boolean
        detailsIntent.putExtra("ACCURATE", true);
        // Iniciar activity
        startActivity(detailsIntent);

        // ...

        // "DetailActivity"
        Intent intent = getIntent();
        // Obtenemos el array de 'COORDINATES'
        float[] coordinates = intent.getFloatArrayExtra("COORDINATES");
        // ..y si era precisa, el boolean
        boolean accurate = intent.getBooleanExtra(
                "ACCURATE",
                false /* Valor por defecto*/);



        int ep = coordinates.length;
        boolean oth = accurate;

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
