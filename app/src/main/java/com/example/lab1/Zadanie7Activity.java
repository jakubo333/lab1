package com.example.lab1;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Zadanie7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zadanie7);

        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", "Lekki laptop do pracy i nauki, 16 GB RAM"));
        products.add(new Product("Smartfon", "Telefon z aparatem 50 Mpx i ekranem AMOLED"));
        products.add(new Product("Słuchawki", "Bezprzewodowe słuchawki z redukcją szumów"));
        products.add(new Product("Monitor", "Monitor 27 cali, rozdzielczość 2560x1440"));
        products.add(new Product("Klawiatura", "Mechaniczna klawiatura z podświetleniem"));
        products.add(new Product("Myszka", "Ergonomiczna mysz bezprzewodowa"));
        products.add(new Product("Tablet", "Tablet 10 cali z rysikiem"));
        products.add(new Product("Smartwatch", "Zegarek z pomiarem tętna i GPS"));
        products.add(new Product("Głośnik", "Przenośny głośnik Bluetooth, wodoodporny"));
        products.add(new Product("Powerbank", "Powerbank 20000 mAh z szybkim ładowaniem"));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ProductAdapter(products, product ->
                Toast.makeText(Zadanie7Activity.this, product.getTitle(),
                        Toast.LENGTH_SHORT).show()));
    }
}
