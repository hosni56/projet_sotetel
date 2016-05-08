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
public class accueilagentcommercial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueilagentcommercial);
    }
    public void buttonGP (View View) {
        Button buttonGP =(Button) findViewById(R.id.buttonGP);
        buttonGP.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accueilagentcommercial.this, projet.class);
                startActivity(intent);
            }
        });

    }
    public void buttonVL1(View View) {
        Button buttonVL1 = (Button) findViewById(R.id.buttonVL1);
        buttonVL1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accueilagentcommercial.this, accueilemploye.class);
                startActivity(intent);
            }
        });

    }
    public void buttonD3 (View View) {
        Button buttonD3 =(Button) findViewById(R.id.buttonD3);
        buttonD3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accueilagentcommercial.this, authentification.class);
                Toast.makeText(getApplicationContext(), "Deconnexion effectué avec sucees", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });

    }

}