package com.amoa.bmicalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.round;

public class MainActivity extends AppCompatActivity {
    private EditText editTextHeight;
    private EditText editTextWeight;
    private Button button_calculate;
    private TextView textViewBMIResult;
    private TextView textViewCategory;
    private Double height;
    private Double weight;
    private Double bmi =0.0;
    private String category="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Linking with views
        editTextHeight = (EditText)findViewById(R.id.hght);
        editTextWeight = (EditText)findViewById(R.id.wght);
        button_calculate = (Button)findViewById(R.id.button);
        textViewBMIResult = (TextView)findViewById(R.id.bmiresult) ;
        textViewCategory = (TextView)findViewById(R.id.icategory) ;

        // Located the right values of the properties for each view
        //need to load each resource
        Resources res = getResources();
        String hint_height = res.getString(R.string.editText_height) ;
        String hint_weight = res.getString(R.string.editText_weight) ;
        String text_btn_calculate= res.getString(R.string.btn_calculate);
        String text_BMI = res.getString(R.string.textView_BMI) ;
        String text_category = res.getString(R.string.textView_Category);

        // setting properties
        editTextHeight.setHint (hint_height) ;
        editTextWeight.setHint(hint_weight) ;
        button_calculate.setText(text_btn_calculate) ;
        textViewBMIResult.setText(text_BMI) ;
        textViewCategory.setText(text_category) ;

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("key_bmi",bmi);
        outState.putString("key_category",category);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        bmi = savedInstanceState.getDouble("key_bmi");
        category = savedInstanceState.getString("key_category");
        textViewBMIResult.setText(String.valueOf(bmi));
        textViewCategory.setText(category);
    }

    public void calculateBMI(View view) throws Exception {
        Context context = getApplicationContext();
        CharSequence text = "Cannot Enter Null value 0!";
        int duration = Toast.LENGTH_SHORT;

        //load resources
        Resources res = getResources();

        String category1 = res.getString(R.string.category1) ;
        String category2 = res.getString(R.string.category2) ;
        String category3 = res.getString(R.string.category3) ;
        String category4 = res.getString(R.string.category4) ;
        String category5 = res.getString(R.string.category5) ;
        String category6 = res.getString(R.string.category6) ;
        String category7 = res.getString(R.string.category7) ;

        // we read the input values
        try {
            height = Double.valueOf(editTextHeight.getText().toString());
            weight = Double.valueOf(editTextWeight.getText().toString());
            // BMI :
            if (height == 0 || weight == 0 ) {
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
            bmi = weight/(height*height);
            //Category
            if (bmi<=15)
                category = category1;
            else if (bmi<=16)
                category = category2;
            else if (bmi<=18.5)
                category = category3;
            else if (bmi<=25)
                category = category4;
            else if (bmi<=30)
                category = category5;
            else if (bmi<=35)
                category = category6;
            else if (bmi<=40)
                category = category7;
            else
                category = "";
            textViewBMIResult.setText(String.valueOf(round(bmi)));
            textViewCategory.setText(category);

            }catch (NumberFormatException nfe){}

        }
    }
