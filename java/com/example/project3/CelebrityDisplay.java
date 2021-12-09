package com.example.project3;
// Evan Sabini and Dan Bekhit


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.LinkedList;

//Instantiates the linked list, recycler view, and adapter
public class CelebrityDisplay extends AppCompatActivity {
    private final LinkedList<String> mCelebList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private CelebListAdapter mAdapter;

    @Override
    /*Receives array from main activity and loops through the array to add each
    element to the linked list for the recycler view
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.celebritydisplay_activity);
        Intent intent = getIntent();
        String[] celebNameArray = intent.getStringArrayExtra("Array");

        //using back button method
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //try catch to make sure app doesn't crash when input is empty
        try {
            if (celebNameArray.length > 0) {
                for(int i = 0; i < celebNameArray.length; ++i) {
                    this.mCelebList.add(celebNameArray[i]);
                }
            } else {
                this.mCelebList.add("No Results for this input");
            }
        } catch (Exception e) {
            this.mCelebList.add("No results, nothing was entered");
            System.out.println(e);
        }
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //next three lines are implementation for divider
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.mRecyclerView.getContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(mRecyclerView.getContext().getResources().getDrawable(R.drawable.divider));
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        mAdapter = new CelebListAdapter(this, mCelebList);
        mRecyclerView.setAdapter(mAdapter);
    }

    //creation of back button method
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(this.getApplicationContext(), MainActivity.class);
        this.startActivityForResult(myIntent, 0);
        return true;
    }

}