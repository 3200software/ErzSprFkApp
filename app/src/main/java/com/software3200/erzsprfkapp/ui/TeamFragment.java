package com.software3200.erzsprfkapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.software3200.erzsprfkapp.Adapter.AdapterTeamTitle;
import com.software3200.erzsprfkapp.Model.ModelTeamTitle;
import com.software3200.erzsprfkapp.databinding.FragmentDashboardBinding;

import java.util.ArrayList;

public class TeamFragment extends Fragment {

    private FragmentDashboardBinding binding;

    ArrayList<ModelTeamTitle> modelTeamTitleArrayList;
    AdapterTeamTitle adapterTeamTitle;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        modelTeamTitleArrayList = new ArrayList<>();
        ModelTeamTitle fikstur = new ModelTeamTitle("fikstur", "Fikstür");
        ModelTeamTitle puandurumu = new ModelTeamTitle("puanDurumu", "Puan Durumu");
        ModelTeamTitle kadro = new ModelTeamTitle("kadro", "Kadro");
        ModelTeamTitle TeknikKadro = new ModelTeamTitle("teknikKadro", "Teknik Kadro");

        modelTeamTitleArrayList.add(fikstur);
        modelTeamTitleArrayList.add(puandurumu);
        modelTeamTitleArrayList.add(kadro);
        modelTeamTitleArrayList.add(TeknikKadro);

        LinearLayoutManager linearLayoutManagerTeamTitle = new LinearLayoutManager(requireActivity());
        linearLayoutManagerTeamTitle.setOrientation(RecyclerView.HORIZONTAL);
        binding.teamTitleRecyclerView.setLayoutManager(linearLayoutManagerTeamTitle);
        adapterTeamTitle = new AdapterTeamTitle(modelTeamTitleArrayList);
        binding.teamTitleRecyclerView.setAdapter(adapterTeamTitle);









        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}