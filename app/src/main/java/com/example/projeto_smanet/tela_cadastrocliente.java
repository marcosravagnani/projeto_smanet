package com.example.projeto_smanet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tela_cadastrocliente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastrocliente);
    }
//botão voltar
    @Override
    public void voltar (View view) {
        startActivity(new Intent(tela_cadastrocliente.this, MainActivity.class));

    }
//botão cadastrar contrato
    @Override
    public void cadastrar_contrato (View view) {
        startActivity(new Intent(tela_cadastrocliente.this, tela_cadastrocontrato.class));

    }
}
