package com.example.andrew.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class AboutUs extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }

    public void clickSettings(View view) {
        Intent intent = new Intent(AboutUs.this, Settings.class);
        startActivity(intent);
    }

}
