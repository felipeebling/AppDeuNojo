package com.example.appdeunojo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
        tvCategoria = findViewById(R.id.tvDetalheCategoria);
        tvTitulo = findViewById(R.id.tvDetalheTitulo);
        tvPreco = findViewById(R.id.tvDetalhePreco);
        tvData = findViewById(R.id.tvDetalheData);
        tvDescricao = findViewById(R.id.tvDetalheDescricao);

    }
}