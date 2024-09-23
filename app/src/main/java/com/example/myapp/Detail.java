package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Detail extends AppCompatActivity {

    private ListView listview1;
    DatabaseReference databaseReference1;
    private List<Movies> nameList;
    private Custom customadapter;
    private SearchView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        this.setTitle("Movie App");
        databaseReference1= FirebaseDatabase.getInstance().getReference("movies");

        nameList=new ArrayList<>();
        customadapter=new Custom(Detail.this,nameList);
        listview1 =findViewById(R.id.list_view_id);

     //   listview1.setOnItemClickListener((AdapterView.OnItemClickListener) this);
      //  search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
         //   @Override
          //  public boolean onQueryTextSubmit(String query) {
         //       return false;
         //   }

         //   @Override
          //  public boolean onQueryTextChange(String newText) {
                //customadapter.getFilter().filter(newText);
               // return false;
           // }
       // });


    }

    @Override
    protected void onStart() {
        databaseReference1.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                nameList.clear();
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                   Movies movie=dataSnapshot1.getValue(Movies.class);
                   nameList.add(movie);
                }
                listview1.setAdapter(customadapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onStart();
    }

    //    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

   //     Movies value = customadapter.getItem(position);
    ////    Toast.makeText(Detail.this, (CharSequence) value, Toast.LENGTH_SHORT).show();

    //    if (value.equals("Titanic")) {
           // Intent i = new Intent(Detail.this, Titanic.class);
         //   //  i.putExtra("key",listview.getItemAtPosition(position).toString());
          //  startActivity(i);

   ////     }
    }

