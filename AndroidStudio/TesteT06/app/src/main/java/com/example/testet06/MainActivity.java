package com.example.testet06;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView bottle;
    private int lastDirection;

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
        bottle = findViewById(R.id.garrafa);
    }

    public void spinBottle(View v){
        int newDirection = new Random().nextInt(1800);
        float xAxis = bottle.getWidth()/2;
        float yAxis = bottle.getHeight()/2;

        Animation spin =
                new RotateAnimation(lastDirection, newDirection, xAxis, yAxis);
        spin.setDuration(3000);
        spin.setFillAfter(true);
        lastDirection = newDirection;
        bottle.startAnimation(spin);
    }
}