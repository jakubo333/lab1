package com.example.lab1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Zadanie2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zadanie2);

        Button btnEdit = findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(v ->
                Toast.makeText(this, "Edycja profilu", Toast.LENGTH_SHORT).show());
    }
}
