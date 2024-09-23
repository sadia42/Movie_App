package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Pulpfiction extends AppCompatActivity {
    private ImageView image1;
    private TextView text3,ratingText;
    public static TextView details;
    private RatingBar ratingbar;

    private Button button;
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener oninitialized;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_titanic);
    this.setTitle("Pulp Fiction");
        image1=(ImageView) findViewById(R.id.image11);
        text3=(TextView) findViewById(R.id.Text3);
        ratingbar =findViewById(R.id.ratingBar);
        ratingText=findViewById(R.id.value);
        details=findViewById(R.id.json);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.youtube.com/watch?v=s7EdQ4FqbhY";
                Intent i = new Intent((Intent.ACTION_VIEW));
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingText.setText("Value:"+rating);
                String Rvalue= ratingText.getText().toString().trim();}
        });

        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://yts.lt/movie/pulp-fiction-1994";
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);


            }
        });
        Fetchp fetchdata=new Fetchp();
        fetchdata.execute();


    }
}
