package com.example.adopt_tinder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Likes extends AppCompatActivity implements View.OnClickListener {

    ImageView imagen1, imagen2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likes);

        imagen1 = (ImageView) findViewById(R.id.imageV1);
        imagen2 = (ImageView) findViewById(R.id.imageV2);
        Picasso.get().load("https://images.dog.ceo//breeds//collie-border//n02106166_8037.jpg").into(imagen1);
        Picasso.get().load("https://images.dog.ceo/breeds/retriever-curly/n02099429_1377.jpg").into(imagen2);
        imagen1.setOnClickListener(this);
        imagen2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageV1:
                Toast.makeText(getApplicationContext(), "Se dirige al contacto", Toast.LENGTH_LONG).show();
                break;
            case R.id.imageV2:
                Toast.makeText(getApplicationContext(), "Se dirige al contacto", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
