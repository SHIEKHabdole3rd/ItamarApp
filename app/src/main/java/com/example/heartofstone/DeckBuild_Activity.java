package com.example.heartofstone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DeckBuild_Activity extends AppCompatActivity {
    FirebaseDatabase database= FirebaseDatabase.getInstance();
    DatabaseReference myRef= database.getReference();
    ListView AllCards, Deck;
    ArrayList<Cards_class> allcards=new ArrayList<>();
    ArrayList<Cards_class> Deckcards=new ArrayList<>();
    Cards_class cardexp=new Cards_class();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_build);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        AllCards = findViewById(R.id.LVcardcollaction);
        Deck = findViewById(R.id.LVdeck);

        Query q = myRef.child("AllCards").orderByKey();
        q.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dst : dataSnapshot.getChildren()) {
                    Cards_class User = dst.getValue(Cards_class.class);
                    allcards.add(User);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        //insert all cards into LVallcards and sorts by power(low to high)
        ArrayAdapter<Cards_class> adp = new ArrayAdapter<Cards_class>(DeckBuild_Activity.this, android.R.layout.simple_list_item_1, allcards);
        AllCards.setAdapter(adp);
        for(int i=0;i<=allcards.size()-1;i++) {
            for (int j = i; j <= allcards.size() - 1; j++) {
                cardexp = allcards.get(i);
                allcards.set(i, allcards.get(j));
                allcards.set(j, cardexp);
            }
        }

        AllCards.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (Deckcards.size() < 30){
                    Deckcards.add(allcards.get(position));
                    refreshdeck();
                    SortByPower();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Too many cards in deck. remove a card from your deck to add this one",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public void refreshdeck(){
        ArrayAdapter<Cards_class> adp = new ArrayAdapter<Cards_class>(DeckBuild_Activity.this, android.R.layout.simple_list_item_1, Deckcards);
        Deck.setAdapter(adp);
    }
    public void SortByPower(){
        for(int i=0;i<=Deckcards.size()-1;i++) {
            for (int j = i; j <= Deckcards.size() - 1; j++) {
                cardexp = Deckcards.get(i);
                Deckcards.set(i, Deckcards.get(j));
                Deckcards.set(j, cardexp);
            }
        }
    }

}