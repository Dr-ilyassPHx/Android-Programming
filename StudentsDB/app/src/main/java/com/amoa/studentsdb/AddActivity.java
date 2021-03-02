package com.amoa.studentsdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    EditText Fname,Lname,Fmail,iphone,iclass;
    Button btnInsert,btnDisplay;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db ;
    EtudiantService etudiantService;
    Etudiant etudiant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        btnInsert =(Button)findViewById(R.id.btnSave);
        btnDisplay =(Button)findViewById(R.id.btnDis);
        Fname  = (EditText)findViewById(R.id.Fname);
        Lname  = (EditText)findViewById(R.id.Lname);
        Fmail  = (EditText)findViewById(R.id.Fmail);
        iphone = (EditText)findViewById(R.id.iphone);
        iclass = (EditText)findViewById(R.id.iclass);

        openHelper = new InptDBHelper(this);

        etudiantService = new EtudiantService(this);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name= Fname.getText().toString();
                String LName= Lname.getText().toString();
                String Filiere= iclass.getText().toString();
                String Phone = iphone.getText().toString();
                String Mail = Fmail.getText().toString();

                etudiant = new Etudiant(Name,LName,Filiere,Phone,Mail);
                etudiantService.sauvegarderEtudiant(etudiant);
                Toast.makeText(AddActivity.this, "Student Saved Successfully",Toast.LENGTH_LONG).show();

                Fname.setText(null);
                Lname.setText(null);
                Fmail.setText(null);
                iphone.setText(null);
                iclass.setText(null);
            }
        });






    }
    public void goToSearchActivity(View view){
        // intent instance
        Intent myIntent = new Intent(this,SearchActivity.class);
        startActivity(myIntent);
    }
}