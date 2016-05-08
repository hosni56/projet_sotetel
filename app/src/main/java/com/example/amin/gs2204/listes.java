package com.example.amin.gs2204;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Amin on 22/04/2016.
 */
public class listes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listes);

    }
    public void ListProjet(View View) {

        ListView ls = (ListView) findViewById(R.id.listView);
        DBConnections db = new DBConnections(this);
        ArrayList<String> arrlist = db.getAllrecordP();
        ls.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrlist));

    }

    public void ListOperation (View View){
        ListView ls=(ListView)findViewById(R.id.listView);
        DBConnections db= new DBConnections(this);
        ArrayList<String> arrlist =db.getAllrecordO();
        ls.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrlist));

    }
    public void ListActivite (View View){
        ListView ls=(ListView)findViewById(R.id.listView);
        DBConnections db= new DBConnections(this);
        ArrayList<String> arrlist =db.getAllrecordA();
        ls.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1 , arrlist));

    }
    public void ListTache (View View){
        ListView ls=(ListView)findViewById(R.id.listView);
        DBConnections db= new DBConnections(this);
        ArrayList<String> arrlist =db.getAllrecordT();
        ls.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1 , arrlist));

    }
}