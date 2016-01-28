package com.example.lisa_3.hipotecas;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.sql.SQLException;

/**
 * Created by lisa-3 on 27/01/16.
 */
public class HipotecaCursorAdapter extends CursorAdapter {

    private HipotecaDbAdapter dbAdapter = null ;

    public HipotecaCursorAdapter(Context context, Cursor c) throws SQLException {
        super(context, c);
        dbAdapter = new HipotecaDbAdapter(context);
        dbAdapter.abrir();
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(android.R.layout.simple_dropdown_item_1line, parent, false);

        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tv = (TextView) view ;

        tv.setText(cursor.getString(cursor.getColumnIndex(HipotecaDbAdapter.C_COLUMNA_NOMBRE)));
    }
}
