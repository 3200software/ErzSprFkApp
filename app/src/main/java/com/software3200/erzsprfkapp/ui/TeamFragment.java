package com.software3200.erzsprfkapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.software3200.erzsprfkapp.Adapter.AdapterFikstur;
import com.software3200.erzsprfkapp.Adapter.AdapterStandings;
import com.software3200.erzsprfkapp.Adapter.AdapterTeamTitle;
import com.software3200.erzsprfkapp.Model.ModelFikstur;
import com.software3200.erzsprfkapp.Model.ModelMainStories;
import com.software3200.erzsprfkapp.Model.ModelStandings;
import com.software3200.erzsprfkapp.Model.ModelTeamTitle;
import com.software3200.erzsprfkapp.databinding.FragmentDashboardBinding;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class TeamFragment extends Fragment {

    private FragmentDashboardBinding binding;

    FirebaseFirestore firebaseFirestore;

    ArrayList<ModelFikstur> modelFiksturArrayList;
    AdapterFikstur adapterFikstur;

    ArrayList<ModelStandings> modelStandingsArrayList;
    AdapterStandings adapterStandings;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        firebaseFirestore = FirebaseFirestore.getInstance();

        modelFiksturArrayList = new ArrayList<>();
        getFiksturVoid();
        LinearLayoutManager linearLayoutManagerFixtur = new LinearLayoutManager(requireActivity());
        linearLayoutManagerFixtur.setOrientation(RecyclerView.HORIZONTAL);
        binding.teamFixtureRecyclerView.setLayoutManager(linearLayoutManagerFixtur);
        adapterFikstur = new AdapterFikstur(modelFiksturArrayList);
        binding.teamFixtureRecyclerView.setAdapter(adapterFikstur);

        modelStandingsArrayList = new ArrayList<>();
        getStandingsVoid();
        LinearLayoutManager linearLayoutManagerStandings = new LinearLayoutManager(requireActivity());
        binding.teamStandingsRecyclerView.setLayoutManager(linearLayoutManagerStandings);
        adapterStandings = new AdapterStandings(modelStandingsArrayList);
        binding.teamStandingsRecyclerView.setAdapter(adapterStandings);





        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    public void getFiksturVoid () {

        firebaseFirestore.collection("Fikstur").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if (error != null) {


                }

                if (value != null) {

                    for (DocumentSnapshot snapshot : value.getDocuments()) {

                        Map<String, Object> data = snapshot.getData();

                        String teamFiksturfirstTeamName = (String) data.get("teamFiksturfirstTeamName");
                        String teamFiksturFirstTeamImageUrl = (String) data.get("teamFiksturFirstTeamImageUrl");
                        String teamFiksturSecondTeamName = (String) data.get("teamFiksturSecondTeamName");
                        String teamFiksturSecondTeamImageUrl = (String) data.get("teamFiksturSecondTeamImageUrl");
                        String teamFiksturLeagueName = (String) data.get("teamFiksturLeagueName");
                        String teamFiksturDocumentId = (String) data.get("teamFiksturDocumentId");
                        Date teamFiksturMatchDate = (Date) data.get("teamFiksturMatchDate");


                        ModelFikstur modelFikstur = new ModelFikstur(teamFiksturfirstTeamName,teamFiksturFirstTeamImageUrl,teamFiksturSecondTeamName,teamFiksturSecondTeamImageUrl,teamFiksturLeagueName,teamFiksturDocumentId,teamFiksturMatchDate);
                        modelFiksturArrayList.add(modelFikstur);
                    }

                    adapterFikstur.notifyDataSetChanged();

                }

            }

        });




    }


    public void getStandingsVoid() {

        firebaseFirestore.collection("Standings").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if (error != null) {



                }

                if (value != null) {

                    for (DocumentSnapshot snapshot : value.getDocuments()) {


                        Map<String, Object> data = snapshot.getData();

                        String teamLogoImageUrl = (String) data.get("teamLogoImageUrl");
                        String teamStandingsTeamName = (String) data.get("teamStandingsTeamName");
                        Long teamStandingsPlayedLong = (Long) data.get("teamStandingsPlayed");
                        Long teamStandingsVictoryLong = (Long) data.get("teamStandingsVictory");
                        Long teamStandingsTieLong = (Long) data.get("teamStandingsTie");
                        Long teamStandingsDefeatLong = (Long) data.get("teamStandingsDefeat");
                        Long teamStandingsGoalScoredLong = (Long) data.get("teamStandingsGoalScored");
                        Long teamStandingsGoalConcededLong = (Long) data.get("teamStandingsGoalConceded");
                        Long teamStandingsAverageLong = (Long) data.get("teamStandingsAverage");
                        Long getTeamStandingsPointLong = (Long) data.get("getTeamStandingsPoint");

                        Integer teamStandingsPlayed = teamStandingsPlayedLong.intValue();
                        Integer teamStandingsVictory = teamStandingsVictoryLong.intValue();
                        Integer teamStandingsTie = teamStandingsTieLong.intValue();
                        Integer teamStandingsDefeat = teamStandingsDefeatLong.intValue();
                        Integer teamStandingsGoalScored = teamStandingsGoalScoredLong.intValue();
                        Integer teamStandingsGoalConceded = teamStandingsGoalConcededLong.intValue();
                        Integer teamStandingsAverage = teamStandingsAverageLong.intValue();
                        Integer getTeamStandingsPoint = getTeamStandingsPointLong.intValue();

                        ModelStandings modelStandings = new ModelStandings(teamLogoImageUrl, teamStandingsTeamName,teamStandingsPlayed,teamStandingsVictory,teamStandingsTie,teamStandingsDefeat,teamStandingsGoalScored,teamStandingsGoalConceded,teamStandingsAverage,getTeamStandingsPoint);
                        modelStandingsArrayList.add(modelStandings);

                    }

                    adapterStandings.notifyDataSetChanged();

                }

            }
        });


    }


}