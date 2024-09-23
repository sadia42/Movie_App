package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Page3 extends AppCompatActivity {
    private ImageView image1;
    private TextView text3,ratingText;
    private RatingBar ratingbar;
    DatabaseReference databref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        image1=(ImageView) findViewById(R.id.image11);
        text3=(TextView) findViewById(R.id.Text3);
        ratingbar =findViewById(R.id.ratingBar);
    ratingText=findViewById(R.id.value);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            String movienames=bundle.getString("key");
            showDetails(movienames);
            databref= FirebaseDatabase.getInstance().getReference("movies");
            ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){

                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    ratingText.setText("Value:"+rating);
                    String Rvalue= ratingText.getText().toString().trim();
                    saveData(Rvalue);

                }

                private void saveData(String Rvalue) {

                    String key=databref.push().getKey();
                    // Movies movie=new Movies(Rvalue);
                    databref.child(key).setValue(Rvalue);


                }
            });

        }



    }

    @SuppressLint("ResourceType")
    private void showDetails(String movienames) {
        if(movienames.equals("Titanic"))
        {
            image1.setImageDrawable(ContextCompat.getDrawable(Page3.this,R.drawable.titanic));
        }
       else if(movienames.equals("The Post"))
        {
            image1.setImageDrawable(ContextCompat.getDrawable(Page3.this,R.drawable.post));
        }
       else if(movienames.equals("Moana"))
        {
            image1.setImageDrawable(ContextCompat.getDrawable(Page3.this,R.drawable.moana));
        }
        else if(movienames.equals("Pulp Fiction"))
        {
            image1.setImageDrawable(ContextCompat.getDrawable(Page3.this,R.drawable.pulpfiction));
        }
        else if(movienames.equals("Mulan"))
        {
            image1.setImageDrawable(ContextCompat.getDrawable(Page3.this,R.drawable.mulan));

        } else if(movienames.equals("Lala Land"))
        {
            image1.setImageDrawable(ContextCompat.getDrawable(Page3.this,R.drawable.lalaland));
        } else if(movienames.equals("Fight Club"))
        {
            image1.setImageDrawable(ContextCompat.getDrawable(Page3.this,R.drawable.fightclub));
        }


    }
}
