package com.example.lab1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Zadanie4Activity extends AppCompatActivity {

    private int count = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zadanie4);

        final TextView tvBadge = findViewById(R.id.tvBadge);
        Button btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(v -> {
            count++;
            tvBadge.setText(count > 9 ? "9+" : String.valueOf(count));
        });
    }
}
