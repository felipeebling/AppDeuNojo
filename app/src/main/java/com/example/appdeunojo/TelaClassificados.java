package com.example.appdeunojo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class TelaClassificados extends AppCompatActivity {
    private Spinner spFiltroCategoria;
    private List<String> lista = new ArrayList<>();
    ListView listView;
    Button btVoltar,btVerAnuncio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_classificados);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btVoltar = findViewById(R.id.btnretornaPrincipal);
        btVerAnuncio = findViewById(R.id.btnVerAnuncio);

        spFiltroCategoria = findViewById(R.id.spFiltroCategoria);

        AnuncioControle ac = new AnuncioControle(this);
        listView = findViewById(R.id.lsttodos);






        String[] categorias = {"Todas", "Eletrônicos", "Veículos", "Imóveis", "Moda", "Outros"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categorias);
        spFiltroCategoria.setAdapter(spinnerAdapter);



        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaClassificados.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
        spFiltroCategoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 0=Todas, 1 = eletronicos, 2 = veiculos,3 = imoveis, 4 = moda, 5 = outros
                String categoria = parent.getItemAtPosition(position).toString();

                switch (position){
                    case 0:
                       lista = ac. consultaTodos();
                        break;
                    case 1:
                        lista = ac.consultaEspecificoAnuncio("Eletrônicos");
                        break;
                    case 2:
                        lista = ac.consultaEspecificoAnuncio("Veículos");
                        break;
                    case 3:
                        lista = ac.consultaEspecificoAnuncio("Imóveis");
                        break;
                    case 4:
                        lista = ac.consultaEspecificoAnuncio("Moda");
                        break;
                    case 5:
                        lista = ac.consultaEspecificoAnuncio("Outros");
                        break;
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(TelaClassificados.this, android.R.layout.simple_list_item_1, lista);

                listView.setAdapter(adapter);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(TelaClassificados.this, telaItemAnuncio.class);

                String valor = parent.getItemAtPosition(position).toString();
                intent.putExtra("idProduto",valor);
                startActivity(intent);

            }
        });

    }
}