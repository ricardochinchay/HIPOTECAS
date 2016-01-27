package com.example.lisa_3.hipotecas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by lisa-3 on 27/01/16.
 */

public class HipotecaDbHelper extends SQLiteOpenHelper {

    private static int version = 1;
    private static String name = "HipotecaDb" ;
    private static SQLiteDatabase.CursorFactory factory = null;

    public HipotecaDbHelper(Context context)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        Log.i(this.getClass().toString(), "Creando base de datos");

        db.execSQL( "CREATE TABLE HIPOTECA(" +
                " _id INTEGER PRIMARY KEY," +
                " hip_nombre TEXT NOT NULL, " +
                " hip_condiciones TEXT, " +
                " hip_contacto TEXT," +
                " hip_email TEXT," +
                " hip_telefono TEXT," +
                " hip_observaciones TEXT)" );

        db.execSQL( "CREATE UNIQUE INDEX hip_nombre ON HIPOTECA(hip_nombre ASC)" );

        Log.i(this.getClass().toString(), "Tabla HIPOTECA creada");

   /*
    * Insertamos datos iniciales
    */
        db.execSQL("INSERT INTO HIPOTECA(_id, hip_nombre) VALUES(1,'Santander')");
        db.execSQL("INSERT INTO HIPOTECA(_id, hip_nombre) VALUES(2,'BBVA')");
        db.execSQL("INSERT INTO HIPOTECA(_id, hip_nombre) VALUES(3,'La Caixa')");
        db.execSQL("INSERT INTO HIPOTECA(_id, hip_nombre) VALUES(4,'Cajamar')");
        db.execSQL("INSERT INTO HIPOTECA(_id, hip_nombre) VALUES(5,'Bankia')");
        db.execSQL("INSERT INTO HIPOTECA(_id, hip_nombre) VALUES(6,'Banco Sabadell')");
        db.execSQL("INSERT INTO HIPOTECA(_id, hip_nombre) VALUES(7,'Banco Popular')");

        Log.i(this.getClass().toString(), "Datos iniciales HIPOTECA insertados");

        Log.i(this.getClass().toString(), "Base de datos creada");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
