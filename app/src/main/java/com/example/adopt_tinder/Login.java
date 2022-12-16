package com.example.adopt_tinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Login extends AppCompatActivity{
    EditText tuser, tcontr;
    Button blog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tuser = (EditText) findViewById(R.id.tUs);
        tcontr = (EditText) findViewById(R.id.tPass);
        blog = (Button) findViewById(R.id.bingr);

        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputStreamReader arch = new InputStreamReader(openFileInput ("Usuarios.txt"));
                    BufferedReader br= new BufferedReader(arch);
                    String linea = br.readLine();
                    String id="";
                    while(linea != null) {
                        if(linea.contains(tuser.getText().toString())){
                            if(linea.contains(tcontr.getText().toString())){
                                String [] info1 = linea.split("");;
                                for (int i=0; i< info1.length;i++){
                                    if(info1[i]==" "){
                                        i= info1.length;
                                    }else{
                                        id=id+info1[i];
                                    }
                                }
                                Toast.makeText(getApplicationContext(),"Si se encuantra registrado", Toast.LENGTH_LONG).show();
                                //Intent intent = new Intent(Login.this,Cards.class);
                                //intent.putExtra("IdUser",id);
                                //startActivity(intent);
                            }
                        }
                        linea = br.readLine();
                    }
                    Toast.makeText(getApplicationContext(),"No se encuentra registrado", Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
