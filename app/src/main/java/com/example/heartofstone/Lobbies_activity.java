package com.example.heartofstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Lobbies_activity extends AppCompatActivity {
    FirebaseDatabase database= FirebaseDatabase.getInstance();
    DatabaseReference myRef= database.getReference();
    Button createlobby, deckbuilder;
    ListView Lobbies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobbies);

        createlobby= findViewById(R.id.BTNceatelobby);
        deckbuilder=findViewById(R.id.BTNdeck);
        Lobbies=findViewById(R.id.LVlobbies);

        createlobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        deckbuilder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveD= new Intent(Lobbies_activity.this, DeckBuild_Activity.class);
                startActivity(moveD);
            }
        });
    }
}