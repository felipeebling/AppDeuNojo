package com.example.appdeunojo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class Anuncio  {
    private String categoria;
    private String titulo;
    private String preco;
    private String descricao;
    private String contato;
    private String situacao;
    private String dataSalva;

    public Anuncio(String categoria, String titulo, String preco, String descricao, String contato, String situacao, String dataSalva) {
        this.categoria = categoria;
        this.titulo = titulo;
        this.preco = preco;
        this.descricao = descricao;
        this.contato = contato;
        this.situacao = situacao;
        this.dataSalva = dataSalva;
    }

    public String getCategoria() { return categoria; }
    public String getTitulo() { return titulo; }
    public String getPreco() { return preco; }
    public String getDescricao() { return descricao; }
    public String getContato() { return contato; }
    public String getSituacao() { return situacao; }
    public String getDataSalva() { return dataSalva; }
}