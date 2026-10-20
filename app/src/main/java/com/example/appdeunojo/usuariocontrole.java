package com.example.appdeunojo;


import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class usuariocontrole {

    private SQLiteDatabase db;
    private conectadb banco;

    public usuariocontrole(Context contexto) {
        this.banco = new conectadb(contexto);
    }

    public boolean insere_usuario(usuario usr) {
        String INSERE_USUARIO = "INSERT INTO usuario (login,senha) values ('" + usr.getLogin() + "','" + usr.getSenha() + "')";
        try {
            SQLiteDatabase db = banco.getWritableDatabase();
            db.execSQL(INSERE_USUARIO);
            db.close();
            return true;
        } catch (Exception ex) {
            //("Erro (criação tabela)",ex.getMessage());
            return false;
        }


    }

    public boolean login(String login, String senha){
        String verifica = "Select login, senha from usuario where login = '" + login + "' and senha = '" + senha + "'";
        try {
            SQLiteDatabase db = banco.getWritableDatabase();
            Cursor c = db.rawQuery(verifica, null);

            if (c.getCount() > 0) {
                c.close();
                db.close();
                return true;
            }
            c.close();
            db.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }

    public void apaga_usuario(usuario usr) {
        String APAGA_USUARIO = "DELETE FROM usuario WHERE id_usr =" + usr.getId();
        try {
            SQLiteDatabase db = banco.getWritableDatabase();
            db.execSQL(APAGA_USUARIO);
            db.close();
        } catch (Exception ex) {
            //("Erro (criação tabela)",ex.getMessage());
        }
    }

    public void atualiza_usuario(usuario usr) {
        String ATUALIZA_USUARIO = "UPDATE TABLE usuario SET login = " + usr.getLogin() + ", senha =" + usr.getSenha() + " WHERE id_usr = " + usr.getId();
        try {
            SQLiteDatabase db = banco.getWritableDatabase();
            db.execSQL(ATUALIZA_USUARIO);
            db.close();
        } catch (Exception ex) {
            //("Erro (criação tabela)",ex.getMessage());
        }
    }

    public List<String> Consulta_todos_usuarios() {

        List<String> listaDeUsuarios = new ArrayList<>();
        String CONSULTA_USUARIO = "SELECT id_usr,login,senha FROM usuario ORDER BY login";
        try {
            SQLiteDatabase bd = banco.getReadableDatabase();
            Cursor c = bd.rawQuery(CONSULTA_USUARIO, null);
            if (c.moveToFirst()) {
                do {
                    String linha = "id :" + c.getString(0) + "\nLogin :"
                            + c.getString(1) + "\nSenha :" + c.getString(2);
                    listaDeUsuarios.add(linha);
                } while (c.moveToNext());
            }
            c.close();
            bd.close();
            return listaDeUsuarios;
        } catch (Exception ex) {
            //  ("Erro (criação tabela)",ex.getMessage());
            return null;
        }

    }

    public List<String> Consulta_usuario(String cod) {
        List<String> listaDeUsuarios = new ArrayList<>();
        String CONSULTA_USUARIO = "SELECT id_usr,login,senha FROM usuario WHERE id_usr = "
                + cod + " ORDER BY login";
        try {
            SQLiteDatabase bd = banco.getReadableDatabase();
            Cursor c = bd.rawQuery(CONSULTA_USUARIO, null);
            if (c.moveToFirst()) {
                do {
                    String linha = "id :" + c.getString(0) + "\nLogin :"
                            + c.getString(1) + "\nSenha :" + c.getString(2);
                    listaDeUsuarios.add(linha);
                } while (c.moveToNext());
            }
            c.close();
            bd.close();
            return listaDeUsuarios;
        } catch (Exception ex) {
            //  ("Erro (criação tabela)",ex.getMessage());
            return null;
        }

    }



}

