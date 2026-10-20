package com.example.appdeunojo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class telaItemAnuncio extends AppCompatActivity {
    private TextView tvCategoria, tvTitulo, tvPreco, tvData, tvDescricao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_item_anuncio);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        String dados = "";
        Bundle extra = getIntent().getExtras();

        if (extra != null){
            dados = extra.getString("idProduto");
        }
        String[] vetor = dados.split("\n");

        AnuncioControle ac = new AnuncioControle(this);
        String resultado =  ac.consultaPorId(vetor[0]);
        String[] vetorResultado = resultado.split("\n");

        tvCategoria = findViewById(R.id.tvDetalheCategoria);
        tvTitulo = findViewById(R.id.tvDetalheTitulo);
        tvPreco = findViewById(R.id.tvDetalhePreco);
        tvData = findViewById(R.id.tvDetalheData);
        tvDescricao = findViewById(R.id.tvDetalheDescricao);

        tvCategoria.setText(vetorResultado[1]);
        tvTitulo.setText(vetorResultado[2]);
        tvPreco.setText(vetorResultado[3]);
        tvData.setText(vetorResultado[7]);
        tvDescricao.setText(vetorResultado[4]);

    }
}