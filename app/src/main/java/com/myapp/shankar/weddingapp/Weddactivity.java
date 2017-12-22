package com.myapp.shankar.weddingapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Weddactivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weddactivity); //defining the layout in activity inflating

        TextView tv = (TextView) findViewById(R.id.txt_id);
       // tv.setText("Ganesh and Ashmika along with their Families\n,Request the pleasure of your marriage on 23rd Nov 2017 at 10:00am, and Reception to follow From 7:00pm onwards\nVenue AGN Kalyana Mantapa 1st cross rd,Omkar Nagar,Arekere,bangalore 560076\n");


        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "Pacifico.ttf"); //using this font for my entire textview

        tv.setTypeface(custom_font);   //this font is set





    }
}
