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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText inemail,inpassword;
    private Button   login;
    private TextView result,signup;
    private FirebaseAuth mAuth;
    private ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("MOVIE APP");

        inemail=(EditText) findViewById(R.id.editText1);
        inpassword=(EditText)findViewById(R.id.editText2);
        login=(Button)findViewById(R.id.button);
        result=(TextView)findViewById(R.id.text);
        signup=(TextView)findViewById(R.id.signuptext);
        progressbar=(ProgressBar)findViewById(R.id.progressbarid);
        mAuth = FirebaseAuth.getInstance();

        signup.setOnClickListener(this);
        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.button:
            {
                userLogin();
            }
            break;

            case  R.id.signuptext: {
                Intent intent = new Intent(MainActivity.this, Signup.class);
                startActivity(intent);
            }
            break;
            }
        }

    private void userLogin() {
        String email=inemail.getText().toString().trim();
        String password=inpassword.getText().toString().trim();
        if(email.isEmpty())
        {
            inemail.setError("enter your email address");
            inpassword.requestFocus();
            return;
        }
        if(password.isEmpty())
        {
            inpassword.setError("enter a password");
            inpassword.requestFocus();
            return;
        }
        if(password.length()<8)
        {
           inpassword.setError(("Minimum length of password should be 8"));
           inpassword.requestFocus();
           return;
        }
        progressbar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressbar.setVisibility(View.GONE);
                if(task.isSuccessful())
                {
                    finish();
                    Toast.makeText(getApplicationContext(),"LoginSuccesful",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),Admin_choice.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Login unSuccesful",Toast.LENGTH_SHORT).show();
                }
            }
        });

        }
    }