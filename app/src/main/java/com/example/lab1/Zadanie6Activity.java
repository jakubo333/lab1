package com.example.lab1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Zadanie6Activity extends AppCompatActivity {

    private CheckBox cbTerms;
    private CheckBox cbPrivacy;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zadanie6);

        final EditText etFirstName = findViewById(R.id.etFirstName);
        final EditText etLastName = findViewById(R.id.etLastName);
        cbTerms = findViewById(R.id.cbTerms);
        cbPrivacy = findViewById(R.id.cbPrivacy);
        btnRegister = findViewById(R.id.btnRegister);

        CompoundButton.OnCheckedChangeListener listener =
                (buttonView, isChecked) -> updateButton();
        cbTerms.setOnCheckedChangeListener(listener);
        cbPrivacy.setOnCheckedChangeListener(listener);

        btnRegister.setOnClickListener(v -> {
            String name = (etFirstName.getText().toString() + " "
                    + etLastName.getText().toString()).trim();
            Toast.makeText(this, "Zarejestrowano: " + name, Toast.LENGTH_SHORT).show();
        });
    }

    private void updateButton() {
        btnRegister.setEnabled(cbTerms.isChecked() && cbPrivacy.isChecked());
    }
}
