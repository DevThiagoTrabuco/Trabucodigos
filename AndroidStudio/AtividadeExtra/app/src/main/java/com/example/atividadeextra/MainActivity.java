package com.example.atividadeextra;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageView button3;

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

    public void tocarMusica(View v) {
        MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.musga);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
        mp.start();
    }

    public void trocaTela(View v) {
        Intent i = new Intent(getApplicationContext(), tela2.class);
        startActivity(i);
        MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.zoio);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
        mp.start();
    }

    public void abrirLink(View v) {
        Intent i = new Intent(getApplicationContext(), tela3.class);
        startActivity(i);
    }

    public void popUp(View v){
        AlertDialog popup =
                new AlertDialog.Builder(MainActivity.this).create();
        popup.setTitle("Calma aê calabreso!");
        popup.setMessage("Escolha uma opção");
        popup.setButton(DialogInterface.BUTTON_NEUTRAL, "Talvez",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.talvez);
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
                        MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.sim);
                        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.release();
                            }
                        });
                        mp.start();
                    }
                });
        popup.setButton(DialogInterface.BUTTON_NEGATIVE, "Não",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.nao);
                        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.release();
                            }
                        });
                        mp.start();
                    }
                });
        popup.show();
    }
}