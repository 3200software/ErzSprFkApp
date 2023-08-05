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
import com.google.firebase.storage.FirebaseStorage;
import com.software3200.erzsprfkapp.Model.ModelStories;
import com.software3200.erzsprfkapp.databinding.ActivityStoryBinding;

import java.util.ArrayList;
import java.util.Date;

public class StoryActivity extends AppCompatActivity {

    ActivityStoryBinding binding;

    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;
    FirebaseStorage firebaseStorage;
    FirebaseUser currentUser;

    ArrayList<ModelStories> modelStoriesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        binding = ActivityStoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        modelStoriesArrayList = new ArrayList<>();


    }

    public void getStories() {

        firebaseFirestore.collection("Stories").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if (error != null) {

                    Toast.makeText(StoryActivity.this, "İnternet bağlantısında bir problem var. Lütfen daha sonra tekrar deneyiniz.", Toast.LENGTH_SHORT).show();

                }

                if (value != null) {

                    for (DocumentSnapshot snapshot : value.getDocuments()) {

                        String storyVideoUrl = (String) snapshot.get("storyVideoUrl");
                        Boolean storyPrivateInfo = (Boolean) snapshot.get("storyPrivateInfo");
                        Date storyAddDate = (Date) snapshot.get("storyAddDate");

                        ModelStories modelStories = new ModelStories(storyVideoUrl, storyPrivateInfo, storyAddDate);
                        modelStoriesArrayList.add(modelStories);

                    }

                }

            }
        });

    }



}