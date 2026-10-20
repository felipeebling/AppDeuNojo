package com.example.appdeunojo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaCadastro extends AppCompatActivity {
    Button btnCadastrar;
    EditText edtUsuario, edtSenha;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        usuariocontrole usrc = new usuariocontrole(this);

        btnCadastrar = findViewById(R.id.btnCadastrar);
        edtUsuario = findViewById(R.id.edUsuario);
        edtSenha = findViewById(R.id.edSenha);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String unome = edtUsuario.getText().toString();
                String senha = edtSenha.getText().toString();

                usuario user = new usuario(unome, senha);

                if (usrc.insere_usuario(user)){
                    edtUsuario.setText("");
                    edtSenha.setText("");
                    Toast.makeText(TelaCadastro.this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(TelaCadastro.this, TelaLogin.class);
                    startActivity(intent);
                    finish();

                }else
                    Toast.makeText(TelaCadastro.this, "Erro ao cadastrar usuário!", Toast.LENGTH_SHORT).show();

            }
        });


    }
}