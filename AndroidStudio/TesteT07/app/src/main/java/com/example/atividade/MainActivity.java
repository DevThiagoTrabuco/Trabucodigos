package com.example.atividade;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView result;

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
        result = findViewById(R.id.result);

        /*FirebaseAuth.getInstance().
                createUserWithEmailAndPassword("nome@email.com", "123456");*/

        FirebaseAuth.getInstance().
            signInWithEmailAndPassword("nome@email.com", "123456").
                addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            result.setText("Logado");
                        } else {
                            result.setText("Não logado");
                        }
                    }
                });

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        String idUser = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference dr =
                db.collection("Usuários").document(idUser);

        Map<String, Object> usuarios = new HashMap<>();
        usuarios.put("nome", "Marselo");
        usuarios.put("idade", "12");
        dr.set(usuarios);
    }
}