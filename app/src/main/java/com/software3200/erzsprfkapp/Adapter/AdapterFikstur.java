package com.software3200.erzsprfkapp.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.software3200.erzsprfkapp.MatchDetailActivity;
import com.software3200.erzsprfkapp.Model.ModelFikstur;
import com.software3200.erzsprfkapp.databinding.TeamFixtureRecyclerRowBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterFikstur extends RecyclerView.Adapter<AdapterFikstur.FiksturHolder> {


    ArrayList<ModelFikstur> modelFiksturArrayList;

    public AdapterFikstur(ArrayList<ModelFikstur> modelFiksturArrayList) {
        this.modelFiksturArrayList = modelFiksturArrayList;
    }

    @NonNull
    @Override
    public FiksturHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        TeamFixtureRecyclerRowBinding teamFixtureRecyclerRowBinding = TeamFixtureRecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new FiksturHolder(teamFixtureRecyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull FiksturHolder holder, int position) {

        Picasso.get().load(modelFiksturArrayList.get(position).teamFiksturFirstTeamImageUrl).into(holder.teamFixtureRecyclerRowBinding.firstTeamImageview);
        Picasso.get().load(modelFiksturArrayList.get(position).teamFiksturSecondTeamImageUrl).into(holder.teamFixtureRecyclerRowBinding.secondTeamNameImageView);

        holder.teamFixtureRecyclerRowBinding.firstTeamNameTextView.setText(modelFiksturArrayList.get(position).teamFiksturfirstTeamName);
        holder.teamFixtureRecyclerRowBinding.secandTeamNameTextView.setText(modelFiksturArrayList.get(position).teamFiksturSecondTeamName);
        holder.teamFixtureRecyclerRowBinding.leagueNameTextView.setText(modelFiksturArrayList.get(position).teamFiksturLeagueName);

        holder.teamFixtureRecyclerRowBinding.goToMatchTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent gotoMatchDetailIntent = new Intent(holder.itemView.getContext(), MatchDetailActivity.class);
                gotoMatchDetailIntent.putExtra("MatchDocumentId", modelFiksturArrayList.get(position).teamFiksturDocumentId);
                holder.itemView.getContext().startActivity(gotoMatchDetailIntent);



            }
        });




    }

    @Override
    public int getItemCount() {
        return modelFiksturArrayList.size();
    }

    class FiksturHolder extends RecyclerView.ViewHolder {

        TeamFixtureRecyclerRowBinding teamFixtureRecyclerRowBinding;

        public FiksturHolder(TeamFixtureRecyclerRowBinding teamFixtureRecyclerRowBinding) {
            super(teamFixtureRecyclerRowBinding.getRoot());

            this.teamFixtureRecyclerRowBinding = teamFixtureRecyclerRowBinding;

        }
    }


}
