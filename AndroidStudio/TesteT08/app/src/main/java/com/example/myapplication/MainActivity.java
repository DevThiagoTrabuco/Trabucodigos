package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton cadastro;
    private EditText email, senha;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        email = findViewById(R.id.mail);
        senha = findViewById(R.id.senha);
        pb = findViewById(R.id.progressBar);
        cadastro = findViewById(R.id.cadastro);
    }

    @Override
    public void onStart(){
        super.onStart();

        FirebaseUser userAtual = FirebaseAuth.getInstance().getCurrentUser();
        if(userAtual != null){
            chamarPerfil();
        }
    }

    public void login(View v){
        String mail = email.getText().toString();
        String pass = senha.getText().toString();

        if(mail.isEmpty() || pass.isEmpty()){
            Snackbar snac = Snackbar.make
                    (v, "Preencha todos os campos", Snackbar.LENGTH_SHORT);
            snac.setBackgroundTint(Color.WHITE);
            snac.setTextColor(Color.BLACK);
            snac.show();
        } else {
            loginUser(v);
        }
    }

    private void loginUser(View v) {
        String mail = email.getText().toString();
        String pass = senha.getText().toString();

        FirebaseAuth.getInstance().signInWithEmailAndPassword(mail, pass).
                addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    pb.setVisibility(View.VISIBLE);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            chamarPerfil();
                        }
                    }, 3000);
                } else {
                    String erro;
                    try{
                        throw task.getException();
                    } catch(Exception e){
                        erro = "Email ou senha incorretos";
                    }
                    Snackbar snac = Snackbar.make
                            (v, erro, Snackbar.LENGTH_SHORT);
                    snac.setBackgroundTint(Color.WHITE);
                    snac.setTextColor(Color.BLACK);
                    snac.show();
                }
            }
        });
    }

    private void chamarPerfil() {
        Intent i = new Intent(getApplicationContext(), MainActivity3.class);
        startActivity(i);
    }

    public void chamarCadastro(View v){
        Intent i = new Intent(getApplicationContext(), MainActivity2.class);
        startActivity(i);
    }
}