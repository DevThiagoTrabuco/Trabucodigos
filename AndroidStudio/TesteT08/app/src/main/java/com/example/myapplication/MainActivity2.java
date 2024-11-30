package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {

    private EditText nome, email, senha;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nome = findViewById(R.id.nome);
        email = findViewById(R.id.mail2);
        senha = findViewById(R.id.senha2);
        pb = findViewById(R.id.progressBar2);
    }

    public void cadastrar(View v){
        String name = nome.getText().toString();
        String mail = email.getText().toString();
        String pass = senha.getText().toString();

        if(name.isEmpty() || mail.isEmpty() || pass.isEmpty()){
            Snackbar snac = Snackbar.make
                    (v, "Preencha todos os campos", Snackbar.LENGTH_SHORT);

            snac.setBackgroundTint(Color.WHITE);
            snac.setTextColor(Color.BLACK);
            snac.show();
        } else {
            CadastrarUser(v);
        }
    }

    private void CadastrarUser(View v) {
        String mail = email.getText().toString();
        String pass = senha.getText().toString();

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    pb.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            saveUserData();
                            Snackbar snac = Snackbar.make
                                    (v, "Usuário cadastrado com sucesso", Snackbar.LENGTH_SHORT);

                            snac.setBackgroundTint(Color.WHITE);
                            snac.setTextColor(Color.BLACK);
                            snac.show();
                            pb.setVisibility(View.INVISIBLE);
                        }
                    }, 3000);
                } else {
                    String erro;
                    try {
                        throw task.getException();
                    } catch (FirebaseAuthWeakPasswordException e){
                        erro = "Digite uma senha mais forte";
                    } catch (FirebaseAuthUserCollisionException e){
                        erro = "Conta já cadastrada";
                    } catch (FirebaseAuthInvalidCredentialsException e){
                        erro = "Email inválido";
                    } catch (Exception e){
                        erro = "Erro ao cadastrar usuário";
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

    private void saveUserData() {
        String name = nome.getText().toString();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> usuarios = new HashMap<>();
        usuarios.put("Nome", name);

        String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference dr = db.collection("Usuarios").document(userID);
        dr.set(usuarios);
    }
}