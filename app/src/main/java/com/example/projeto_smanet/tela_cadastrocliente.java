package com.example.projeto_smanet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class tela_cadastrocliente extends AppCompatActivity {

    private Button tela_contrato, tela_principal, btn_cadastrar;
    private EditText edt_nome, edt_cpf, edt_telefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastrocliente);

        EditText edt_nome = (EditText) findViewById(R.id.edt_nomecliente);
        EditText edt_cpf = (EditText) findViewById(R.id.edt_cpfcliente);
        EditText edt_telefone = (EditText) findViewById(R.id.edt_telefone);
        Button tela_contrato = (Button)findViewById(R.id.btn_criarcontrato);
        Button tela_principal = (Button)findViewById(R.id.btn_voltarmenu);
        Button btn_cadastrar = (Button)findViewById(R.id.btn_cadastrar);

        //chama tela de cadastro de contrato
        tela_contrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(tela_cadastrocliente.this, tela_cadastrocontrato.class));
            }
        });

        //chama tela de menu Main Activity
        tela_principal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(tela_cadastrocliente.this, MainActivity.class));
            }
        });
    }



}
