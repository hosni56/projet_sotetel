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
 * Created by Amin on 13/04/2016.
 */
public class projet extends Activity {

    private EditText txtdatedeb_P,txtdatefin_P;

    final Calendar c = Calendar.getInstance();
    final Calendar d = Calendar.getInstance();
    Spinner spinner2;
    ArrayAdapter<CharSequence> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.projet);
        initializeView();
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        adapter= ArrayAdapter.createFromResource(this,R.array.Responsable_P,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void initializeView() {

        txtdatedeb_P = (EditText) findViewById(R.id.editText8);
        txtdatefin_P = (EditText) findViewById(R.id.editText9);

        setCurrentDateOnView();
        setCurrentDateOnView2();
    }


    DatePickerDialog.OnDateSetListener date= new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, monthOfYear);
            c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setCurrentDateOnView();
        }

    };
    // date fin p
    DatePickerDialog.OnDateSetListener datef= new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            d.set(Calendar.YEAR, year);
            d.set(Calendar.MONTH, monthOfYear);
            d.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setCurrentDateOnView2();
        }

    };

    public void dateOnClick (View view) {
        new DatePickerDialog(projet.this, date,
                c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
    }
    public void dateOnClick2 (View view) {
        new DatePickerDialog( projet.this, datef,
                d.get(Calendar.YEAR),d.get(Calendar.MONTH),d.get(Calendar.DAY_OF_MONTH)).show();
    }


    private void setCurrentDateOnView () {
        String dateFormat = "MM-dd_yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);
        txtdatedeb_P.setText(sdf.format(c.getTime()));
    }
    private void setCurrentDateOnView2 () {
        String dateFormat="MM-dd_yyyy";
        SimpleDateFormat sdff= new SimpleDateFormat( dateFormat, Locale.US);
        txtdatefin_P.setText(sdff.format(d.getTime()));


    }
    public  void busaveP (View View){

        EditText txtNom_P=(EditText)findViewById(R.id.editText5);
        EditText txtID_P=(EditText)findViewById(R.id.editText6);
        EditText txtmontant_P=(EditText)findViewById(R.id.editText7);
        EditText txtdatedeb_P=(EditText)findViewById(R.id.editText8);
        EditText txtdatefin_P=(EditText)findViewById(R.id.editText9);
        spinner2 = (Spinner) findViewById(R.id.spinner2);

        ListView ls=(ListView)findViewById(R.id.listView);
        DBConnections db= new DBConnections(this);
        db.InsertP(txtNom_P.getText().toString(), Integer.parseInt(txtmontant_P.getText().toString()), txtdatedeb_P.getText().toString(), txtdatefin_P.getText().toString(), spinner2.getSelectedItem().toString());

        ArrayList<String> arrlist =db.getAllrecordP();
        ls.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrlist));
        txtNom_P.setText("");
        txtID_P.setText("");
        txtmontant_P.setText("");

    }
    // delete projet
    public  void budeleteP (View View){
        EditText txtNom_P=(EditText)findViewById(R.id.editText5);
        EditText txtID_P=(EditText)findViewById(R.id.editText6);
        EditText txtmontant_P=(EditText)findViewById(R.id.editText7);
        EditText txtdatedeb_P=(EditText)findViewById(R.id.editText8);
        EditText txtdatefin_P=(EditText)findViewById(R.id.editText9);
        spinner2 = (Spinner) findViewById(R.id.spinner2);


        ListView ls=(ListView)findViewById(R.id.listView);
        DBConnections db= new DBConnections(this);
        db.deleteP(Integer.parseInt(txtID_P.getText().toString()));

        ArrayList<String> arrlist =db.getAllrecordP();
        ls.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrlist));
        txtNom_P.setText("");
        txtmontant_P.setText("");
        txtdatedeb_P.setText("");
        txtdatefin_P.setText("");

    }
    // update projet
    public  void buupdateP (View View){

        EditText txtNom_P=(EditText)findViewById(R.id.editText5);
        EditText txtID_P=(EditText)findViewById(R.id.editText6);
        EditText txtmontant_P=(EditText)findViewById(R.id.editText7);
        EditText txtdatedeb_P=(EditText)findViewById(R.id.editText8);
        EditText txtdatefin_P=(EditText)findViewById(R.id.editText9);
        spinner2 = (Spinner) findViewById(R.id.spinner2);

        ListView ls=(ListView)findViewById(R.id.listView);
        DBConnections db= new DBConnections(this);
        db.updateP(txtNom_P.getText().toString(), Integer.parseInt(txtmontant_P.getText().toString()), txtdatedeb_P.getText().toString(), txtdatefin_P.getText().toString(), spinner2.getSelectedItem().toString(), Integer.parseInt(txtID_P.getText().toString()));

        ArrayList<String> arrlist =db.getAllrecordP();
        ls.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrlist));
        txtNom_P.setText("");
        txtmontant_P.setText("");
        txtdatedeb_P.setText("");
        txtdatefin_P.setText("");
    }


}
