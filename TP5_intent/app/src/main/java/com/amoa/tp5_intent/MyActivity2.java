package com.amoa.tp5_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MyActivity2 extends AppCompatActivity {
    private EditText eTName2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my2);
        eTName2=(EditText)findViewById(R.id.eTName2);
        //getting the passed typed name through a bundle object
        Bundle extras = getIntent().getExtras();
        String TheType_Name = extras.get("typed_name").toString();
        //display the received typed name
        eTName2.setText(TheType_Name);
    }

    public void goToActivity1(View view){
        // intent instance
        Intent myIntent2 = new Intent(this,MyActivity1.class);
        // get the input text
        eTName2 =(EditText) findViewById(R.id.eTName);
        String correctedTypedName= eTName2.getText().toString();
        // passing the typed name through Intent
        myIntent2.putExtra("corrected_typed_name",correctedTypedName);
        // starting MyActivity1 through the intent
        startActivity(myIntent2);
    }
}