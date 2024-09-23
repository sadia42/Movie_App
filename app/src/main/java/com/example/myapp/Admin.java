package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Admin extends AppCompatActivity {
    private EditText name,genre,year,rated;
    private Button   save,load;
    DatabaseReference databaseReference1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        databaseReference1= FirebaseDatabase.getInstance().getReference("movies");
        name=findViewById(R.id.Name_id);
        genre=findViewById(R.id.Genre_id);
        year=findViewById(R.id.Year_id);
        rated=findViewById(R.id.Rating_id);
        save=findViewById(R.id.save);
        load=findViewById(R.id.show_button);

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Admin.this,Detail.class);
                startActivity(intent);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveMovie();

            }

            private void saveMovie() {

                String name1=name.getText().toString().trim();
                String year1=year.getText().toString().trim();
                String genre1=genre.getText().toString().trim();
                String rated1=rated.getText().toString().trim();
                String key=databaseReference1.push().getKey();
                Movies movie=new Movies(name1,year1,genre1,rated1);
                databaseReference1.child(key).setValue(movie);
                Toast.makeText(Admin.this, "Saved", Toast.LENGTH_SHORT).show();


            }
        });
    }
}
