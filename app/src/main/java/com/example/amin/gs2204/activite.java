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
public class activite extends Activity {

    private EditText txtdatedeb_A, txtdatefin_A;

    final Calendar g = Calendar.getInstance();
    final Calendar h = Calendar.getInstance();
    Spinner spinner4;
    ArrayAdapter<CharSequence> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activite);
        initializeView();
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        adapter = ArrayAdapter.createFromResource(this, R.array.Responsable_A, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter);
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        txtdatedeb_A = (EditText) findViewById(R.id.editText16);
        txtdatefin_A = (EditText) findViewById(R.id.editText17);

        setCurrentDateOnView();
        setCurrentDateOnView2();
    }


    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            g.set(Calendar.YEAR, year);
            g.set(Calendar.MONTH, monthOfYear);
            g.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setCurrentDateOnView();
        }

    };
    // date fin p
    DatePickerDialog.OnDateSetListener datef = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            h.set(Calendar.YEAR, year);
            h.set(Calendar.MONTH, monthOfYear);
            h.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setCurrentDateOnView2();
        }

    };

    public void dateOnClick(View view) {
        new DatePickerDialog(activite.this, date,
                g.get(Calendar.YEAR), g.get(Calendar.MONTH), g.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void dateOnClick2(View view) {
        new DatePickerDialog(activite.this, datef,
                h.get(Calendar.YEAR), h.get(Calendar.MONTH), h.get(Calendar.DAY_OF_MONTH)).show();
    }


    private void setCurrentDateOnView() {
        String dateFormat = "MM-dd_yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);
        txtdatedeb_A.setText(sdf.format(g.getTime()));
    }

    private void setCurrentDateOnView2() {
        String dateFormat = "MM-dd_yyyy";
        SimpleDateFormat sdff = new SimpleDateFormat(dateFormat, Locale.US);
        txtdatefin_A.setText(sdff.format(h.getTime()));


    }

    public void busaveA(View View) {

        EditText txtNom_A = (EditText) findViewById(R.id.editText14);
        EditText txtID_A = (EditText) findViewById(R.id.editText15);

        EditText txtdatedeb_A = (EditText) findViewById(R.id.editText16);
        EditText txtdatefin_A = (EditText) findViewById(R.id.editText17);
        spinner4 = (Spinner) findViewById(R.id.spinner4);

        ListView ls = (ListView) findViewById(R.id.listView);
        DBConnections db = new DBConnections(this);
        db.InsertA(txtNom_A.getText().toString(), txtdatedeb_A.getText().toString(), txtdatefin_A.getText().toString(), spinner4.getSelectedItem().toString());

        ArrayList<String> arrlist = db.getAllrecordA();
        ls.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrlist));
        txtNom_A.setText("");
        txtID_A.setText("");

    }

    // delete projet
    public void budeleteA(View View) {
        EditText txtNom_A = (EditText) findViewById(R.id.editText14);
        EditText txtID_A = (EditText) findViewById(R.id.editText15);

        EditText txtdatedeb_A = (EditText) findViewById(R.id.editText16);
        EditText txtdatefin_A = (EditText) findViewById(R.id.editText17);
        spinner4 = (Spinner) findViewById(R.id.spinner4);


        ListView ls = (ListView) findViewById(R.id.listView);
        DBConnections db = new DBConnections(this);
        db.deleteA(Integer.parseInt(txtID_A.getText().toString()));

        ArrayList<String> arrlist = db.getAllrecordA();
        ls.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrlist));
        txtNom_A.setText("");

        txtdatedeb_A.setText("");
        txtdatefin_A.setText("");

    }

    // update projet
    public void buupdateA(View View) {

        EditText txtNom_A = (EditText) findViewById(R.id.editText14);
        EditText txtID_A = (EditText) findViewById(R.id.editText15);

        EditText txtdatedeb_A = (EditText) findViewById(R.id.editText16);
        EditText txtdatefin_A = (EditText) findViewById(R.id.editText17);
        spinner4 = (Spinner) findViewById(R.id.spinner4);

        ListView ls = (ListView) findViewById(R.id.listView);
        DBConnections db = new DBConnections(this);
        db.updateA(txtNom_A.getText().toString(), txtdatedeb_A.getText().toString(), txtdatefin_A.getText().toString(), spinner4.getSelectedItem().toString(), Integer.parseInt(txtID_A.getText().toString()));

        ArrayList<String> arrlist = db.getAllrecordA();
        ls.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrlist));
        txtNom_A.setText("");

        txtdatedeb_A.setText("");
        txtdatefin_A.setText("");
    }
}
