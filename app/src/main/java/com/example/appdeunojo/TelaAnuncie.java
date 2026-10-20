package com.example.appdeunojo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TelaAnuncie extends AppCompatActivity {
    private Spinner spCategoria;
    private EditText etTitulo, etPreco, etDescricao, etContato, etSituacao;
    private Button btnSalvarAnuncio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_anuncie);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spCategoria = findViewById(R.id.spCategoria);
        etTitulo = findViewById(R.id.etTitulo);
        etPreco = findViewById(R.id.etPreco);
        etDescricao = findViewById(R.id.etDescricao);
        etContato = findViewById(R.id.etContato);
        etSituacao = findViewById(R.id.etSituacao);
        btnSalvarAnuncio = findViewById(R.id.btnSalvarAnuncio);

        // Popula o Spinner de Categorias
        String[] categorias = {"Eletrônicos", "Veículos", "Imóveis", "Moda", "Outros"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categorias);
        spCategoria.setAdapter(adapter);

        btnSalvarAnuncio.setOnClickListener(v -> salvarAnuncio());
    }

    private void salvarAnuncio() {
        String categoria = spCategoria.getSelectedItem().toString();
        String titulo = etTitulo.getText().toString().trim();
        String preco = etPreco.getText().toString().trim();
        String descricao = etDescricao.getText().toString().trim();
        String contato = etContato.getText().toString().trim();
        String situacao = etSituacao.getText().toString().trim();

        if (titulo.isEmpty() || preco.isEmpty() || descricao.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha os campos obrigatórios", Toast.LENGTH_SHORT).show();
            return;
        }

        // Obtém a data atual formatada
        Locale Locale = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        String dataAtual = sdf.format(new Date());


        Anuncio anuncio = new Anuncio(categoria, titulo, preco, descricao, contato, situacao, dataAtual);
        AnuncioControle c = new AnuncioControle(this);

        if (c.insereAnuncio(anuncio)){
            Toast.makeText(this, "Anúncio salvo com sucesso!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }else{
            Toast.makeText(this, "Erro ao salvar anúncio", Toast.LENGTH_SHORT).show();
        }



    }
}
