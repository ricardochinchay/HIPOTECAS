package com.example.lisa_3.hipotecas;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Hipoteca extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hipoteca);
        /*
        * Declaramos el controlador de la BBDD y accedemos en modo escritura
        */
        HipotecaDbHelper dbHelper = new HipotecaDbHelper(getBaseContext());

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Toast.makeText(getBaseContext(), "Base de datos preparada", Toast.LENGTH_LONG).show();
    }
}
