package com.example.andrew.myapplication;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth mAuth;
    EditText register_email, register_password;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register_email = (EditText) findViewById(R.id.email);
        register_password = (EditText) findViewById(R.id.password);


        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.email_sign_up_button).setOnClickListener(this);
        findViewById(R.id.email_sign_in_button).setOnClickListener(this);
    }


    private void userLogin(){

        String email = register_email.getText().toString().trim();
        String password = register_password.getText().toString().trim();

        if (email.isEmpty()) {
            register_email.setError("Email is required");
            register_email.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            register_email.setError("Please enter a valid email");
            register_email.requestFocus();
            return;
        }

        if(password.isEmpty()){
            register_password.setError("Password is required");
            register_password.requestFocus();
            return;

        }
        if(password.length()<6){
            register_password.setError("The minimum length of the password should be 6");
            register_password.requestFocus();
            return;
        }

       // progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
               // progressBar.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, Home.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.email_sign_up_button:

                startActivity(new Intent(this, SignUp.class));
                break;

            case R.id.email_sign_in_button:
                userLogin();
                break;



        }
    }

}
