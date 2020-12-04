package com.example.projeto_smanet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.FirebaseApp;;
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
    }
}





