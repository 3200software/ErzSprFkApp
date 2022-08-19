package com.software3200.erzsprfkapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.software3200.erzsprfkapp.Model.ModelMainFeed;
import com.software3200.erzsprfkapp.databinding.MainFeedRecyclerRowBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterMainFeed extends RecyclerView.Adapter<AdapterMainFeed.MainFeedHolder> {

    ArrayList<ModelMainFeed> modelMainFeedArrayList;

    public AdapterMainFeed(ArrayList<ModelMainFeed> modelMainFeedArrayList) {
        this.modelMainFeedArrayList = modelMainFeedArrayList;
    }

    @NonNull
    @Override
    public MainFeedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MainFeedRecyclerRowBinding mainFeedRecyclerRowBinding = MainFeedRecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new MainFeedHolder(mainFeedRecyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainFeedHolder holder, int position) {

        holder.mainFeedRecyclerRowBinding.feedTileTextView.setText(modelMainFeedArrayList.get(position).feedTitle);
        holder.mainFeedRecyclerRowBinding.feedDescriptionTextView.setText(modelMainFeedArrayList.get(position).feedDescription);

        Picasso.get().load(modelMainFeedArrayList.get(position).feedImageUrl).into(holder.mainFeedRecyclerRowBinding.feedImageView);




    }

    @Override
    public int getItemCount() {
        return modelMainFeedArrayList.size();
    }

    class  MainFeedHolder extends RecyclerView.ViewHolder {

        MainFeedRecyclerRowBinding mainFeedRecyclerRowBinding;

       public MainFeedHolder(MainFeedRecyclerRowBinding mainFeedRecyclerRowBinding) {
           super(mainFeedRecyclerRowBinding.getRoot());

           this.mainFeedRecyclerRowBinding = mainFeedRecyclerRowBinding;

       }
   }


}
