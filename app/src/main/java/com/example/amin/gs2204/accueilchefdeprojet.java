package com.example.amin.gs2204;

/**
 * Created by Amin on 24/04/2016.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Amin on 15/04/2016.
 */
public class accueilchefdeprojet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueilchefdeprojet);
    }
    public void buttonGO (View View) {
        Button buttonGO =(Button) findViewById(R.id.buttonGO);
        buttonGO.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accueilchefdeprojet.this, operation.class);
                startActivity(intent);
            }
        });

    }
    public void buttonGA (View View) {
        Button buttonGA =(Button) findViewById(R.id.buttonGA);
        buttonGA.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accueilchefdeprojet.this, activite.class);
                startActivity(intent);
            }
        });

    }
    public void buttonGT (View View) {
        Button buttonGT =(Button) findViewById(R.id.buttonGT);
        buttonGT.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accueilchefdeprojet.this, tache.class);
                startActivity(intent);
            }
        });

    }
    public void buttonVL2(View View) {
        Button buttonVL2 = (Button) findViewById(R.id.buttonVL2);
        buttonVL2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accueilchefdeprojet.this, accueilemploye.class);
                startActivity(intent);
            }
        });

    }
    public void buttonD2 (View View) {
        Button buttonD2 =(Button) findViewById(R.id.buttonD2);
        buttonD2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accueilchefdeprojet.this, authentification.class);
                Toast.makeText(getApplicationContext(), "Deconnexion effectué avec sucees", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });

    }
}