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

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Titanic extends AppCompatActivity {

    private ImageView image1;
    private TextView text3,ratingText;
    public static TextView details;
    private RatingBar ratingbar;

    private Button button;
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener oninitialized;

    DatabaseReference databref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_titanic);
        this.setTitle("TITANIC");

        image1=(ImageView) findViewById(R.id.image11);
        text3=(TextView) findViewById(R.id.Text3);
        ratingbar  =findViewById(R.id.ratingBar);
        ratingText=findViewById(R.id.value);
        details=findViewById(R.id.json);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://www.youtube.com/watch?v=ezcvpLIyifU";
                Intent i=new Intent((Intent.ACTION_VIEW));
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://yts.lt/movie/titanic-1997";
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);


            }
        });
        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingText.setText("Value:" + rating);
                String Rvalue = ratingText.getText().toString().trim();
            }
        });
      //  youTubePlayerView=(YouTubePlayerView) findViewById(R.id.youtube_view);
     //oninitialized=new YouTubePlayer.OnInitializedListener() {
            //@Override
           // public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
              //  youTubePlayer.loadVideo("nuQR4noBvac");

         //  }

            //@Override
          // public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

           //}
      //};
       //button=(Button)findViewById(R.id.button);

        //button.setOnClickListener(new View.OnClickListener() {
                                    // @Override
                                     // public void onClick(View v) {
                                         // youTubePlayerView.initialize("AIzaSyDbs3m3QyfhDwP7VKzAVvRn3BP02l-y2tg",oninitialized);
                                   //   }
                            //     }
       //);
        Fetcht fetchdata=new Fetcht();
        fetchdata.execute();



    }}

