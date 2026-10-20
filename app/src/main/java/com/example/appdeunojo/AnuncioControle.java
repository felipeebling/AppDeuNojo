package com.example.appdeunojo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class AnuncioControle {


    private SQLiteDatabase db;
    private conectadb banco;

    public AnuncioControle(Context contexto) {
        this.banco = new conectadb(contexto);
     }

    public boolean insereAnuncio(Anuncio anuncio) {

        String insereAnuncio = "INSERT INTO anuncio (categoria,titulo,preco,descricao,contato,situacao,dataSalva)" +
                " values ('" + anuncio.getCategoria() + "','" +anuncio.getTitulo() + "','" + anuncio.getPreco()
                + "','" + anuncio.getDescricao()+   "','" + anuncio.getContato()+  "','" + anuncio.getSituacao()+ "','"
                + anuncio.getDataSalva()+
                  "');";
        try {
            SQLiteDatabase db = banco.getWritableDatabase();
            db.execSQL(insereAnuncio);
            db.close();
            return true;
        } catch (Exception ex) {
            return false;
        }


    }



    public List<Anuncio> consultaTodosAnuncio() {
        List<Anuncio> listaAnuncios = new ArrayList<Anuncio>();
        String consulta_anuncio ="SELECT categoria,titulo,preco,descricao,contato,situacao,dataSalva FROM anuncio Order by 2";
        try{
            SQLiteDatabase bd=banco.getReadableDatabase();
            Cursor c=bd.rawQuery(consulta_anuncio,null);
            if (c.moveToFirst()) {
                do {

                    String cat = c.getString(0);
                    String titulo=  c.getString(1);
                    String preco = c.getString(2);
                    String des   =  c.getString(3);
                    String cont  = c.getString(4);
                    String situa = c.getString(5);
                    String data  = c.getString(6);
                    Anuncio anuncio = new Anuncio(cat,titulo,preco,des,cont,situa,data);
                    listaAnuncios.add(anuncio);

                } while (c.moveToNext());
            }
            c.close();
            bd.close();
            return listaAnuncios;
        }catch(Exception ex){
            //  ("Erro (criação tabela)",ex.getMessage());
            return null;
        }

    }


    public List<Anuncio> consultaEspecificoAnuncio(String condicao) {
        List<Anuncio> listaAnuncios = new ArrayList<Anuncio>();
        String consulta_anuncio ="SELECT categoria,titulo,preco,descricao,contato,situacao,dataSalva FROM anuncio Where categoria = '"+condicao+"' Order by 2";
        try{
            SQLiteDatabase bd=banco.getReadableDatabase();
            Cursor c=bd.rawQuery(consulta_anuncio,null);
            if (c.moveToFirst()) {
                do {

                    String cat = c.getString(0);
                    String titulo=  c.getString(1);
                    String preco = c.getString(2);
                    String des   =  c.getString(3);
                    String cont  = c.getString(4);
                    String situa = c.getString(5);
                    String data  = c.getString(6);
                    Anuncio anuncio = new Anuncio(cat,titulo,preco,des,cont,situa,data);
                    listaAnuncios.add(anuncio);

                } while (c.moveToNext());
            }
            c.close();
            bd.close();
            return listaAnuncios;
        }catch(Exception ex){
            //  ("Erro (criação tabela)",ex.getMessage());
            return null;
        }

    }


}