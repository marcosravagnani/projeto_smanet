package com.example.projeto_smanet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class tela_login extends AppCompatActivity {
    Button btn_entrar;
    EditText edt_login, edt_senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);

        edt_login = (EditText) findViewById(R.id.edt_login);
        edt_senha = (EditText) findViewById(R.id.edt_senha);
        btn_entrar = (Button) findViewById(R.id.btn_entrar);

    }
//valida login e senha
    public void valida (View view) {
        if (edt_login.getText().toString().equals("admin") && edt_senha.getText().toString().equals("admin"))
            startActivity(new Intent(tela_login.this, MainActivity.class));
        else
            Toast.makeText(this, "usuário ou senha inválido", Toast.LENGTH_LONG).show();
    }
}
