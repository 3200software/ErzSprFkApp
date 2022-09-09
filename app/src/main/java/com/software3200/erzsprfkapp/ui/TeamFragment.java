package com.software3200.erzsprfkapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.software3200.erzsprfkapp.Adapter.AdapterTeamTitle;
import com.software3200.erzsprfkapp.Model.ModelFikstur;
import com.software3200.erzsprfkapp.Model.ModelMainStories;
import com.software3200.erzsprfkapp.Model.ModelTeamTitle;
import com.software3200.erzsprfkapp.databinding.FragmentDashboardBinding;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class TeamFragment extends Fragment {

    private FragmentDashboardBinding binding;

    FirebaseFirestore firebaseFirestore;

    ArrayList<ModelTeamTitle> modelTeamTitleArrayList;
    AdapterTeamTitle adapterTeamTitle;

    ArrayList<ModelFikstur> modelFiksturArrayList;
    AdapterFikstur adapterFikstur;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        firebaseFirestore = FirebaseFirestore.getInstance();


        modelFiksturArrayList = new ArrayList<>();
        LinearLayoutManager linearLayoutManagerFixtur = new LinearLayoutManager(requireActivity());
        linearLayoutManagerFixtur.setOrientation(RecyclerView.HORIZONTAL);
        binding.teamTitleRecyclerView.setLayoutManager(linearLayoutManagerFixtur);
        adapterFikstur = new AdapterFikstur(modelFiksturArrayList);
        binding.teamTitleRecyclerView.setAdapter(adapterFikstur);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    public void getFikstur () {

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


}