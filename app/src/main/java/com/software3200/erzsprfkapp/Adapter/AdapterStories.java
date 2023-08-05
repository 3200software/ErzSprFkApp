package com.software3200.erzsprfkapp.Adapter;

import android.net.Uri;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.software3200.erzsprfkapp.Model.ModelStories;
import com.software3200.erzsprfkapp.databinding.RecyclerRowStoriesBinding;

import java.util.ArrayList;

public class AdapterStories extends RecyclerView.Adapter<AdapterStories.StoriesViewHolder> {

    ArrayList<ModelStories> modelStoriesArrayList;

    @NonNull
    @Override
    public StoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowStoriesBinding recyclerRowStoriesBinding = RecyclerRowStoriesBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new StoriesViewHolder(recyclerRowStoriesBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull StoriesViewHolder holder, int position) {

        Uri uri = Uri.parse(modelStoriesArrayList.get(position).storyVideoUrl);


        holder.recyclerRowStoriesBinding.videoView2.setVideoURI(uri);


        holder.recyclerRowStoriesBinding.nextVideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });

        holder.recyclerRowStoriesBinding.previousVideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

    }

    @Override
    public int getItemCount() {
        return modelStoriesArrayList.size();
    }

    class StoriesViewHolder extends RecyclerView.ViewHolder{

        RecyclerRowStoriesBinding recyclerRowStoriesBinding;

        public StoriesViewHolder(RecyclerRowStoriesBinding recyclerRowStoriesBinding) {
            super(recyclerRowStoriesBinding.getRoot());
            this.recyclerRowStoriesBinding = recyclerRowStoriesBinding;

        }
    }

}
