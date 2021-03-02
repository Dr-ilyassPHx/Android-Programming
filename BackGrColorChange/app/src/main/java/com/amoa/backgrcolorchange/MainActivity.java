package com.amoa.backgrcolorchange;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void changeColor(View view){
        // getting the background
        ConstraintLayout bgElement = (ConstraintLayout) findViewById(R.id.main_activity);

        int color = ((ColorDrawable) bgElement.getBackground()).getColor();
        if(color == Color.WHITE){
            bgElement.setBackgroundColor(Color.GREEN);
        }
        if(color == Color.GREEN){
            bgElement.setBackgroundColor(Color.BLUE);
        }
        if (color == Color.BLUE){
            bgElement.setBackgroundColor(Color.RED);
        }
        if (color == Color.RED){
            bgElement.setBackgroundColor(Color.WHITE);
        }




    }
}