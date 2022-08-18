package com.software3200.erzsprfkapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.software3200.erzsprfkapp.Model.ModelMainStories;
import com.software3200.erzsprfkapp.databinding.MainStoriesRecyclerRowBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterMainStories extends RecyclerView.Adapter<AdapterMainStories.MainStoriesHolder> {

    ArrayList<ModelMainStories> modelMainStoriesArrayList;

    public AdapterMainStories(ArrayList<ModelMainStories> modelMainStoriesArrayList) {
        this.modelMainStoriesArrayList = modelMainStoriesArrayList;
    }

    @NonNull
    @Override
    public MainStoriesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MainStoriesRecyclerRowBinding mainStoriesRecyclerRowBinding = MainStoriesRecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new MainStoriesHolder(mainStoriesRecyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainStoriesHolder holder, int position) {

        if (modelMainStoriesArrayList.get(position).mainStoriesPrivateContent == true) {

            holder.mainStoriesRecyclerRowBinding.mainStoriesPrivateContentTextView.setVisibility(View.VISIBLE);

        } else {

            holder.mainStoriesRecyclerRowBinding.mainStoriesPrivateContentTextView.setVisibility(View.INVISIBLE);

        }

        holder.mainStoriesRecyclerRowBinding.privateContentTitleTextView.setText(modelMainStoriesArrayList.get(position).mainStoriesTitle);

        String viewCountString = (String.valueOf(modelMainStoriesArrayList.get(position).mainStoriesViewCount));
        holder.mainStoriesRecyclerRowBinding.mainStoriesViewCountTextView.setText(viewCountString);

        Picasso.get().load(modelMainStoriesArrayList.get(position).mainStoriesImgUrl).into(holder.mainStoriesRecyclerRowBinding.mainStoriesImageView);

    }

    @Override
    public int getItemCount() {
        return modelMainStoriesArrayList.size();
    }

    class MainStoriesHolder extends RecyclerView.ViewHolder {


        MainStoriesRecyclerRowBinding mainStoriesRecyclerRowBinding;

        public MainStoriesHolder(MainStoriesRecyclerRowBinding mainStoriesRecyclerRowBinding) {
            super(mainStoriesRecyclerRowBinding.getRoot());

            this.mainStoriesRecyclerRowBinding = mainStoriesRecyclerRowBinding;

        }
    }




}
