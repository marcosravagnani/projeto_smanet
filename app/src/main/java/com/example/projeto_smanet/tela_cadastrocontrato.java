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

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class tela_cadastrocontrato extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private Button voltar_menu, cadastrar_contrato;
    private EditText plano, valor, login, senha;
    private RadioButton plano10, plano30, plano60, plano100;
    private RadioGroup radio_grupo;
    private InfoContrato infocontrato;

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

        FirebaseApp.initializeApp(tela_cadastrocontrato.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();

        infocontrato = new InfoContrato();



        //botão voltar menu
        voltar_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(tela_cadastrocontrato.this, MainActivity.class));
            }
        });

        /*public void cadastrarContrato(String plano, String valor, String login, String senha){
            String key = databaseReference.child("infocontrato").push().getKey();
            infocontrato.setValor(valor);
            infocontrato.setPlano(plano);
            infocontrato.setLogin(login);
            infocontrato.setSenha(senha);

            databaseReference.child("key").setValue(infocontrato);
            Toast.makeText()
        }*/

        /*cadastrar_contrato.setOnClickListener(new View.OnClickListener() {
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
        });*/
    }
    /*private void  encontrarRadioButton(int checkId){
        switch (checkId){
            case R.id.plano10:
                String plano = String.valueOf(checkId);
                break;
            case R.id.plano30:
                String plano1 = String.valueOf(checkId);
                break;
            case R.id.plano60:
            String plano2 = String.valueOf(checkId);
            break;
            case R.id.plano100:
                String plano3 = String.valueOf(checkId);
                break;

        }

    }*/
}





