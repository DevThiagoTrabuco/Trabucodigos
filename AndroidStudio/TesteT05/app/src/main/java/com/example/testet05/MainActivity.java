package com.example.testet05;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }

    public void popUp(View v){
        AlertDialog popup =
                new AlertDialog.Builder(MainActivity.this).create();
        popup.setTitle("ATENÇÃO");
        popup.setMessage("Olá!");
        popup.setButton(DialogInterface.BUTTON_NEUTRAL, "Não",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.calabreso);
                        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.release();
                            }
                        });
                        mp.start();
                    }
                });
        popup.setButton(DialogInterface.BUTTON_POSITIVE, "Sim",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent c = new Intent(getApplicationContext(), tela2.class);
                        startActivity(c);
                    }
                });
        popup.setButton(DialogInterface.BUTTON_NEGATIVE, "Talvez",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent c = new Intent(getApplicationContext(), tela3.class);
                        startActivity(c);
                    }
                });
        popup.show();
    }
}