package com.example.amin.gs2204;

/**
 * Created by Amin on 24/04/2016.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Amin on 15/04/2016.
 */
public class acceuilagentadministratif extends AppCompatActivity {

    EditText txtmotdepasse;
    EditText txtnomutilisateur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueilagentadministratif);
    }

    public void buttonGE(View View) {
        Button buttonGE = (Button) findViewById(R.id.buttonGE);
        buttonGE.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(acceuilagentadministratif.this, employe.class);
                startActivity(intent);
            }
        });

    }

    public void buttonVL(View View) {
        Button buttonVL = (Button) findViewById(R.id.buttonVL);
        buttonVL.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(acceuilagentadministratif.this, accueilemploye.class);
                startActivity(intent);
            }
        });

    }
    public void buttonD4 (View View) {
        Button buttonD4 =(Button) findViewById(R.id.buttonD4);
        buttonD4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(acceuilagentadministratif.this, authentification.class);
                Toast.makeText(getApplicationContext(), "Deconnexion effectué avec sucees", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });

    }
}