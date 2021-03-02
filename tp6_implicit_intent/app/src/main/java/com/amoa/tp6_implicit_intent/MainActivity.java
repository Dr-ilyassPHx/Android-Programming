package com.amoa.tp6_implicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnGooglePage;
    private Button btnViewMap;
    private Button btnCallFriend;
    private Button btnSMS;
    private Button btnEmail;
    private Button btnAnthem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGooglePage = (Button)findViewById(R.id.btnGooglePage);
        btnViewMap = (Button)findViewById(R.id.btnViewMap);
        btnCallFriend = (Button)findViewById(R.id.btnCallAFriend);
        btnSMS = (Button)findViewById(R.id.btnSMS);
        btnEmail = (Button)findViewById(R.id.btnEmail);
        btnAnthem = (Button)findViewById(R.id.btnAnthem);
    }
    public void googlePage(View view) {
        // uri of google
        Uri uri = Uri.parse("https://google.com");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
    public void viewMap(View view){
        Uri uri = Uri.parse("geo:33.98061, -6.86724");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    public void callAFriend(View view) {
        Uri uri = Uri.parse("tel:0699999999");
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }

    public void sendSMS(View view)  {
        Uri uri = Uri.parse("sms:0699999999");
        String message = "this message is sent from Tp6 implicit intent !";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("smsto:"));  // This ensures only SMS apps respond
        intent.putExtra("sms_body", message);
        intent.putExtra(Intent.EXTRA_STREAM, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void sendMail(View view) {
        String recipient = "17rm1420@gmail.com";
        String subject = "Tp 6 AMOA";
        String message = "This is sent from Tp6 implicit Intent !";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipient);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));
    }
    public void playAnthem(View view) {
        Uri uri = Uri.parse("https://youtu.be/hHbm3Mkbwz8");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
}