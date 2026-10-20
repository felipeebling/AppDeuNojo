package com.example.appdeunojo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class TelaClassificados extends AppCompatActivity {
    private Spinner spFiltroCategoria;
    private List<Anuncio> lista = new ArrayList<>();
    ListView listView;

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
        spFiltroCategoria = findViewById(R.id.spFiltroCategoria);
        AnuncioControle ac = new AnuncioControle(this);
        listView = findViewById(R.id.lsttodos);
        ArrayAdapter<Anuncio> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        listView.setAdapter(adapter);



        String[] categorias = {"Todas", "Eletrônicos", "Veículos", "Imóveis", "Moda", "Outros"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categorias);
        spFiltroCategoria.setAdapter(spinnerAdapter);

        spFiltroCategoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 0=Todas, 1 = eletronicos, 2 = veiculos,3 = imoveis, 4 = moda, 5 = outros
                String categoria = parent.getItemAtPosition(position).toString();
                switch (position){
                    case 0:
                       lista = ac.consultaTodosAnuncio();
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


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

    }
}