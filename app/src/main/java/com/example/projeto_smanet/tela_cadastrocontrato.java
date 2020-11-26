package com.example.projeto_smanet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class tela_cadastrocontrato extends AppCompatActivity {

    private Button voltar_menu, cadastrar_contrato;
    private EditText valor, login, senha;
    private RadioButton plano10, plano30, plano60, plano100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastrocontrato);

        EditText valor = (EditText)findViewById(R.id.edt_valorplano);
        EditText login = (EditText)findViewById(R.id.edt_login);
        EditText senha = (EditText)findViewById(R.id.edt_senha);
        Button voltar_menu = (Button)findViewById(R.id.btn_voltarmenu);
        Button cadastrar_contrato = (Button)findViewById(R.id.btn_criarcontrato);

        //botão voltar menu
        voltar_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(tela_cadastrocontrato.this, MainActivity.class));
            }
        });
    }


}
