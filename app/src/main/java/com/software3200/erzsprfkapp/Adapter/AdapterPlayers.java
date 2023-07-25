package com.software3200.erzsprfkapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.software3200.erzsprfkapp.Model.ModelPlayers;
import com.software3200.erzsprfkapp.databinding.RecyclerRowPlayersBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterPlayers extends RecyclerView.Adapter<AdapterPlayers.PlayersHolder> {

    ArrayList<ModelPlayers> modelPlayersArrayList;

    public AdapterPlayers(ArrayList<ModelPlayers> modelPlayersArrayList) {
        this.modelPlayersArrayList = modelPlayersArrayList;
    }


    @NonNull
    @Override
    public PlayersHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerRowPlayersBinding recyclerRowPlayersBinding = RecyclerRowPlayersBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new PlayersHolder(recyclerRowPlayersBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayersHolder holder, int position) {

        Picasso.get().load(modelPlayersArrayList.get(position).playerProfilPhotoUrl).into(holder.recyclerRowPlayersBinding.playerImageView);

        holder.recyclerRowPlayersBinding.playerNameTextView.setText(modelPlayersArrayList.get(position).playerName);
        


    }

    @Override
    public int getItemCount() {
        return modelPlayersArrayList.size();
    }

    class PlayersHolder extends RecyclerView.ViewHolder {

        RecyclerRowPlayersBinding recyclerRowPlayersBinding;

        public PlayersHolder(RecyclerRowPlayersBinding recyclerRowPlayersBinding) {
            super(recyclerRowPlayersBinding.getRoot());

            this.recyclerRowPlayersBinding = recyclerRowPlayersBinding;
        }
    }



}
