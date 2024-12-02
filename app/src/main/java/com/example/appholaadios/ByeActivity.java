package com.example.appholaadios;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ByeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantallabye); // Correcto


        // Obtener el valor del Intent con la clave "NOMBRE"
        String nombre = getIntent().getStringExtra("NOMBRE");

        TextView textoAdios = findViewById(R.id.textoAdios);

        // Verificar si el nombre está vacío o es nulo
        if (nombre != null && !nombre.isEmpty()) {
            textoAdios.setText("Adios " + nombre);
        } else {
            textoAdios.setText("Adios Sin Nombre");
        }

        findViewById(R.id.botonAdios).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(ByeActivity.this, MainActivity.class);

                startActivity(intent);
            }
        });
    }
}

