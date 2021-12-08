package com.example.project3;
// Evan Sabini and Dan Bekhit


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

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
        for (int i = 0; i < celebNameArray.length; i++) {
            mCelebList.add(celebNameArray[i]);
        }
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new CelebListAdapter(this, mCelebList);
        mRecyclerView.setAdapter(mAdapter);
    }

}