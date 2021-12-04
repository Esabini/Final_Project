package com.example.whowroteit;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchCelebs extends AsyncTask<String, Void, String[]> {
    private WeakReference<TextView> mCelebName;

    FetchCelebs(TextView celebName) {
        this.mCelebName = new WeakReference<>(celebName);
    }

    //Makes Calls to an API using the query from main to in order to retrieve information regarding celebrities of an inputted nationality and then stores it in jsonstring
    protected String getCelebInfo(String query) throws IOException {
        URL url = new URL("https://api.api-ninjas.com/v1/celebrity?nationality=" + query);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        connection.setRequestProperty("X-Api-Key", "uY2/N2boqJebAlBjlOYr/g==zAaHnbO5Aax9B1Z1");
        InputStream inputStream = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        //Create a String with the reponse
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
            builder.append("\n");
        }
        String jsonString = builder.toString();
        Log.d("FetchBookTagJsonString", jsonString);
        System.out.println(jsonString);
    return jsonString;
    }

    //Takes the Json string from getCelebInfo then converts it into an array and returns the array
    @Override
    protected String[] doInBackground(String... strings) {
        String jsonString = null;
        String[] finalArray = null;
        try {
            jsonString = getCelebInfo(strings[0]);
            JSONArray arr = new JSONArray(jsonString);
            String[] namesArray = new String[arr.length()];
            for (int i = 0; i < arr.length(); i++) {
                String name = arr.getJSONObject(i).getString("name");
                namesArray[i] = name;
            }
            finalArray = namesArray;
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return finalArray;
    }
}
