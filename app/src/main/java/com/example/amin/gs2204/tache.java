package com.example.amin.gs2204;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
public class tache extends Activity {

    private EditText txtdatedeb_T,txtdatefin_T;

    final Calendar i = Calendar.getInstance();
    final Calendar j = Calendar.getInstance();
    Spinner spinner5;
    ArrayAdapter<CharSequence> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tache);
        initializeView();
        spinner5 = (Spinner) findViewById(R.id.spinner5);
        adapter= ArrayAdapter.createFromResource(this,R.array.Responsable_T,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter);
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        txtdatedeb_T = (EditText) findViewById(R.id.editText20);
        txtdatefin_T = (EditText) findViewById(R.id.editText21);

        setCurrentDateOnView();
        setCurrentDateOnView2();
    }


    DatePickerDialog.OnDateSetListener date= new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            i.set(Calendar.YEAR, year);
            i.set(Calendar.MONTH, monthOfYear);
            i.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setCurrentDateOnView();
        }

    };
    // date fin p
    DatePickerDialog.OnDateSetListener datef= new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            j.set(Calendar.YEAR, year);
            j.set(Calendar.MONTH, monthOfYear);
            j.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setCurrentDateOnView2();
        }

    };

    public void dateOnClick (View view) {
        new DatePickerDialog(tache.this, date,
                i.get(Calendar.YEAR), i.get(Calendar.MONTH), i.get(Calendar.DAY_OF_MONTH)).show();
    }
    public void dateOnClick2 (View view) {
        new DatePickerDialog( tache.this, datef,
                j.get(Calendar.YEAR),j.get(Calendar.MONTH),j.get(Calendar.DAY_OF_MONTH)).show();
    }


    private void setCurrentDateOnView () {
        String dateFormat = "MM-dd_yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);
        txtdatedeb_T.setText(sdf.format(i.getTime()));
    }
    private void setCurrentDateOnView2 () {
        String dateFormat="MM-dd_yyyy";
        SimpleDateFormat sdff= new SimpleDateFormat( dateFormat, Locale.US);
        txtdatefin_T.setText(sdff.format(j.getTime()));


    }
    public  void busaveT (View View){

        EditText txtNom_T=(EditText)findViewById(R.id.editText18);
        EditText txtID_T=(EditText)findViewById(R.id.editText19);
        EditText txtdatedeb_T=(EditText)findViewById(R.id.editText20);
        EditText txtdatefin_T=(EditText)findViewById(R.id.editText21);
        spinner5 = (Spinner) findViewById(R.id.spinner5);

        ListView ls=(ListView)findViewById(R.id.listView);
        DBConnections db= new DBConnections(this);
        db.InsertT(txtNom_T.getText().toString(), txtdatedeb_T.getText().toString(), txtdatefin_T.getText().toString(), spinner5.getSelectedItem().toString());

        ArrayList<String> arrlist =db.getAllrecordT();
        ls.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrlist));
        txtNom_T.setText("");
        txtID_T.setText("");

    }
    // delete projet
    public  void budeleteT (View View){
        EditText txtNom_T=(EditText)findViewById(R.id.editText18);
        EditText txtID_T=(EditText)findViewById(R.id.editText19);
        EditText txtdatedeb_T=(EditText)findViewById(R.id.editText20);
        EditText txtdatefin_T=(EditText)findViewById(R.id.editText21);
        spinner5 = (Spinner) findViewById(R.id.spinner5);


        ListView ls=(ListView)findViewById(R.id.listView);
        DBConnections db= new DBConnections(this);
        db.deleteT(Integer.parseInt(txtID_T.getText().toString()));

        ArrayList<String> arrlist =db.getAllrecordT();
        ls.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrlist));
        txtNom_T.setText("");
        txtdatedeb_T.setText("");
        txtdatefin_T.setText("");

    }
    // update projet
    public  void buupdateT (View View){

        EditText txtNom_T=(EditText)findViewById(R.id.editText18);
        EditText txtID_T=(EditText)findViewById(R.id.editText19);
        EditText txtdatedeb_T=(EditText)findViewById(R.id.editText20);
        EditText txtdatefin_T=(EditText)findViewById(R.id.editText21);
        spinner5 = (Spinner) findViewById(R.id.spinner5);

        ListView ls=(ListView)findViewById(R.id.listView);
        DBConnections db= new DBConnections(this);
        db.updateT(txtNom_T.getText().toString(), txtdatedeb_T.getText().toString(), txtdatefin_T.getText().toString(), spinner5.getSelectedItem().toString(), Integer.parseInt(txtID_T.getText().toString()));

        ArrayList<String> arrlist =db.getAllrecordT();
        ls.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrlist));
        txtNom_T.setText("");
        txtdatedeb_T.setText("");
        txtdatefin_T.setText("");
    }

}
