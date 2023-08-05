package com.software3200.erzsprfkapp.Adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.software3200.erzsprfkapp.Model.ModelContent;

import java.util.ArrayList;

public class AdapterContent extends RecyclerView.Adapter<AdapterContent.ContentHoder> {

    ArrayList<ModelContent> modelContentArrayList;

    @NonNull
    @Override
    public ContentHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ContentHoder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return modelContentArrayList.size();
    }

    class ContentHoder extends RecyclerView.ViewHolder {



        public ContentHoder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
