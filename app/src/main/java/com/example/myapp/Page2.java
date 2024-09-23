package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class Page2 extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listview;
    ArrayAdapter<String> adapter;
    private SearchView searchview;
    String[] movienames;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

    this.setTitle("MOVIE APP");

        listview = (ListView) findViewById(R.id.list);
        searchview=(SearchView) findViewById(R.id.searchview);
       //arrayadapters=new ArrayAdapter<String>(String:MainActivity.this,)
        movienames = getResources().getStringArray(R.array.movies);
         adapter = new ArrayAdapter<String>(Page2.this, R.layout.newpage_list, R.id.movietext, movienames);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener((AdapterView.OnItemClickListener) this);
        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });


            }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String value=adapter.getItem(position);
        Toast.makeText(Page2.this,value,Toast.LENGTH_SHORT).show();

if(value.equals("Titanic"))
{
            Intent i=new Intent(Page2.this,Titanic.class);
          //  i.putExtra("key",listview.getItemAtPosition(position).toString());
            startActivity(i);

}
        if(value.equals("The Post"))
        {
            Intent i=new Intent(Page2.this,Post.class);
            //  i.putExtra("key",listview.getItemAtPosition(position).toString());
            startActivity(i);}
        if(value.equals("Mulan"))
        {
            Intent i=new Intent(Page2.this,Mulan.class);
            //  i.putExtra("key",listview.getItemAtPosition(position).toString());
            startActivity(i);}
        if(value.equals("Pulp Fiction"))
        {
            Intent i=new Intent(Page2.this,Pulpfiction.class);
            //  i.putExtra("key",listview.getItemAtPosition(position).toString());
            startActivity(i);}
        if(value.equals("Fight Club"))
        {
            Intent i=new Intent(Page2.this,Fight.class);
            //  i.putExtra("key",listview.getItemAtPosition(position).toString());
            startActivity(i);}
        if(value.equals("The Help"))
        {
            Intent i=new Intent(Page2.this,Help.class);
            //  i.putExtra("key",listview.getItemAtPosition(position).toString());
            startActivity(i);}if(value.equals("Moana"))
        {
            Intent i=new Intent(Page2.this,Moana.class);
            //  i.putExtra("key",listview.getItemAtPosition(position).toString());
            startActivity(i);}if(value.equals("La La Land"))
        {
            Intent i=new Intent(Page2.this,LaLa.class);
            //  i.putExtra("key",listview.getItemAtPosition(position).toString());
            startActivity(i);}



}
}

