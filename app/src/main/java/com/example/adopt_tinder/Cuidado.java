package com.example.adopt_tinder;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Cuidado extends AppCompatActivity {

    private Spinner tipoR;
    String [] tipo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuidado);

        tipoR = (Spinner)findViewById(R.id.spinner);

        tipo = new String[]{"Seleccione tipo de tamaño", "Perro Grande", "Perro Mediano", "Perro Chico"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>( this, android.R.layout.simple_spinner_item, tipo);
        tipoR.setAdapter(adapter);


    }
}
