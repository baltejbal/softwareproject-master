package com.example.andrew.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;


public class Testing extends AppCompatActivity {

        private EditText name;
        private Button btnSend;
        private EditText x;
        private EditText y;
        private EditText xax;
        private EditText yax;
        private EditText cbt;
        private EditText zbt;
        private FirebaseDatabase database;
        private DatabaseReference myRef;
        
        DataStructure mData;


                @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_testing);

                    findAllViews();
            getDatabase();

            btnSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    writeData(name.getText(), x.getText(), y.getText(), xax.getText(), yax.getText(), cbt.getText(), zbt.getText());
                }
            });
        }

            public void clickResults(View view) {
                Intent intent = new Intent(Testing.this, Results.class);
                startActivity(intent);
            }
        private void getDatabase(){
            database = FirebaseDatabase.getInstance();
            myRef = database.getReference("data");

        }

        private DataStructure createData(Editable name, Editable x, Editable y, Editable xax, Editable yax, Editable cbt, Editable zbt){
            Long time = System.currentTimeMillis()/1000;
            String timestamp = time.toString();
            return new DataStructure(String.valueOf(name),
                    String.valueOf(x),
                    String.valueOf(y),
                    String.valueOf(xax),
                    String.valueOf(yax),
                    String.valueOf(cbt),
                    String.valueOf(zbt),
                    timestamp);
        }


        private void writeData(Editable name, Editable x, Editable y, Editable xax, Editable yax, Editable cbt, Editable zbt) {

            DataStructure mData = createData(name, x, y, xax, yax, cbt, zbt);
           // creates a new node on database and detect if the writing is successful.
            myRef.push().setValue(mData).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(getApplicationContext(), "Value was set. ", Toast.LENGTH_LONG).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(), "Writing failed", Toast.LENGTH_LONG).show();
                }
            });
        }

        // Find all the views for this activity.
        private void findAllViews(){
            btnSend = findViewById(R.id.btnSend);
            name = findViewById(R.id.name);
            x = findViewById(R.id.x);
            y = findViewById(R.id.y);
            xax = findViewById(R.id.xax);
            yax = findViewById(R.id.yax);
            cbt = findViewById(R.id.cbt);
            zbt = findViewById(R.id.zbt);
        }



        }
