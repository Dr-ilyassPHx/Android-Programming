package com.amoa.studentsdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {
    EditText dname;
    EditText lname;
    EditText mail;
    EditText phone;
    EditText filiere;
    Button Del;
    Button Maj;
    Button Back;
    Button Add;

    EtudiantService etudiantService;
    ArrayList<Etudiant> students;
    Etudiant selectedStudent;
    Etudiant updatedStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


    }
    @Override
    protected void onResume() {

        super.onResume();

        Bundle extras = getIntent().getExtras();

        dname = (EditText)findViewById(R.id.Dname);
        lname = (EditText)findViewById(R.id.Dlname);
        mail = (EditText)findViewById(R.id.Dmail);
        phone = (EditText)findViewById(R.id.Dphone);
        filiere = (EditText)findViewById(R.id.Dclass);
        Del = (Button)findViewById(R.id.btnDel);
        Maj = (Button)findViewById(R.id.btnMaj);
        Back = (Button)findViewById(R.id.btnBack);
        Add = (Button)findViewById(R.id.btnAd);

        // hide Add button for now
        Add.setVisibility(View.GONE);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(),AddActivity.class);
                startActivity(myIntent);
            }
        });

        // index of selected student coming from Intent extras
        Long a = extras.getLong("index");
        int index = a.intValue();
        String s = a.toString();
        // id of selected student in the DB
        //long id = extras.getLong("id");



        //dname.setText(selectedStudent.get(idd).toString());

        // affichage d'etudiant selectionner / clicker
        etudiantService = new EtudiantService(this);
        students = etudiantService.displayStudents();
        selectedStudent = students.get(index);
        dname.setText(selectedStudent.getNom());
        lname.setText(selectedStudent.getPrenom());
        //lname.setText(s);
        mail.setText(selectedStudent.getEmail());
        phone.setText(selectedStudent.getPhone());
        filiere.setText(selectedStudent.getFiliere());

        // delete selected student
        Del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
                Long id = extras.getLong("id");
                etudiantService.deleteStudent(id);
                dname.setText(null);
                lname.setText(null);
                mail.setText(null);
                phone.setText(null);
                filiere.setText(null);
                Toast.makeText(DisplayActivity.this, "Student Successfully Deleted",Toast.LENGTH_LONG).show();

                // il faut cacher les buttons Update et Delete apres suppression de l'etudiant et afficher le button Add student
                Maj.setVisibility(v.GONE);
                Del.setVisibility(v.GONE);
                Add.setVisibility(v.VISIBLE);
            }
        });

        // mise a jour etudiant selectione
        Maj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
                Long id = extras.getLong("id");

                String Name= dname.getText().toString();
                String LName= lname.getText().toString();
                String Filiere= filiere.getText().toString();
                String Phone = phone.getText().toString();
                String Mail = mail.getText().toString();

                updatedStudent = new Etudiant(Name,LName,Filiere,Phone,Mail);
                etudiantService.majEtudiant(id,updatedStudent);
                Toast.makeText(DisplayActivity.this, "Student Successfully Updated",Toast.LENGTH_LONG).show();
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(),SearchActivity.class);
                startActivity(myIntent);
            }
        });


    }


}