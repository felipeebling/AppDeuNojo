package com.example.appdeunojo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaLogin extends AppCompatActivity {
    private EditText etEmail, etSenha;
    private Button btnLogin, btnCadastrar;
    private SQLiteDatabase db;
    private conectadb banco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenha);
        btnLogin = findViewById(R.id.btnLogin);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        banco = new conectadb(TelaLogin.this);
        SQLiteDatabase db = banco.getWritableDatabase();

        btnLogin.setOnClickListener(v -> realizarLogin());
        btnCadastrar.setOnClickListener(v -> realizarCadastro());

    }

    private void realizarLogin() {
        String email = etEmail.getText().toString().trim().toLowerCase();
        String senha = etSenha.getText().toString().trim().toLowerCase();

        if (email.isEmpty() || senha.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }
        usuariocontrole user = new usuariocontrole(TelaLogin.this);

        if ( user.login(email,senha)){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show();
        }




    }

    private void realizarCadastro() {
        Toast.makeText(this, "Redirecionando para cadastro...", Toast.LENGTH_SHORT).show();
        // Lógica de cadastro pode ser acoplada aqui ou abrir uma nova tela
    }

}
