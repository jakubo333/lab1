package com.example.lab1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Zadanie1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zadanie1);

        final EditText etLogin = findViewById(R.id.etLogin);
        final EditText etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnCancel = findViewById(R.id.btnCancel);

        btnLogin.setOnClickListener(v -> {
            String login = etLogin.getText().toString().trim();
            String password = etPassword.getText().toString();
            if (login.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Uzupełnij login i hasło", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Zalogowano jako " + login, Toast.LENGTH_SHORT).show();
            }
        });

        btnCancel.setOnClickListener(v -> {
            etLogin.setText("");
            etPassword.setText("");
        });
    }
}
