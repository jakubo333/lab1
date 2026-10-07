package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] buttonIds = {
                R.id.btnZ1, R.id.btnZ2, R.id.btnZ3, R.id.btnZ4,
                R.id.btnZ5, R.id.btnZ6, R.id.btnZ7
        };
        final Class<?>[] screens = {
                Zadanie1Activity.class, Zadanie2Activity.class, Zadanie3Activity.class,
                Zadanie4Activity.class, Zadanie5Activity.class, Zadanie6Activity.class,
                Zadanie7Activity.class
        };

        for (int i = 0; i < buttonIds.length; i++) {
            final Class<?> target = screens[i];
            Button button = findViewById(buttonIds[i]);
            button.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, target)));
        }
    }
}
