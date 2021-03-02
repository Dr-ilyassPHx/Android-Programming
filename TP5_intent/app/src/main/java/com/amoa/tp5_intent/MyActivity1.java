package com.amoa.tp5_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MyActivity1 extends AppCompatActivity {
    private EditText eTName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onResume() {
        super.onResume();
        //getting the passed corrected typed name a bundle object
        Bundle extras2 = getIntent().getExtras();
        if(extras2 != null) {
            String TheCorrected_Type_Name = extras2.get("Corrected_typed_name").toString();
            //display the received corrected typed name
            eTName.setText(TheCorrected_Type_Name);
        }
    }

    public void goToActivity2(View view){
        // intent instance
        Intent myIntent = new Intent(this,MyActivity2.class);
        // get the input text
        eTName =(EditText) findViewById(R.id.eTName);
        String typedName= eTName.getText().toString();
        // passing the typed name through Intent
        myIntent.putExtra("typed_name",typedName);
        // starting MyActivity2 through the intent
        startActivity(myIntent);
    }
}