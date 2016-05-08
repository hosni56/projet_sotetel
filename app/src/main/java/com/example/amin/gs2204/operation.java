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
public class operation extends Activity {

    private EditText txtdatedeb_O,txtdatefin_O;

    final Calendar e = Calendar.getInstance();
    final Calendar f = Calendar.getInstance();
    Spinner spinner3;
    ArrayAdapter<CharSequence> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.operation);
        initializeView();
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        adapter= ArrayAdapter.createFromResource(this,R.array.Responsable_O,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        txtdatedeb_O = (EditText) findViewById(R.id.editText12);
        txtdatefin_O = (EditText) findViewById(R.id.editText13);

        setCurrentDateOnView();
        setCurrentDateOnView2();
    }


    DatePickerDialog.OnDateSetListener date= new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            e.set(Calendar.YEAR, year);
            e.set(Calendar.MONTH, monthOfYear);
            e.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setCurrentDateOnView();
        }

    };
    // date fin p
    DatePickerDialog.OnDateSetListener datef= new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            f.set(Calendar.YEAR, year);
            f.set(Calendar.MONTH, monthOfYear);
            f.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setCurrentDateOnView2();
        }

    };

    public void dateOnClick (View view) {
        new DatePickerDialog(operation.this, date,
                e.get(Calendar.YEAR), e.get(Calendar.MONTH), e.get(Calendar.DAY_OF_MONTH)).show();
    }
    public void dateOnClick2 (View view) {
        new DatePickerDialog( operation.this, datef,
                f.get(Calendar.YEAR),f.get(Calendar.MONTH),f.get(Calendar.DAY_OF_MONTH)).show();
    }


    private void setCurrentDateOnView () {
        String dateFormat = "MM-dd_yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);
        txtdatedeb_O.setText(sdf.format(e.getTime()));
    }
    private void setCurrentDateOnView2 () {
        String dateFormat="MM-dd_yyyy";
        SimpleDateFormat sdff= new SimpleDateFormat( dateFormat, Locale.US);
        txtdatefin_O.setText(sdff.format(f.getTime()));


    }
    public  void busaveO (View View){

        EditText txtNom_O=(EditText)findViewById(R.id.editText10);
        EditText txtID_O=(EditText)findViewById(R.id.editText11);

        EditText txtdatedeb_O=(EditText)findViewById(R.id.editText12);
        EditText txtdatefin_O=(EditText)findViewById(R.id.editText13);
        spinner3 = (Spinner) findViewById(R.id.spinner3);

        ListView ls=(ListView)findViewById(R.id.listView);
        DBConnections db= new DBConnections(this);
        db.InsertO(txtNom_O.getText().toString(), txtdatedeb_O.getText().toString(), txtdatefin_O.getText().toString(), spinner3.getSelectedItem().toString());

        ArrayList<String> arrlist =db.getAllrecordO();
        ls.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrlist));
        txtNom_O.setText("");
        txtID_O.setText("");

    }
    // delete projet
    public  void budeleteO (View View){
        EditText txtNom_O=(EditText)findViewById(R.id.editText10);
        EditText txtID_O=(EditText)findViewById(R.id.editText11);

        EditText txtdatedeb_O=(EditText)findViewById(R.id.editText12);
        EditText txtdatefin_O=(EditText)findViewById(R.id.editText13);
        spinner3 = (Spinner) findViewById(R.id.spinner3);


        ListView ls=(ListView)findViewById(R.id.listView);
        DBConnections db= new DBConnections(this);
        db.deleteO(Integer.parseInt(txtID_O.getText().toString()));

        ArrayList<String> arrlist =db.getAllrecordO();
        ls.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrlist));
        txtNom_O.setText("");

        txtdatedeb_O.setText("");
        txtdatefin_O.setText("");

    }
    // update projet
    public  void buupdateO (View View){

        EditText txtNom_O=(EditText)findViewById(R.id.editText10);
        EditText txtID_O=(EditText)findViewById(R.id.editText11);

        EditText txtdatedeb_O=(EditText)findViewById(R.id.editText12);
        EditText txtdatefin_O=(EditText)findViewById(R.id.editText13);
        spinner3 = (Spinner) findViewById(R.id.spinner3);

        ListView ls=(ListView)findViewById(R.id.listView);
        DBConnections db= new DBConnections(this);
        db.updateO(txtNom_O.getText().toString(), txtdatedeb_O.getText().toString(), txtdatefin_O.getText().toString(), spinner3.getSelectedItem().toString(), Integer.parseInt(txtID_O.getText().toString()));

        ArrayList<String> arrlist =db.getAllrecordO();
        ls.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrlist));
        txtNom_O.setText("");

        txtdatedeb_O.setText("");
        txtdatefin_O.setText("");
    }
   }
