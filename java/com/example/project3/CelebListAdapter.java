package com.example.project3;
// Evan Sabini and Dan Bekhit


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class CelebListAdapter extends
        RecyclerView.Adapter<CelebListAdapter.WordViewHolder>{
    //the inflater creates the single item layout
    //see it used in onCreateViewHolder below
    private LayoutInflater mInflater;
    private LinkedList<String> mCelebList;
    private Context context;

    //the constructor can take any parameters we need
    public CelebListAdapter(Context context,
                           LinkedList<String> wordList) {
        //use this to create the layout
        mInflater = LayoutInflater.from(context);
        mCelebList = wordList;
        this.context = context;

    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater. inflate(R.layout.celeblist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String mCurrent = mCelebList.get(position);
        holder.mCelebItemView.setText(mCurrent);

    }

    @Override
    public int getItemCount() {
        return mCelebList.size();
    }

    //The RecyclerView.ViewHolder class must be an inner class
    //of the adapter class.
    //WordViewHolder is the Java class that represents the celeblist_item.xml layout
    class WordViewHolder extends RecyclerView.ViewHolder  {
        //instantiate any views used in the item layout here
        private TextView mCelebItemView;
        private CelebListAdapter adapter;


        public WordViewHolder(View itemView, CelebListAdapter adapter) {
            super(itemView);
            mCelebItemView = itemView.findViewById(R.id.celeb);
            this.adapter = adapter;

        }


    }

}