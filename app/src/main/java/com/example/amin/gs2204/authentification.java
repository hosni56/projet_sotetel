package com.example.amin.gs2204;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class authentification extends AppCompatActivity {

    DBConnections loginDataBaseAdapter;
    EditText txtnomutilisateur, txtmotdepasse;
    String var1,var2;
    Button btnConnexion;
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authentification);
        // create a instance of SQLite Database
        loginDataBaseAdapter = new DBConnections(this);
        // Get The Refference Of Buttons
        btnConnexion = (Button) findViewById(R.id.btnConnexion);


        // Set OnClick Listener

        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.Role, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void connexion(View View) {
        // get the Refferences of views
        final EditText txtnomutilisateur = (EditText) findViewById(R.id.editTextnomutilisateur);
        final EditText txtmotdepasse = (EditText) findViewById(R.id.editTextmotdepasse);
        spinner = (Spinner) findViewById(R.id.spinner);

        // Set On ClickListener

        btnConnexion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // get The User name and Passwo
                String nomutilisateur = txtnomutilisateur.getText().toString();
                String motdepasse = txtmotdepasse.getText().toString();
               String var1 = spinner.getSelectedItem().toString();

                // fetch the Password form database for respective user name
                String storedPassword = loginDataBaseAdapter.getSinlgeEntry(nomutilisateur,var1);

              //  Spinner= loginDataBaseAdapter.getSinlgeEntry(nomutilisateur);

                if (txtnomutilisateur.getText().toString().equals("abc") && txtmotdepasse.getText().toString().equals("123")) {

                    Toast.makeText(getApplicationContext(), "connexion en cours...", Toast.LENGTH_SHORT).show();
                    Intent intentadmin = new Intent(authentification.this, acceuilagentadministratif.class);
                    startActivity(intentadmin);
                } else {
                    Toast.makeText(authentification.this, "probleme de connexion ", Toast.LENGTH_LONG).show();
                    // check if the Stored password matches with  Password entered by user
                }



                if (motdepasse.equals(storedPassword)) {
                    Toast.makeText(authentification.this, "connexion réussie", Toast.LENGTH_LONG).show();


                    String var2 =var1;
                    switch (var2){
                        case "Employe":
                            Toast.makeText(getApplicationContext(), "connexion en cours employe...", Toast.LENGTH_SHORT).show();
                            Intent intentadmin = new Intent(authentification.this, accueilemploye.class);
                            startActivity(intentadmin);
                            break;
                        case "Agent commercial":
                            Toast.makeText(getApplicationContext(), "connexion en cours commercial...", Toast.LENGTH_SHORT).show();
                            Intent intentcom = new Intent(authentification.this, accueilagentcommercial.class);
                            startActivity(intentcom);
                            break;
                        case "Chef de projet":
                            Toast.makeText(getApplicationContext(), "connexion en cours chef...", Toast.LENGTH_SHORT).show();
                            Intent intentchef = new Intent(authentification.this, accueilchefdeprojet.class);
                            startActivity(intentchef);
                            break;
                        case "Directeur general":
                            Toast.makeText(getApplicationContext(), "connexion en cours directeur general...", Toast.LENGTH_SHORT).show();
                            Intent intentdg = new Intent(authentification.this, accueilemploye.class);
                            startActivity(intentdg);
                            break;
                        case "Responsable operation":
                            Toast.makeText(getApplicationContext(), "connexion en cours responsable opération...", Toast.LENGTH_SHORT).show();
                            Intent intentro = new Intent(authentification.this, accueilemploye.class);
                            startActivity(intentro);
                            break;
                        case "Responsable activite":
                            Toast.makeText(getApplicationContext(), "connexion en cours responsable activite...", Toast.LENGTH_SHORT).show();
                            Intent intentrac = new Intent(authentification.this, accueilemploye.class);
                            startActivity(intentrac);
                            break;
                        case "Technicien":
                            Toast.makeText(getApplicationContext(), "connexion en cours technicien...", Toast.LENGTH_SHORT).show();
                            Intent intentT = new Intent(authentification.this, accueilemploye.class);
                            startActivity(intentT);
                            break;
                    }


                    // if var1 ; if var 2 ; if var 3 ;


                } else {
                    Toast.makeText(authentification.this, "nom utilisateur et mot de passe incorrecte", Toast.LENGTH_LONG).show();
                }












                /*

                  if ((motdepasse.equals(storedPassword)) && (spinner.getSelectedItem().equals("Employe"))) {
                    Toast.makeText(authentification.this, "Connexion effectué", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(authentification.this, accueilemploye.class);
                    startActivity(intent);
                  } else {
                    Toast.makeText(authentification.this, "probleme de connexion 2", Toast.LENGTH_LONG).show();
                  }

                  if ((motdepasse.equals(storedPassword)) && (spinner.getSelectedItem().equals("Agent commercial"))) {
                    Toast.makeText(authentification.this, "Connexion effectué", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(authentification.this, accueilagentcommercial.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(authentification.this, "probleme de connexion 3", Toast.LENGTH_LONG).show();
                }

                  if ((motdepasse.equals(storedPassword)) && (spinner.getSelectedItem().equals("Chef de projet"))) {
                      Toast.makeText(authentification.this, "Connexion effectué", Toast.LENGTH_LONG).show();
                      Intent intent = new Intent(authentification.this, accueilchefdeprojet.class);
                      startActivity(intent);

                  }else {
                      Toast.makeText(authentification.this, "probleme de connexion 4", Toast.LENGTH_LONG).show();
                  }
                */
                }

        });
    }
}









