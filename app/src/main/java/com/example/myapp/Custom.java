package com.example.myapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class Custom extends ArrayAdapter <Movies> {


    private Activity context;
    private List<Movies> nameList;



    public Custom(Activity context, List<Movies> nameList) {
        super(context,R.layout.showlist, nameList);
        this.context =  context;
        this.nameList = nameList;
    }
    public View getView(int position, View convertView,ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
       View view= layoutInflater.inflate(R.layout.showlist,null,true);
       Movies movie=nameList.get(position);

         TextView t1=view.findViewById(R.id.textView2_id);

        TextView t2=view.findViewById(R.id.textView3_id);

        TextView t3=view.findViewById(R.id.textView4_id);

        TextView t4=view.findViewById(R.id.textView5_id);
        t1.setText(movie.getName());
        t2.setText(movie.getYear());
        t3.setText(movie.getGenre());
        t4.setText(movie.getRated());


        return view;
    }
}
