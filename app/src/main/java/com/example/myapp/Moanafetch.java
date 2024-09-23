package com.example.myapp;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Moanafetch extends AsyncTask<Void,Void,Void> {
    String line = "";
    String data = "";
    String singleparsed = "";
    String dataparsed = "";


    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://api.myjson.com/bins/gu7q0");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputstream = httpURLConnection.getInputStream();
            InputStreamReader inputstreamReader = new InputStreamReader(inputstream);
            BufferedReader bufferReader = new BufferedReader(inputstreamReader);

            while (line != null) {
                line = bufferReader.readLine();
                data = data + line;
            }
            JSONObject obj = new JSONObject(data);
            JSONArray jk = obj.getJSONArray("movies");

            JSONObject jo = (JSONObject) jk.get(0);
            singleparsed = "Name:" + jo.get("name") + "\n" +
                    "Genre: " + jo.get("genre") + "\n" +
                    "Director:"+jo.get("director")+"\n"+
                    "Releasing year:"+jo.get("year")+"\n"+
                    "Cast:"+ jo.get("cast")+"\n"+
                    "Plot:" + jo.get("plot") + "\n";
            dataparsed = dataparsed + singleparsed + "\n";


        } catch (MalformedURLException e) {

            e.printStackTrace();
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        Moana.details.setText(dataparsed);
        super.onPostExecute(aVoid);
    }

}


