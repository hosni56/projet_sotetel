package com.example.amin.gs2204;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Amin on 14/04/2016.
 */
public class employe extends Activity {



    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employe);

        spinner = (Spinner) findViewById(R.id.spinner);
        adapter= ArrayAdapter.createFromResource(this,R.array.Role,android.R.layout.simple_spinner_item);
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
// insertion employe

    public  void busaveE (View View){

        EditText txtname=(EditText)findViewById(R.id.editText1);
        spinner = (Spinner) findViewById(R.id.spinner);
        EditText txtnomut=(EditText)findViewById(R.id.editTextnomut);
        EditText txtmotdepasse=(EditText)findViewById(R.id.editText4);

        ListView ls=(ListView)findViewById(R.id.listView);
        DBConnections db= new DBConnections(this);
        db.InsertE(txtname.getText().toString(),txtnomut.getText().toString(), Integer.parseInt(txtmotdepasse.getText().toString()), spinner.getSelectedItem().toString());


        ArrayList<String> arrlist =db.getAllrecord();
        ls.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrlist));
        txtname.setText("");
        txtnomut.setText("");
        txtmotdepasse.setText("");


    }
    // delete employe
    public  void budeleteE (View View){

        EditText txtname=(EditText)findViewById(R.id.editText1);
        EditText txtid=(EditText)findViewById(R.id.editText2);
        EditText txtnomut=(EditText)findViewById(R.id.editTextnomut);
        EditText txtmotdepasse=(EditText)findViewById(R.id.editText4);



        ListView ls=(ListView)findViewById(R.id.listView);
        DBConnections db= new DBConnections(this);
        db.deleteE(Integer.parseInt(txtid.getText().toString()));

        ArrayList<String> arrlist =db.getAllrecord();
        ls.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrlist));
        txtname.setText("");
        txtnomut.setText("");
        txtmotdepasse.setText("");
    }

    // update employe


    public  void buupdateE (View View){

        EditText txtname=(EditText)findViewById(R.id.editText1);
        EditText txtid=(EditText)findViewById(R.id.editText2);
        spinner = (Spinner) findViewById(R.id.spinner);
        EditText txtnomut=(EditText)findViewById(R.id.editTextnomut);
        EditText txtmotdepasse=(EditText)findViewById(R.id.editText4);


        ListView ls=(ListView)findViewById(R.id.listView);
        DBConnections db= new DBConnections(this);
        db.updateE(txtname.getText().toString(),txtnomut.getText().toString(), Integer.parseInt(txtmotdepasse.getText().toString()), spinner.getSelectedItem().toString(), Integer.parseInt(txtid.getText().toString()));

        ArrayList<String> arrlist =db.getAllrecord();
        ls.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrlist));
        txtname.setText("");
        txtnomut.setText("");
        txtmotdepasse.setText("");
    }

}