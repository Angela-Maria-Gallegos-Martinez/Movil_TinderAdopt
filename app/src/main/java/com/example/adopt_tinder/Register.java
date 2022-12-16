package com.example.adopt_tinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Register extends AppCompatActivity {
    EditText tuser, tcontr, tcorr, tcel, tubi;
    Button breg;
    int id, band=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tuser = (EditText) findViewById(R.id.tName);
        tcontr = (EditText) findViewById(R.id.tPas);
        tcorr = (EditText) findViewById(R.id.tEmail);
        tcel = (EditText) findViewById(R.id.tNum);
        tubi = (EditText) findViewById(R.id.tUbic);
        breg = (Button) findViewById(R.id.breg);

        breg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tuser.getText().toString() == "")
                    Toast.makeText(getApplicationContext(), "No ingreso nombre de Usuario", Toast.LENGTH_LONG).show();
                else if (tcontr.getText().toString() == "")
                    Toast.makeText(getApplicationContext(), "No ingreso Contraseña", Toast.LENGTH_LONG).show();
                else if (tcorr.getText().toString() == "")
                    Toast.makeText(getApplicationContext(), "No ingreso Correo", Toast.LENGTH_LONG).show();
                else if (tcel.getText().toString() == "")
                    Toast.makeText(getApplicationContext(), "No ingreso Telefono", Toast.LENGTH_LONG).show();
                else if (tubi.getText().toString() == "")
                    Toast.makeText(getApplicationContext(), "No ingreso Ubicacion", Toast.LENGTH_LONG).show();
                else{
                    try {
                        InputStreamReader arch = new InputStreamReader(openFileInput ("Usuarios.txt"));
                        BufferedReader br= new BufferedReader(arch);
                        String linea = br.readLine();
                        while(linea != null) {
                            if(linea.contains(tuser.getText().toString())){
                                    Toast.makeText(getApplicationContext(),"Ya existe ese nombre de usuario", Toast.LENGTH_LONG).show();
                                    band=1;
                            }else {
                                REGISTR0();
                                band=1;
                                break;
                            }
                            linea = br.readLine();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(band==0)
                    REGISTR0();
            }
        });
    }

    void REGISTRO() {
        try {
            OutputStreamWriter arch = new OutputStreamWriter(openFileOutput("\\\\ta2\\COMPARTIDA\\Usuarios.txt", Context.MODE_APPEND));
            id = numeroId();

            String dato = String.valueOf(id) +" "+ tuser.getText().toString().replaceAll(" ", "_") +" "+ tcontr.getText().toString().replaceAll(" ", "_")
                    +" "+ tcorr.getText().toString() +" "+ tcel.getText().toString() +" "+ tubi.getText().toString().replaceAll(" ", "_")+"\n";

            arch.write(dato);
            arch.close();
            Toast.makeText(getApplicationContext(), "Se registro exitosamente", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int numeroId() throws IOException {
        int cont=1;
        InputStreamReader arch = new InputStreamReader(openFileInput ("Usuarios.txt"));
        BufferedReader br= new BufferedReader(arch);
        String linea = br.readLine();
        if (linea==null){
            return cont;
        }
        while(linea != null) {
            cont++;
            linea = br.readLine();
        }
        return cont;
    }























    void REGISTR0() {
        try {
            OutputStreamWriter arch = new OutputStreamWriter(openFileOutput("Usuarios.txt", Context.MODE_APPEND));
            id = numeroId();

            String dato = String.valueOf(id) +" "+ tuser.getText().toString().replaceAll(" ", "_") +" "+ tcontr.getText().toString().replaceAll(" ", "_")
                    +" "+ tcorr.getText().toString() +" "+ tcel.getText().toString() +" "+ tubi.getText().toString().replaceAll(" ", "_")+"\n";

            arch.write(dato);
            arch.close();
            Toast.makeText(getApplicationContext(), "Se registro exitosamente", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


