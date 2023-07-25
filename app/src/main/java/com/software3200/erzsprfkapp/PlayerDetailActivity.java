package com.software3200.erzsprfkapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.software3200.erzsprfkapp.Model.ModelPlayers;
import com.software3200.erzsprfkapp.databinding.ActivityPlayerDetailBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class PlayerDetailActivity extends AppCompatActivity {

    ActivityPlayerDetailBinding binding;

    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;
    FirebaseUser currentUSer;

    ArrayList<ModelPlayers> modelPlayersArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_detail);

        binding = ActivityPlayerDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        currentUSer = firebaseAuth.getCurrentUser();

        modelPlayersArrayList = new ArrayList<>();

    }

    public void getPlayerDetail() {

        firebaseFirestore.collection("Players").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if (error != null) {

                    Toast.makeText(getApplicationContext(),"İnternet bağlantınızda bir problwm var. Lütfen saha sonra tekrar deneyiniz",Toast.LENGTH_SHORT).show();
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

                        Picasso.get().load(playerProfilPhotoUrl).into(binding.playerPhotoImageView);
                        binding.playerNameTextView.setText(playerName+ " " +playerSurname);
                        binding.matchPieceTextView.setText(Integer.toString(playerMatch));
                        binding.firstElevenTextView.setText(Integer.toString(playerFirstEleven));
                        binding.goalTextView.setText(Integer.toString(playerGoal));
                        binding.assistTextView.setText(Integer.toString(playerAssist));
                        binding.rescueTextView.setText(Integer.toString(playerRescue));
                        binding.matchTimeTextView.setText(Integer.toString(playerMatchTime));
                        binding.yellowCardTextView.setText(Integer.toString(playerYellowCard));
                        binding.redCardTextView.setText(Integer.toString(playerRedCard));

                    }



                }

            }
        });


    }


}