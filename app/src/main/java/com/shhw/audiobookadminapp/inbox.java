package com.shhw.audiobookadminapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;

public class inbox extends AppCompatActivity {
    FirebaseFirestore db;
    CollectionReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
        db= FirebaseFirestore.getInstance();
        ref =db.collection("chat");
        ref.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error)
            {
                ArrayList<String> UserEmails = new ArrayList<>();
                for(DocumentSnapshot snapshot: value)
                {
                    UserEmails.add(snapshot.getId());

                }
                UserAdapter adapter = new UserAdapter(UserEmails,getApplicationContext(),getSupportFragmentManager());
                RecyclerView userView = findViewById(R.id.userView);
                userView.setAdapter(adapter);
                userView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));


            }
        });






    }
}