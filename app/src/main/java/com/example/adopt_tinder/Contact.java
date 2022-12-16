package com.example.adopt_tinder;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Contact extends AppCompatActivity {

    TextView nombre, correo, numero, ubicacion;
    ImageView perfil;
    String id,nom="",cor="",num="",ubi="";
    int band=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        //Bundle bundle = this.getIntent().getExtras();
        //id = bundle.getString("IdUM");
        perfil = (ImageView) findViewById(R.id.imageView7);
        nombre = (TextView) findViewById(R.id.tnombre);
        correo = (TextView) findViewById(R.id.tcorreo);
        numero = (TextView) findViewById(R.id.tnumero);
        ubicacion = (TextView) findViewById(R.id.tubicacion);

        try {
            InputStreamReader arch = new InputStreamReader(openFileInput ("\\\\ta2\\COMPARTIDA\\Usuarios.txt"));
            BufferedReader br= new BufferedReader(arch);
            String linea = br.readLine();
            while(linea != null) {
                if(linea.contains(id)){
                    String [] info = linea.split("");;
                    for (int i=0; i< info.length;i++){
                        if(info[i]==" "){
                            band++;
                        }
                        if(band==1){
                            nom=nom+info[i];
                        }else if(band==3){
                            cor=cor+info[i];
                        }else if(band==4){
                            num=num+info[i];
                        }else if(band==5){
                            ubi=ubi+info[i];
                            i= info.length;
                        }
                    }
                }
                linea = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        nombre.setText("Sergio");
        correo.setText("ser23@yahoo.com");
        numero.setText("44914664328");
        ubicacion.setText("Av Pensadores Mexicanos");
        Picasso.get().load("https://images.unsplash.com/photo-1564564321837-a57b7070ac4f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTZ8fGFyYWIlMjBtYW58ZW58MHx8MHx8&w=1000&q=80").into(perfil);
    }
}
