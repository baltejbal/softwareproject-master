package com.example.andrew.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class Settings extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        String englishLanguageCode = "en";
        Button english,french,chinese;
        english = (Button) findViewById(R.id.english);
        chinese = (Button) findViewById(R.id.chinese);
        french = (Button) findViewById(R.id.french);

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Apply english locale", Toast.LENGTH_LONG).show();
                String languageToLoad  = "en";
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

            }
        });
       chinese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Apply chinese locale", Toast.LENGTH_LONG).show();
                String languageToLoad  = "zh";
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

            }
        });
        french.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Apply french locale", Toast.LENGTH_LONG).show();
                String languageToLoad  = "fr";
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());


            }
        });
    }

    public void clickHome(View view) {
        Intent intent = new Intent(Settings.this, Home.class);
        startActivity(intent);
    }

    public void clickAboutUs(View view) {
        Intent intent = new Intent(Settings.this, AboutUs.class);
        startActivity(intent);
    }


}
