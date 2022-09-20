package com.software3200.erzsprfkapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.software3200.erzsprfkapp.Model.ModelStandings;
import com.software3200.erzsprfkapp.databinding.RecyclerViewStandingsBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterStandings extends RecyclerView.Adapter<AdapterStandings.StandingsHolder> {


    ArrayList<ModelStandings> modelStandingsArrayList;

    public AdapterStandings(ArrayList<ModelStandings> modelStandingsArrayList) {
        this.modelStandingsArrayList = modelStandingsArrayList;
    }

    @NonNull
    @Override
    public StandingsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewStandingsBinding recyclerViewStandingsBinding = RecyclerViewStandingsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new StandingsHolder(recyclerViewStandingsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull StandingsHolder holder, int position) {


        holder.recyclerViewStandingsBinding.teamStandingTeamName.setText(modelStandingsArrayList.get(position).teamStandingsTeamName);
        holder.recyclerViewStandingsBinding.teamStandingGamePlayedTextView.setText(modelStandingsArrayList.get(position).teamStandingsPlayed);
        holder.recyclerViewStandingsBinding.teamStandingVictoryTextView.setText(modelStandingsArrayList.get(position).teamStandingsVictory);
        holder.recyclerViewStandingsBinding.teamStandingTieTextView.setText(modelStandingsArrayList.get(position).teamStandingsTie);
        holder.recyclerViewStandingsBinding.teamStandingDefeatTextView.setText(modelStandingsArrayList.get(position).teamStandingsDefeat);
        holder.recyclerViewStandingsBinding.teamStandingGoalScoredTextView.setText(modelStandingsArrayList.get(position).teamStandingsGoalScored);
        holder.recyclerViewStandingsBinding.teamStandingGoalConcededTextView.setText(modelStandingsArrayList.get(position).teamStandingsGoalConceded);
        holder.recyclerViewStandingsBinding.teamStandingAverageTextView.setText(modelStandingsArrayList.get(position).teamStandingsAverage);
        holder.recyclerViewStandingsBinding.teamStandingPointTextView.setText(modelStandingsArrayList.get(position).getTeamStandingsPoint);
        Picasso.get().load(modelStandingsArrayList.get(position).teamLogoImageUrl).into(holder.recyclerViewStandingsBinding.teamStandingLogoImageView);


    }

    @Override
    public int getItemCount() {
        return modelStandingsArrayList.size();
    }

    class StandingsHolder extends RecyclerView.ViewHolder {

        RecyclerViewStandingsBinding recyclerViewStandingsBinding;

        public StandingsHolder(RecyclerViewStandingsBinding recyclerViewStandingsBinding) {
            super(recyclerViewStandingsBinding.getRoot());

            this.recyclerViewStandingsBinding = recyclerViewStandingsBinding;

        }
    }

}
