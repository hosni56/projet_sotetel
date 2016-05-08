package com.example.amin.gs2204;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Amin on 22/04/2016.
 */
public class accueilemploye extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueilemploye);
    }

    public void buttonLP(View View) {
        Button buttonLP = (Button) findViewById(R.id.buttonLP);
        buttonLP.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accueilemploye.this, listes.class);
                startActivity(intent);
            }
        });

    }
    public void buttonLO(View View) {
        Button buttonLO = (Button) findViewById(R.id.buttonLO);
        buttonLO.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accueilemploye.this, listes.class);
                startActivity(intent);
            }
        });

    }
    public void buttonLA(View View) {
        Button buttonLA = (Button) findViewById(R.id.buttonLA);
        buttonLA.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accueilemploye.this, listes.class);
                startActivity(intent);
            }
        });

    }
    public void buttonLT(View View) {
        Button buttonLT = (Button) findViewById(R.id.buttonLT);
        buttonLT.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accueilemploye.this, listes.class);
                startActivity(intent);
            }
        });

    }
    public void buttonD1 (View View) {
        Button buttonD1 =(Button) findViewById(R.id.buttonD1);
        buttonD1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accueilemploye.this, authentification.class);
                Toast.makeText(getApplicationContext(), "Deconnexion effectué avec sucees", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });

    }


}
