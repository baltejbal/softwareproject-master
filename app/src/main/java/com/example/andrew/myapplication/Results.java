package com.example.andrew.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Results extends AppCompatActivity {

        private FirebaseDatabase database;
        private DatabaseReference myRef;
        DataStructure mData;

        private TextView name;
        private TextView x;
        private TextView y;
        private TextView xax;
        private TextView yax;
        private TextView cbt;
        private TextView zbt;
        private TextView timestamp;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_results);


            getDatabase();
            findAllViews();
            reterieveData();
        }

    public void clickHome1(View view) {
        Intent intent = new Intent(Results.this, Home.class);
        startActivity(intent);
    }

        private void findAllViews(){
            name = findViewById(R.id.name);
            x = findViewById(R.id.readx);
            y = findViewById(R.id.ready);
            xax = findViewById(R.id.readxax);
            yax = findViewById(R.id.readyax);
            zbt = findViewById(R.id.readzbt);
            cbt = findViewById(R.id.readcbt);
            timestamp = findViewById(R.id.readtimestamp);
        }

        private void getDatabase(){
            database = FirebaseDatabase.getInstance();
            myRef = database.getReference("data");
        }

        private void reterieveData(){
            myRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    DataStructure ds = dataSnapshot.getValue(DataStructure.class);
                    String x_string;
                    name.setText(""+ds.getName());
                    x.setText(""+ds.getX());
                    y.setText(""+ds.getY());
                    xax.setText(""+ ds.getXax());
                    yax.setText(""+ ds.getYax());
                    cbt.setText(""+ ds.getCbt());
                    zbt.setText(""+ ds.getZbt());
                    if (x.getText().toString().length() ==0 ) return;
                     int x_number = Integer.parseInt(x.getText().toString());
                    if (y.getText().toString().length() ==0 ) return;
                     int y_number = Integer.parseInt(y.getText().toString());
                    if (xax.getText().toString().length() ==0 ) return;
                     int xax_number = Integer.parseInt(xax.getText().toString());
                    if (yax.getText().toString().length() ==0 ) return;
                     int yax_number = Integer.parseInt(yax.getText().toString());
                    if (cbt.getText().toString().length() ==0 ) return;
                     int cbt_number = Integer.parseInt(cbt.getText().toString());

                    if (zbt.getText().toString().length() ==0 ) return;
                    int zbt_number = Integer.parseInt(ds.getZbt());

                    // Convert from timestamp to Date and time
                    timestamp.setText(convertTimestamp(ds.getTimestamp()));


                    if(x_number>120 || x_number<-120){

                        x.setTextColor(Color.parseColor("#00FF00"));

                    } else if(x_number>60 && x_number<121 || x_number<-60 && x_number<-121){

                        x.setTextColor(Color.parseColor("#FFFF00"));

                    } else if(x_number>-60 && x_number<60){

                        x.setTextColor(getResources().getColor(R.color.colorAccent));
                    }

                    if(y_number>120 || y_number<-120){

                        y.setTextColor(Color.parseColor("#00FF00"));

                    } else if(y_number>60 && y_number<121 || y_number<-60 && y_number<-121){

                        y.setTextColor(Color.parseColor("#FFFF00"));

                    } else if(y_number>-60 && y_number<60){
                        y.setTextColor(getResources().getColor(R.color.colorAccent));

                    }

                    if(xax_number>120 || xax_number<-120){

                        xax.setTextColor(Color.parseColor("#00FF00"));

                    } else if(xax_number>60 && xax_number<121 || xax_number<-60 && xax_number<-121){

                        xax.setTextColor(Color.parseColor("#FFFF00"));

                    } else if(xax_number>-60 && xax_number<60){

                        xax.setTextColor(getResources().getColor(R.color.colorAccent));

                    }

                    if(yax_number>120 || yax_number<-120){

                        yax.setTextColor(Color.parseColor("#00FF00"));

                    } else if(yax_number>60 && yax_number<121 || yax_number<-60 && yax_number<-121){

                        yax.setTextColor(Color.parseColor("#FFFF00"));

                    } else if(yax_number>-60 && yax_number<60){

                        yax.setTextColor(getResources().getColor(R.color.colorAccent));

                    }


                    if(zbt_number >0){

                       zbt.setTextColor(Color.parseColor("#00FF00"));

                    }else {

                        zbt.setTextColor(getResources().getColor(R.color.colorAccent));

                    }

                    if(cbt_number >0){

                        cbt.setTextColor(Color.parseColor("#00FF00"));

                    }else {

                        cbt.setTextColor(getResources().getColor(R.color.colorAccent));

                    }



                }

                private String convertTimestamp(String timestamp){

                    long yourSeconds = Long.valueOf(timestamp);
                    Date mDate = new Date(yourSeconds * 1000);
                    DateFormat df = new SimpleDateFormat("dd MMM yyyy hh:mm:ss");
                    return df.format(mDate);
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    DataStructure ds = dataSnapshot.getValue(DataStructure.class);
                    name.setText("Name"+ds.getName());
                    x.setText("X Value"+ds.getX());
                    y.setText("Y Value: "+ds.getY());
                    xax.setText("X Axis Value: "+ ds.getXax());
                    yax.setText("Y Axis Value: "+ ds.getYax());
                    cbt.setText("C Button: "+ ds.getCbt());
                    zbt.setText("Z Button: "+ ds.getZbt());

                    x.setTextColor(getResources().getColor(R.color.colorPrimary));

                    // Convert from timestamp to Date and time
                    timestamp.setText(convertTimestamp(ds.getTimestamp()));
                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    List<DataStructure> arraylist= new ArrayList<DataStructure>();

                    if (dataSnapshot != null && dataSnapshot.getValue() != null) {

                        // iterate all the items in the dataSnapshot
                        for (DataSnapshot a : dataSnapshot.getChildren()) {
                            DataStructure dataStructure = new DataStructure();
                            dataStructure.setX(a.getValue(DataStructure.class).getX());
                            dataStructure.setY(a.getValue(DataStructure.class).getY());
                            dataStructure.setXax(a.getValue(DataStructure.class).getXax());
                            dataStructure.setYax(a.getValue(DataStructure.class).getYax());
                            dataStructure.setCbt(a.getValue(DataStructure.class).getCbt());
                            dataStructure.setZbt(a.getValue(DataStructure.class).getZbt());
                            dataStructure.setTimestamp(a.getValue(DataStructure.class).getTimestamp());

                            arraylist.add(dataStructure);  // now all the data is in arraylist.
                            Log.d("MapleLeaf", "dataStructure " + dataStructure.getTimestamp());
                        }
                    }

                }

                //TextView t = findViewById(R.id.Legend);
                  //  t.setText("RED: Bad\nYELLOW: Ok\nGREEN: Good");

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Getting data failed, log a message
                    Log.d("MapleLeaf", "Data Loading Cancelled/Failed.", databaseError.toException());
                }
            });
        }



    }

