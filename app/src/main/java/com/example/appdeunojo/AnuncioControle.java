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






    public List<String> consultaTodosAnuncioString() {
        List<String> listaAnuncios = new ArrayList<String>();
        String consulta_anuncio ="SELECT id,categoria,titulo,preco,descricao,contato,situacao,dataSalva FROM anuncio Order by 2";
        try{
            SQLiteDatabase bd=banco.getReadableDatabase();
            Cursor c=bd.rawQuery(consulta_anuncio,null);
            if (c.moveToFirst()) {
                do {
                    String linha = "";
                    linha+=c.getString(0) ;
                    linha+="\n " +    c.getString(1);
                    linha+= "\n " + c.getString(2);
                    linha+="\n " +    c.getString(3);
                    linha+="\n " +c.getString(4);
                    linha+="\n " + c.getString(5);
                    linha+="\n " + c.getString(6);
                    linha+="\n " + c.getString(7);

                    listaAnuncios.add(linha);

                } while (c.moveToNext());
            }
            c.close();
            bd.close();
            return listaAnuncios;
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }

    }



    public List<String> consultaTodos() {
        List<String> listaAnuncios = new ArrayList<String>();
        String consulta_anuncio ="SELECT id,titulo,preco FROM anuncio Order by 2";
        try{
            SQLiteDatabase bd=banco.getReadableDatabase();
            Cursor c=bd.rawQuery(consulta_anuncio,null);
            if (c.moveToFirst()) {
                do {
                    String linha = "";
                    linha+= c.getString(0) ;
                    linha+="\n " +    c.getString(1);
                    linha+= "\n " + c.getString(2);
                    listaAnuncios.add(linha);

                } while (c.moveToNext());
            }
            c.close();
            bd.close();
            return listaAnuncios;
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }

    }


    public String consultaPorId(String cod) {
        String prod = "";
        String consulta = "Select * from anuncio where id =  '" + cod + "';";
        try {
            SQLiteDatabase bd = banco.getReadableDatabase();
            Cursor c = bd.rawQuery(consulta, null);
            if (c.moveToFirst()) {
                do {
                    prod+= c.getString(0) ;
                    prod+="\n" + c.getString(1);
                    prod+="\n" + c.getString(2);
                    prod+="\n" + c.getString(3);
                    prod+="\n" + c.getString(4);
                    prod+="\n" + c.getString(5);
                    prod+="\n" + c.getString(6);
                    prod+="\n" + c.getString(7);

                } while (c.moveToNext());
            }
            c.close();
            bd.close();
            return prod;
        } catch (Exception ex) {
            System.out.println(ex);

        }
        return null;
    }


    public List<String> consultaEspecificoAnuncio(String condicao) {
        List<String> listaAnuncios = new ArrayList<String>();
        String consulta_anuncio ="SELECT id,titulo,preco FROM anuncio Where categoria = '"+condicao+"' Order by 2";
        try{
            SQLiteDatabase bd=banco.getReadableDatabase();
            Cursor c=bd.rawQuery(consulta_anuncio,null);
            if (c.moveToFirst()) {
                do {

                    String linha = "";
                    linha+=c.getString(0);
                    linha+="\n" +c.getString(1);
                    linha+="\n" +c.getString(2);
                    listaAnuncios.add(linha);

                } while (c.moveToNext());
            }
            c.close();
            bd.close();
            return listaAnuncios;
        }catch(Exception ex){
            System.out.println(ex);

            return null;
        }

    }


}