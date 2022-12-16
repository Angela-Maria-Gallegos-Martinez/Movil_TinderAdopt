package com.example.adopt_tinder;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Cards extends AppCompatActivity implements View.OnClickListener{

    TextView datos;
    ImageView imagen;
    FloatingActionButton dislike, like, cuidado, inicio, likes;
    int cont=0;
    String idU;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        //Bundle bundle = this.getIntent().getExtras();
        //idU = bundle.getString("IdUser");

        datos = (TextView) findViewById(R.id.tdatos);
        imagen = (ImageView) findViewById(R.id.ifoto);
        dislike = (FloatingActionButton) findViewById(R.id.skip_button);
        like = (FloatingActionButton) findViewById(R.id.like_button);
        cuidado = (FloatingActionButton) findViewById(R.id.bcui);
        inicio = (FloatingActionButton) findViewById(R.id.bini);
        likes = (FloatingActionButton) findViewById(R.id.blike);
        IMAGENE5(0);
        dislike.setOnClickListener(this);
        like.setOnClickListener(this);
        cuidado.setOnClickListener(this);
        inicio.setOnClickListener(this);
        likes.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.skip_button:
                cont++;
                try {
                    OutputStreamWriter arch = new OutputStreamWriter(openFileOutput("Dislike.txt", Context.MODE_APPEND));

                    String dato = String.valueOf(3)+" "+String.valueOf(cont)+"\n";

                    arch.write(dato);
                    arch.close();
                    Toast.makeText(getApplicationContext(), "Se registro exitosamente", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                IMAGENE5(cont);
                break;
            case R.id.like_button:
                cont++;
                try {
                    OutputStreamWriter arch = new OutputStreamWriter(openFileOutput("Like.txt", Context.MODE_APPEND));

                    String dato = String.valueOf(3)+" "+String.valueOf(cont)+"\n";

                    arch.write(dato);
                    arch.close();
                    Toast.makeText(getApplicationContext(), "Se registro exitosamente", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                IMAGENE5(cont);
                break;
            case R.id.bcui:
                Intent op = new Intent(Cards.this,Cuidado.class);
                startActivity(op);
                break;
            case R.id.bini:
                Intent op2 = new Intent(Cards.this,Cards.class);
                startActivity(op2);
                break;
            case R.id.blike:
                Intent op3 = new Intent(Cards.this,Likes.class);
                startActivity(op3);
                break;
        }
    }

    /*private void leerWS(){
        String url = "https://dog.ceo/api/breeds/image/random";
        StringRequest postResquest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject resp = new JSONObject(response);
                    Picasso.get().load(resp.getString("massage")).into(imagen);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", error.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(postResquest);
        //stringRequest.setShouldCache(false);
        //queue.add(stringRequest);
    }*/

    int IMAGENES(String id) throws IOException {
        int band=0;
        String url="",raza="",ed="";
        InputStreamReader arch = new InputStreamReader(openFileInput ("\\\\ta2\\COMPARTIDA\\Mascotas.txt"));
        BufferedReader br= new BufferedReader(arch);
        String linea = br.readLine();
        while(linea != null) {
            if (linea.contains(id)){
                String [] info = linea.split("");;
                for (int i=0; i< info.length;i++){
                    if(info[i]==" "){
                        band++;
                    }
                    if(band==1){
                        raza=raza+info[i];
                    }else if(band==2){
                        ed=ed+info[i];
                    }else if(band==3){
                        ed=ed+info[i];
                    }
                }
            }
            cont++;
            linea = br.readLine();
        }
        return cont;
    }

























    private void IMAGENE5(int num){
        String [] url = new String []{"https://images.dog.ceo//breeds//collie-border//n02106166_8037.jpg","https://images.dog.ceo//breeds//weimaraner//n02092339_821.jpg","https://images.dog.ceo/breeds/springer-english/n02102040_2036.jpg","https://images.dog.ceo/breeds/retriever-curly/n02099429_1377.jpg","https://images.dog.ceo/breeds/buhund-norwegian/hakon3.jpg"};
        String [] dat = new String []{"Raza: collie border"+"\n"+"Edad: 3 años","Raza: weimaraner"+"\n"+"Edad: 6 años","Raza: springer english"+"\n"+"Edad: 10 años","Raza: retriever curly"+"\n"+"Edad: 6 años","Raza: buhund norwegian"+"\n"+"Edad: 4 años"};
        Picasso.get().load(url[num]).into(imagen);
        datos.setText(dat[num]);
    }
}
