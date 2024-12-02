package com.example.appholaadios;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        findViewById(R.id.boton1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener el texto del EditText
                String userNameText = ((EditText) findViewById(R.id.entradaTextoNombre)).getText().toString();

                // Verificar si el texto no está vacío antes de enviar el Intent
                if (userNameText != null && !userNameText.isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, ByeActivity.class);
                    intent.putExtra("NOMBRE", userNameText); // Pasar el texto como extra
                    startActivity(intent);
                } else {
                    // Si el nombre está vacío, no se hace nada o se puede mostrar un mensaje
                    //findViewById(R.id.textoFallo).
                    TextView textoAdios = findViewById(R.id.textoFallo);

                    textoAdios.setText("No has introducido un nombre valido");
                }
            }
        });
    }
}
