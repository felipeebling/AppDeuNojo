package com.example.appdeunojo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class AnuncioControle {


    private SQLiteDatabase db;
    private conectadb banco;

    public AnuncioControle(Context contexto) {
        this.banco = new conectadb(contexto);
     }

    public void insereAnuncio(Anuncio anuncio) {

        String insereAnuncio = "INSERT INTO usuario (categoria,titulo,preco,descricao,contato,situacao,dataSalva)" +
                " values ('" + anuncio.getCategoria() + "','" +anuncio.getTitulo() + "','" + anuncio.getPreco()  + "','"
                + "','" + anuncio.getDescricao()+   "','" + anuncio.getContato()+  "','" + anuncio.getSituacao()+ "','"
                + anuncio.getDataSalva()+
                  "');";
        try {
            SQLiteDatabase db = banco.getWritableDatabase();
            db.execSQL(insereAnuncio);
            db.close();
        } catch (Exception ex) {
            //("Erro (criação tabela)",ex.getMessage());
        }


    }
}