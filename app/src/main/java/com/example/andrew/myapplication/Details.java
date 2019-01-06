package com.example.andrew.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Details extends AppCompatActivity {
  //  String Id;
    private TextView name;
    private TextView x;
    private TextView y;
    private TextView xax;
    private TextView yax;
    private TextView cbt;
    private TextView zbt;
    private TextView timestamp;
    //timestamp = findViewById(R.id.detailPagetime);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) { return; } // get data via the key
        String param1 = bundle.getString("Key");



            name = (TextView) findViewById(R.id.detailPagen);
            x = (TextView) findViewById(R.id.detailPagex);
            y = (TextView) findViewById(R.id.detailPagey);
            xax = (TextView) findViewById(R.id.detailPagexax);
            yax = (TextView) findViewById(R.id.detailPageyax);
            cbt = (TextView) findViewById(R.id.detailPagecbt);
            zbt = (TextView) findViewById(R.id.detailPagezbt);
            timestamp = (TextView) findViewById(R.id.detailPagetime);


        String bundleString = bundle.getString("xdata");
        String bundleString1 = bundle.getString("ydata");
        String bundleString2 = bundle.getString("xaxdata");
        String bundleString3 = bundle.getString("yaxdata");
        String bundleString4 = bundle.getString("cbtdata");
        String bundleString5 = bundle.getString("zbtdata");
        String bundleString6 = bundle.getString("tdata");

        name.setText("Name");
        x.setText("X Value");
        y.setText("Y Value");
        xax.setText("X-Axis Value");
        yax.setText("Y-Axis Value");
        cbt.setText("C-Button");
        zbt.setText("Z-Button");
        timestamp.setText("Timestamp");




        // Convert from timestamp to Date and time
       // timestamp.setText(convertTimestamp(ds.getTimestamp()));


    }

    private String convertTimestamp(String timestamp){

        long yourSeconds = Long.valueOf(timestamp);
        Date mDate = new Date(yourSeconds * 1000);
        DateFormat df = new SimpleDateFormat("dd MMM yyyy hh:mm:ss");
        return df.format(mDate);
    }

}