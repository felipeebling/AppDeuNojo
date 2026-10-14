package com.example.appdeunojo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class conectadb extends SQLiteOpenHelper {

    String tab_usr = "CREATE TABLE IF NOT EXISTS usuario (id_usr INTEGER PRIMARY KEY AUTOINCREMENT,login TEXT,senha TEXT); " ;


    String anuncio = "CREATE TABLE IF NOT EXISTS anuncio (id INTEGER PRIMARY KEY AUTOINCREMENT,categoria Text," +
            "titulo TEXT, preco TEXT, descricao TEXT,contato TEXT, situacao TEXT,dataSalva DATETIME DEFAULT CURRENT_TIMESTAMP); ";



    conectadb (Context contexto){
        super(contexto, "osdb",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(tab_usr);
        sqLiteDatabase.execSQL(anuncio);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String RECRIA="DROP TABLE IF EXISTS usuario";
        String RECRIA2="DROP TABLE IF EXISTS anuncio";
        sqLiteDatabase.execSQL(RECRIA);
        sqLiteDatabase.execSQL(RECRIA2);
        onCreate(sqLiteDatabase);
    }
}
