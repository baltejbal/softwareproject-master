package com.example.andrew.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class Home extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();

        String message = intent.getStringExtra("EXTRA_MESSAGE");
        TextView textView = findViewById(R.id.husername);
        textView.setText(message);
    }

    public void clickSettings(View view) {
        Intent intent = new Intent(Home.this, Settings.class);
        startActivity(intent);
    }
    public void calibrate(View view) {
        Intent intent = new Intent(Home.this, Testing.class);
        startActivity(intent);
    }

    public void History(View view) {
        Intent intent = new Intent(Home.this, History.class);
        startActivity(intent);
    }

    public void Signout(View view) {
        Intent intent;
        intent = new Intent(Home.this, MainActivity.class);
        Toast.makeText(getApplicationContext(), "Log Out Successful", Toast.LENGTH_LONG).show();
        startActivity(intent);


                }
            }



