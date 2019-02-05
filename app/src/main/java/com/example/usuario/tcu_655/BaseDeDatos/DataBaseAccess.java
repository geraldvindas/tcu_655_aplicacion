package com.example.usuario.tcu_655.BaseDeDatos;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataBaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DataBaseAccess instance;

    private DataBaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DataBaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DataBaseAccess(context);
        }
        return instance;
    }

    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    public List<Leyes> getLeyes() {
        List<Leyes> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM leyes", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            boolean nueva = true;
            for (Leyes temp : list) {
                if(temp.nombre.equals(cursor.getString(0))){
                    temp.addArticulo(new Articulo(cursor.getString(1), cursor.getString(2)));
                    nueva = false;
                    break;
                }
            }
            if(nueva){
                Leyes ley = new Leyes(cursor.getString(0), cursor.getInt(3));
                ley.addArticulo(new Articulo(cursor.getString(1), cursor.getString(2)));
                list.add(ley);

            }
            cursor.moveToNext();
        }
        for (Leyes temp : list){
            Collections.sort(temp.articulos);
        }
        return list;
    }

    public List<Conceptos> getConceptos() {
        List<Conceptos> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM glosario", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(new Conceptos(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getInt(4),cursor.getString(5)));
            cursor.moveToNext();
        }
        Collections.sort(list);
        cursor.close();
        return list;
    }

    public List<Asadas> getAsadas() {
        List<Asadas> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM asadas", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(new Asadas(cursor.getString(0),cursor.getString(1),cursor.getInt(2),cursor.getString(3),cursor.getInt(4),cursor.getInt(5),cursor.getString(6)));
            cursor.moveToNext();
        }
        cursor.close();
        getTomas(list);
        return list;
    }

    public void getTomas(List<Asadas> lista) {
        Cursor cursor = database.rawQuery("SELECT * FROM tomasagua", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            TomasDeAgua toma = new TomasDeAgua(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));
            for (Asadas temp:lista) {
                if(toma.getZona().contains(temp.getNombre())){
                    temp.setToma(toma);
                }
            }
            cursor.moveToNext();
        }
        cursor.close();
    }

    public List<Zona> getZona() {
        List<Zona> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM zonas", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(new Zona(cursor.getString(0),cursor.getString(1),cursor.getString(2)));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}
