package com.amoa.plus_minus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView counterTextView;
    private ImageView plusImageView;
    private ImageView minusImageView;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void plus(View view){
        counter++;
        counterTextView = (TextView) findViewById(R.id.iCounter);
        counterTextView.setText(Integer.toString(counter));
        if (counter%10 == 0){
            Resources res = getResources();
            String msg = res.getString(R.string.multiple_of_ten);
            Toast.makeText(getApplicationContext(),msg+counter,Toast.LENGTH_LONG).show();

    }}

    public void minus(View view){
        counter--;
        counterTextView = (TextView) findViewById(R.id.iCounter);
        counterTextView.setText(Integer.toString(counter));
    }
}