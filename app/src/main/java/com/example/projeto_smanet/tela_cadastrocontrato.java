package com.example.projeto_smanet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class tela_cadastrocontrato extends AppCompatActivity {

    private Button voltar_menu, cadastrar_contrato;
    private EditText valor, login, senha;
    private RadioButton plano10, plano30, plano60, plano100;
    private RadioGroup radio_grupo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastrocontrato);

        EditText valor = (EditText) findViewById(R.id.edt_valorplano);
        EditText login = (EditText) findViewById(R.id.edt_login);
        EditText senha = (EditText) findViewById(R.id.edt_senha);


        final RadioGroup radio_grupo = (RadioGroup) findViewById(R.id.radio_grupo);


        Button voltar_menu = (Button) findViewById(R.id.btn_voltarmenu);
        Button cadastrar_contrato = (Button) findViewById(R.id.btn_criarcontrato);


        //botão voltar menu
        voltar_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(tela_cadastrocontrato.this, MainActivity.class));
            }
        });

        cadastrar_contrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checkId = radio_grupo.getCheckedRadioButtonId();

                if (checkId == -1) {
                    //Se for -1 significa que nenhum id foi selecionado
                    Toast.makeText(tela_cadastrocontrato.this, "Nenhum botão selecionado", Toast.LENGTH_LONG).show();
                } else {
                    encontrarRadioButton(checkId);
                }

            }
        });
    }

    private void encontrarRadioButton(int checkId) {
        switch (checkId){
            case R.id.plano10:
                String plano10 = String.valueOf(checkId);
                break;
            case R.id.plano30:
                String plano30 = String.valueOf(checkId);
                break;
            case R.id.plano60:
                String plano60 = String.valueOf(checkId);
                break;
            case R.id.plano100:
                String plano100 = String.valueOf(checkId);
                break;
        }
    }
}