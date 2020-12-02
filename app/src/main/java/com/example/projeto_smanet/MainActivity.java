package com.example.projeto_smanet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edt_nome, edt_cpf, edt_telefone, edt_plano, edt_valorplano, edt_loginpoe,
        senha_poe;

    ListView list_dados;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private List<Pessoa> pessoaList = new ArrayList<Pessoa>();
    private ArrayAdapter<Pessoa> arrayAdapterPessoa;

    Pessoa pessoaSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_dados = (ListView)findViewById(R.id.list_dados);
        edt_nome = (EditText) findViewById(R.id.edt_nomecliente);
        edt_cpf = (EditText) findViewById(R.id.edt_cpfcliente);
        edt_telefone = (EditText) findViewById(R.id.edt_telefone);

        inicializarFirebase();
        eventoDatabase();

        list_dados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pessoaSelecionada = (Pessoa)parent.getItemAtPosition(position);
                edt_nome.setText(pessoaSelecionada.getNome());
                edt_cpf.setText(pessoaSelecionada.getCpf());
                edt_telefone.setText(pessoaSelecionada.getTelefone());
            }
        });

        //implementando listview
        list_dados.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pessoaSelecionada = (Pessoa)parent.getItemAtPosition(position);

                startActivity(new Intent(MainActivity.this, tela_cadastrocliente.class));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    //método para adiciona novos dados
    private void eventoDatabase(){
        databaseReference.child("Cliente").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                pessoaList.clear();
                for (DataSnapshot objSnapshot:dataSnapshot.getChildren()){
                    Pessoa p = objSnapshot.getValue(Pessoa.class);
                    pessoaList.add(p);
                }
                arrayAdapterPessoa = new ArrayAdapter<Pessoa>(MainActivity.this,
                        android.R.layout.simple_list_item_1, pessoaList);
                list_dados.setAdapter(arrayAdapterPessoa);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void inicializarFirebase(){
        FirebaseApp.initializeApp(MainActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }
    //método inflar actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.actionbar,menu);
        MenuItem menuItem = menu.findItem(R.id.pesquisar);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Digite nome");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapterPessoa.getFilter().filter(newText);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    //ação dos botões da action bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.novo_cliente:
                Pessoa p = new Pessoa();
                p.setCpf(edt_cpf.getText().toString());
                p.setNome(edt_nome.getText().toString());
                p.setTelefone(edt_telefone.getText().toString());

                databaseReference.child("Cliente").child(p.getCpf()).setValue(p);
                limparCampos();
                break;
            case R.id.alterar:
                Pessoa p2 = new Pessoa();
                p2.setCpf(pessoaSelecionada.getCpf());
                p2.setCpf(edt_cpf.getText().toString().trim());
                p2.setNome(edt_nome.getText().toString().trim());
                p2.setTelefone(edt_telefone.getText().toString().trim());

                databaseReference.child("Cliente").child(p2.getCpf()).setValue(p2);
                limparCampos();
                break;
            case R.id.cadastrar_contrato:
                startActivity(new Intent(MainActivity.this, tela_cadastrocontrato.class));
                return (true);
            case R.id.sair:
                startActivity(new Intent(MainActivity.this, tela_login.class));
        }
        return (super.onOptionsItemSelected(item));

    }

    private void limparCampos() {
        edt_cpf.setText("");
        edt_nome.setText("");
        edt_telefone.setText("");


    }


}
