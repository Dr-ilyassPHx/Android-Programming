package com.amoa.studentsdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    SearchView vSearch;
    ListView lv;
    ArrayList<String> list;
    ArrayList<Etudiant> students;
    ArrayAdapter<String > adapter;

    EtudiantService etudiantService;
    Etudiant etudiant1;
    int size;
    String onevalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*vSearch = (SearchView) findViewById(R.id.vSearch);
        lv = (ListView) findViewById(R.id.lv);
        etudiantService = new EtudiantService(this);

        list = new ArrayList<>();
        students = etudiantService.listerEtudiants();
        size = students.size();
        for(int i=0; i<size; i++){
            onevalue = students.get(i).toString();
            list.add(onevalue);
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        lv.setAdapter(adapter);
        // fire intent from item click
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Intent myiIntent = new Intent(getApplicationContext(),DisplayActivity.class);
                myiIntent.putExtra("id",id);
                startActivity(myiIntent);
            }

        });

        // filtrage of items
        vSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                if(list.contains(query)){
                    adapter.getFilter().filter(query);
                }else{
                    Toast.makeText(SearchActivity.this, "No Match found",Toast.LENGTH_LONG).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        }); */
    }

    @Override
    protected void onResume() {
        super.onResume();
        // actualiser les valeurs dans la list de recherche

        vSearch = (SearchView) findViewById(R.id.vSearch);
        lv = (ListView) findViewById(R.id.lv);
        etudiantService = new EtudiantService(this);

        list = new ArrayList<>();
        students = etudiantService.listerEtudiants();
        size = students.size();
        for(int i=0; i<size; i++){
            onevalue = students.get(i).toString();
            list.add(onevalue);
        }


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        lv.setAdapter(adapter);
        // fire intent from item click
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                int i = (int)id;
                etudiant1 = students.get(i);
                long studentId= etudiant1.getId();
                Intent myiIntent = new Intent(getApplicationContext(),DisplayActivity.class);
                myiIntent.putExtra("id",studentId);
                myiIntent.putExtra("index",id);
                startActivity(myiIntent);
            }

        });

        // filtrage of items
        vSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                if(list.contains(query)){
                    adapter.getFilter().filter(query);
                }else{
                    Toast.makeText(SearchActivity.this, "No Match found",Toast.LENGTH_LONG).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });


    }















    public void goToAddActivity(View view){
        // intent instance
        Intent myIntent = new Intent(this,AddActivity.class);
        startActivity(myIntent);
    }

    /*public void goToDisplayActivity(View view){
        // intent instance
        Intent myIntent = new Intent(this,DisplayActivity.class);
        // get the input text
        eTName =(EditText) findViewById(R.id.eTName);
        String typedName= eTName.getText().toString();
        // passing the typed name through Intent
        myIntent.putExtra("typed_name",typedName);
        // starting MyActivity2 through the intent
        startActivity(myIntent);
    }*/
}