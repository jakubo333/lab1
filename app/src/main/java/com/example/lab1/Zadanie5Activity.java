package com.example.lab1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Zadanie5Activity extends AppCompatActivity {

    private TextView tvDisplay;
    private String input = "";
    private Double acc = null;
    private String pendingOp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zadanie5);
        tvDisplay = findViewById(R.id.tvDisplay);

        int[] digitIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        };
        for (int i = 0; i < digitIds.length; i++) {
            final String digit = String.valueOf(i);
            Button b = findViewById(digitIds[i]);
            b.setOnClickListener(v -> {
                input += digit;
                tvDisplay.setText(input);
            });
        }

        int[] opIds = {R.id.btnAdd, R.id.btnSub, R.id.btnMul, R.id.btnDiv};
        final String[] ops = {"+", "-", "*", "/"};
        for (int i = 0; i < opIds.length; i++) {
            final String op = ops[i];
            Button b = findViewById(opIds[i]);
            b.setOnClickListener(v -> {
                applyPending();
                pendingOp = op;
                if (acc != null) {
                    tvDisplay.setText(format(acc));
                }
            });
        }

        Button btnEq = findViewById(R.id.btnEq);
        btnEq.setOnClickListener(v -> {
            applyPending();
            pendingOp = null;
            if (acc != null) {
                tvDisplay.setText(format(acc));
            }
        });

        Button btnC = findViewById(R.id.btnC);
        btnC.setOnClickListener(v -> {
            input = "";
            acc = null;
            pendingOp = null;
            tvDisplay.setText("0");
        });
    }

    private void applyPending() {
        if (input.isEmpty()) {
            return;
        }
        double value = Double.parseDouble(input);
        if (acc == null || pendingOp == null) {
            acc = value;
        } else {
            acc = compute(acc, pendingOp, value);
        }
        input = "";
        if (acc == null) {
            pendingOp = null;
            tvDisplay.setText("Błąd");
        }
    }

    private Double compute(double a, String op, double b) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return b == 0.0 ? null : a / b;
            default:
                return b;
        }
    }

    private String format(double value) {
        if (value % 1.0 == 0.0) {
            return String.valueOf((long) value);
        }
        return String.valueOf(value);
    }
}
