package com.example.whowroteit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    private EditText mCountryInput;
    private TextView mCelebText;

    //Creates an instance
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCountryInput = (EditText) findViewById(R.id.countryInput);
    }
    /*
    This gets the query then passes it to the FetchCelebs class, then it gets the Array of the Celeb Names and stores it in celebNameArray and prints it out
     */
    public void searchCelebs(View view) throws ExecutionException, InterruptedException {
        String queryString = mCountryInput.getText().toString();
        FetchCelebs fb = new FetchCelebs(mCelebText);
        String[] celebNameArray = fb.execute(queryString).get();
        System.out.println("Array in main");
        for (int i = 0; i < celebNameArray.length; i++) {
            System.out.println(celebNameArray[i]);
        }
    }
}