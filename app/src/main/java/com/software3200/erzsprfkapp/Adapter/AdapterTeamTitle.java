package com.software3200.erzsprfkapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.software3200.erzsprfkapp.Model.ModelTeamTitle;
import com.software3200.erzsprfkapp.databinding.RecyclerRowTeamTitleBinding;

import java.util.ArrayList;

public class AdapterTeamTitle extends RecyclerView.Adapter<AdapterTeamTitle.TeamTitleHolder> {

   ArrayList<ModelTeamTitle> modelTeamTitleArrayList;

    public AdapterTeamTitle(ArrayList<ModelTeamTitle> modelTeamTitleArrayList) {
        this.modelTeamTitleArrayList = modelTeamTitleArrayList;
    }

    @NonNull
    @Override
    public TeamTitleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowTeamTitleBinding recyclerRowTeamTitleBinding = RecyclerRowTeamTitleBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new TeamTitleHolder(recyclerRowTeamTitleBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamTitleHolder holder, int position) {

        holder.recyclerRowTeamTitleBinding.teamTitleNameTextView.setText(modelTeamTitleArrayList.get(position).teanTitleName);


    }

    @Override
    public int getItemCount() {
        return modelTeamTitleArrayList.size();
    }

    class TeamTitleHolder extends RecyclerView.ViewHolder {

        RecyclerRowTeamTitleBinding recyclerRowTeamTitleBinding;

        public TeamTitleHolder(RecyclerRowTeamTitleBinding recyclerRowTeamTitleBinding) {
            super(recyclerRowTeamTitleBinding.getRoot());

            this.recyclerRowTeamTitleBinding = recyclerRowTeamTitleBinding;
        }
    }

}
