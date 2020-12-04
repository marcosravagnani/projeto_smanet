package com.example.projeto_smanet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.projeto_smanet.modulo.Pessoa;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class tela_cadastrocliente extends AppCompatActivity {

    private Button tela_contrato, tela_principal, btn_cadastrar;
    private EditText edt_nome, edt_cpf, edt_telefone;

    //info dados cliente
    private String Nome, cpf, telefone;

    //conexão com bd
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastrocliente);

        final EditText edt_nome = (EditText) findViewById(R.id.edt_nomecliente);
        final EditText edt_cpf = (EditText) findViewById(R.id.edt_cpfcliente);
        final EditText edt_telefone = (EditText) findViewById(R.id.edt_telefone);
        Button tela_contrato = (Button)findViewById(R.id.btn_criarcontrato);
        Button tela_principal = (Button)findViewById(R.id.btn_voltarmenu);
        Button btn_cadastrar = (Button)findViewById(R.id.btn_cadastrar);

        inicializarFirebase();

        //evento onclick para dados no bd
        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pessoa p = new Pessoa();
                p.setCpf(edt_cpf.getText().toString());
                p.setNome(edt_nome.getText().toString());
                p.setTelefone(edt_telefone.getText().toString());
                databaseReference.child("Cliente").child(p.getCpf()).setValue(p);
                limparCampos();

                //dadosCliente(edt_cpf.getText().toString(), edt_nome.getText().toString(), edt_telefone.getText().toString());
            }
        });


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
    private void limparCampos(){
        edt_cpf.setText("");
        edt_nome.setText("");
        edt_telefone.setText("");
    }

    private void inicializarFirebase(){
        FirebaseApp.initializeApp(tela_cadastrocliente.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

}
