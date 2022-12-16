package com.example.adopt_tinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bl,br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bl = (Button) findViewById(R.id.blogin);
        br = (Button) findViewById(R.id.bregis);

        bl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent op = new Intent(MainActivity.this,Login.class);
                startActivity(op);
            }
        });
        br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent op = new Intent(MainActivity.this,Register.class);
                startActivity(op);
            }
        });


    }
}