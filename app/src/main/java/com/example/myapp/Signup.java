package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class Signup extends AppCompatActivity implements View.OnClickListener{

    private EditText signupemail,signuppassword;
    private Button signup;
    private TextView login;
    private FirebaseAuth mAuth;
    private ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        this.setTitle("MOVIE APP");


        signupemail=(EditText)findViewById(R.id.editText1);
        signuppassword=(EditText)findViewById((R.id.editText2));
        signup=(Button)findViewById(R.id.button2);
        login=(TextView) findViewById(R.id.logintext);

        mAuth=FirebaseAuth.getInstance();
        progressbar=findViewById(R.id.progressbarid);
        signup.setOnClickListener(this);login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.button2:
                userRegister();
                break;
            case R.id.logintext:
            {
                Intent intent=new Intent(Signup.this,MainActivity.class);
                startActivity(intent);

            }
            break;
        }

    }

    private void userRegister() {
        String email=signupemail.getText().toString().trim();
        String password=signuppassword.getText().toString().trim();
        if(email.isEmpty())
        {
            signupemail.setError("enter your email address");
            signuppassword.requestFocus();
            return;
        }
        if(password.isEmpty())
        {
            signuppassword.setError("enter a password");
            signuppassword.requestFocus();
            return;
        }
        if(password.length()<8)
        {
            signuppassword.setError(("Minimum length of password should be 8 charcaters"));
            signuppassword.requestFocus();
            return;
        }
        progressbar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressbar.setVisibility(View.GONE);
                if (task.isSuccessful()) {

                    Toast.makeText(getApplicationContext(),"Register is succesful",Toast.LENGTH_SHORT).show();

                } else{
                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(),"Already Registered",Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
    }
}
