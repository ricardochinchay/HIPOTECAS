package com.example.lisa_3.hipotecas;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.SQLException;

//public class Hipoteca extends AppCompatActivity {
    public class Hipoteca extends ListActivity {

    private HipotecaDbAdapter dbAdapter;
    private Cursor cursor;
    private HipotecaCursorAdapter hipotecaAdapter ;
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hipoteca);
        /*
        * Declaramos el controlador de la BBDD y accedemos en modo escritura
        */
       /* HipotecaDbHelper dbHelper = new HipotecaDbHelper(getBaseContext());

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Toast.makeText(getBaseContext(), "Base de datos preparada", Toast.LENGTH_LONG).show();
        */
        lista = (ListView) findViewById(android.R.id.list);     //identifico la lista con la que voy a trabajar

        dbAdapter = new HipotecaDbAdapter(this);            //instancio el ayudante que voy a usar para trabajar con la lista
        try {
            dbAdapter.abrir();                              //el ayudante me ayuda a abrir la BD
            consultar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void consultar() throws SQLException {
        cursor = dbAdapter.getCursor();     //OBTENGO TODOS LOS REGISTROS DE LA BD
        //startManagingCursor(cursor);
        hipotecaAdapter = new HipotecaCursorAdapter(this, cursor);  //le paso el contexto y el cursor al adaptador
        lista.setAdapter(hipotecaAdapter);

        //LE APLICA A CADA ELEMENTO DE LA LISTA LA POSIBILIDAD DE RESPONDER AL EVENTO CLICK
        lista.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //PRIMERO CAPTURO EL STRING DONDE SE HIZO CLICK
                        //String elemento = String.valueOf(parent.getItemAtPosition(position));
                        String elemento = String.valueOf(cursor.getString(cursor.getColumnIndex(HipotecaDbAdapter.C_COLUMNA_NOMBRE)));
                        //LUEGO LO MUESTRO EN UN TOAST SIENDO EL CONTEXTO LA ACTIVIDAD PRINCIPAL
                        Toast.makeText(Hipoteca.this,elemento,Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hipoteca, menu);
        return true;
    }
}
