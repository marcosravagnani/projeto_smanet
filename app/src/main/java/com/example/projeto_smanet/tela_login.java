package com.example.projeto_smanet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class tela_login extends AppCompatActivity {
    Button btn_entrar;
    EditText edt_login, edt_senha;

    private FirebaseAuth auth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);
        eventoClick();

        edt_login = (EditText) findViewById(R.id.edt_login);
        edt_senha = (EditText) findViewById(R.id.edt_senha);
        btn_entrar = (Button) findViewById(R.id.btn_entrar);

        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edt_login.getText().toString().trim();
                String password = edt_senha.getText().toString().trim();

                loginMethod(email, password);
            }
        });

    }

    private void loginMethod(String email, String password) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(tela_login.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Intent i = new Intent(tela_login.this, MainActivity.class);
                    startActivity(i);
                }else{
                    alert("Email ou senha incorretos");
                }
            }
        });

    }

    private void alert(String email_ou_senha_incorretos) {
        Toast.makeText(tela_login.this, email_ou_senha_incorretos, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = conexaoBD.getFirebaseAuth();
        user = conexaoBD.getFirebaseUser();
    }


/*valida login e senha
    public void valida (View view) {
        if (edt_login.getText().toString().equals("admin") && edt_senha.getText().toString().equals("admin"))
            startActivity(new Intent(tela_login.this, MainActivity.class));
        else
            Toast.makeText(this, "usuário ou senha inválido", Toast.LENGTH_LONG).show();
    }*/
}
