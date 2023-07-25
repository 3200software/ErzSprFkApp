package com.software3200.erzsprfkapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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
import com.software3200.erzsprfkapp.Adapter.AdapterMainFeed;
import com.software3200.erzsprfkapp.Adapter.AdapterMainStories;
import com.software3200.erzsprfkapp.Model.ModelMainFeed;
import com.software3200.erzsprfkapp.Model.ModelMainStories;
import com.software3200.erzsprfkapp.Model.ModelPlayers;
import com.software3200.erzsprfkapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class WallFragment extends Fragment {

    private FragmentHomeBinding binding;

    FirebaseFirestore firebaseFirestore;

    ArrayList<ModelMainStories> modelMainStoriesArrayList;
    AdapterMainStories adapterMainStories;

    ArrayList<ModelMainFeed> modelMainFeedArrayList;
    AdapterMainFeed adapterMainFeed;

    ArrayList<ModelPlayers> modelPlayersArrayList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        firebaseFirestore = FirebaseFirestore.getInstance();


        modelMainStoriesArrayList = new ArrayList<>();
        getMainStories();
        LinearLayoutManager linearLayoutManagerMainStories = new LinearLayoutManager(requireActivity());
        linearLayoutManagerMainStories.setOrientation(RecyclerView.HORIZONTAL);
        binding.storiesRecyclerViev.setLayoutManager(linearLayoutManagerMainStories);
        adapterMainStories = new AdapterMainStories(modelMainStoriesArrayList);
        binding.storiesRecyclerViev.setAdapter(adapterMainStories);

        modelMainFeedArrayList = new ArrayList<>();
        getmainFeed();
        LinearLayoutManager linearLayoutManagerMainFeed = new LinearLayoutManager(requireActivity());
        linearLayoutManagerMainFeed.setOrientation(RecyclerView.VERTICAL);
        binding.feedRecyclerView.setLayoutManager(linearLayoutManagerMainFeed);
        adapterMainFeed = new AdapterMainFeed(modelMainFeedArrayList);
        binding.feedRecyclerView.setAdapter(adapterMainFeed);

        modelPlayersArrayList = new ArrayList<>();
        getPlayerDetail();







        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    public void getMainStories() {


        firebaseFirestore.collection("Stories").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {


                if (error != null) {

                    Toast.makeText(getActivity(),"İnternet bağlantınızda bir problem var. Lütfen Bağlantınızı kontrol edin.",Toast.LENGTH_LONG).show();

                }

                if (value != null) {

                    for (DocumentSnapshot snapshot : value.getDocuments()) {

                        Map<String, Object> data = snapshot.getData();

                        String mainStoriesTitle = (String) data.get("mainStoriesTitle");
                        String mainStoriesImgUrl = (String) data.get("mainStoriesImgUrl");
                        String mainStoriesVideoUrl = (String) data.get("mainStoriesVideoUrl");
                        Long mainStoriesViewCountLong = (Long) data.get("mainStoriesViewCount");
                        Long mainStoriesLikeCountLong = (Long) data.get("mainStoriesLikeCount");
                        Boolean mainStoriesPrivateContent = (Boolean) data.get("mainStoriesPrivateContent");

                        Integer mainStoriesViewCount = mainStoriesViewCountLong.intValue();
                        Integer mainStoriesLikeCount = mainStoriesLikeCountLong.intValue();

                        ModelMainStories modelMainStories = new ModelMainStories(mainStoriesTitle,mainStoriesImgUrl,mainStoriesVideoUrl,mainStoriesViewCount,mainStoriesLikeCount,mainStoriesPrivateContent);
                        modelMainStoriesArrayList.add(modelMainStories);

                    }

                    adapterMainStories.notifyDataSetChanged();
                }


            }
        });

    }


    public void getmainFeed() {


        firebaseFirestore.collection("Feed").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {


                if (error != null) {

                    Toast.makeText(getActivity(),"İnternet bağlantınızda bir problem var. Lütfen Bağlantınızı kontrol edin.",Toast.LENGTH_LONG).show();

                }

                if (value != null) {

                    for (DocumentSnapshot snapshot : value.getDocuments()) {

                        Map<String, Object> data = snapshot.getData();


                        String feedImageUrl = (String) data.get("feedImageUrl");
                        String feedTitle = (String) data.get("feedTitle");
                        String feedDescription = (String) data.get("feedDescription");
                        String feedType = (String) data.get("feedType");
                        Long feedLikeCountLong = (Long) data.get("feedLikeCount");
                        String feedDocumentId = (String) data.get("feedDocumentId");
                        Boolean feedPrivateContent = (Boolean) data.get("feedPrivateContent");

                        Integer feedLikeCount = feedLikeCountLong.intValue();

                        ModelMainFeed modelMainFeed = new ModelMainFeed(feedImageUrl,feedTitle,feedDescription,feedType,feedLikeCount,feedDocumentId,feedPrivateContent);
                        modelMainFeedArrayList.add(modelMainFeed);

                    }

                    adapterMainFeed.notifyDataSetChanged();

                }


            }
        });


    }


    public void getPlayerDetail() {

        firebaseFirestore.collection("Players").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if (error != null) {

                    Toast.makeText(requireActivity(),"İnternet bağlantınızda bir problwm var. Lütfen saha sonra tekrar deneyiniz",Toast.LENGTH_SHORT).show();
                }

                if(value != null) {

                    for (DocumentSnapshot snapshot:value.getDocuments()) {

                        Map<String,Object> playersData = snapshot.getData();
                        String playerProfilPhotoUrl = (String) playersData.get("ppUrl");
                        String playerName = (String) playersData.get("playerName");
                        String playerSurname = (String) playersData.get("playerSurname");
                        Date playerBirthday = (Date) playersData.get("playerBirthday");
                        Long playerMatchLong = (Long) playersData.get("playerMatch");
                        Long playerFirstElevenLong = (Long) playersData.get("playerFirstEleven");
                        Long playerGoalLong = (Long) playersData.get("playerGoal");
                        Long playerAssistLong = (Long) playersData.get("playerAssist");
                        Long playerRescueLong = (Long) playersData.get("playerRescue");
                        Long playerMatchTimeLong = (Long) playersData.get("playerMatchTime");
                        Long playerYellowCardLong = (Long) playersData.get("playerYellowCard");
                        Long playerRedCardLong = (Long) playersData.get("playerRedCard");

                        Integer playerMatch = playerMatchLong.intValue();
                        Integer playerFirstEleven = playerFirstElevenLong.intValue();
                        Integer playerGoal = playerGoalLong.intValue();
                        Integer playerAssist = playerAssistLong.intValue();
                        Integer playerRescue = playerRescueLong.intValue();
                        Integer playerMatchTime = playerMatchTimeLong.intValue();
                        Integer playerYellowCard = playerYellowCardLong.intValue();
                        Integer playerRedCard = playerRedCardLong.intValue();

                        ModelPlayers modelPlayers = new ModelPlayers(playerProfilPhotoUrl,playerName,playerSurname,playerBirthday,playerMatch,playerFirstEleven,playerGoal,playerAssist,playerRescue,playerMatchTime,playerYellowCard,playerRedCard);
                        modelPlayersArrayList.add(modelPlayers);

                    }



                }

            }
        });


    }



}