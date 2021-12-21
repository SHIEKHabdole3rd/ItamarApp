package com.example.heartofstone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.media.effect.Effect;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Test_activity extends AppCompatActivity {
    FirebaseDatabase database= FirebaseDatabase.getInstance();
    DatabaseReference myRef= database.getReference();

    EditText CardName, CardPower, CardDesc, CardType, CardRarityLvl, CardIMG, CardTypeDealer;
    Button CreateCard, CreateC_Condition, Createcardback;
    ArrayList<Cards_class> Cards= new ArrayList<>();
    ArrayList<Card_Condition_class> C_Conditions= new ArrayList<>();
    //ArrayList<Cardback_class> Cardbacks = new ArrayList<>();
    Integer count=0, count2=0, count3=0;
    Cards_class CardEXP= new Cards_class();
    Card_Condition_class CardEXP2= new Card_Condition_class();
    //Cardback_class CardbackEXP= new Cardback_class();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        CardName = (EditText) findViewById(R.id.CardNameT);
        CardPower = (EditText) findViewById(R.id.PowerT);
        CardDesc = (EditText) findViewById(R.id.DescriptionT);
        CardType = (EditText) findViewById(R.id.TypeT);
        CardRarityLvl = (EditText) findViewById(R.id.RarityLevelT);
        CardIMG = (EditText) findViewById(R.id.IMGT);
        CardTypeDealer = (EditText) findViewById(R.id.Type_DealerT);


        CreateCard= (Button) findViewById(R.id.BTNCreateCardT);
        CreateCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cards_class c = new Cards_class(CardIMG.getText().toString(),
                        CardName.getText().toString(),
                        Integer.valueOf(CardPower.getText().toString()),
                        CardDesc.getText().toString(),
                        CardType.getText().toString(),
                        Integer.valueOf(CardRarityLvl.getText().toString()));
                Cards.add(c);

                InsertCardToFirebase();
                count++;
                Intent refresh= new Intent(Test_activity.this,Main_Activity.class);
                startActivity(refresh);
            }
        });
        CreateC_Condition= (Button) findViewById(R.id.BTNCreateC_ConditionT);
        CreateC_Condition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                C_Conditions.add(new Card_Condition_class(CardIMG.getText().toString(), CardName.getText().toString(), Integer.valueOf(CardRarityLvl.getText().toString()), CardTypeDealer.getText().toString()));
                InsertConditionerToFirebase();
                count2++;
                Intent refresh= new Intent(Test_activity.this,Main_Activity.class);
                startActivity(refresh);
            }
        });
        /*Createcardback= (Button) findViewById(R.id.BTNcreatecardback);
        Createcardback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cardbacks.add(new Cardback_class(CardName.getText().toString(), CardIMG.getText().toString()));
                InsertCardbackToFirebase();
                count3++;
                Intent refresh= new Intent(Test_activity.this,Main_Activity.class);
                startActivity(refresh);
            }
        });
         */
    }
    public void InsertCardToFirebase(){
        CardEXP=Cards.get(count);
        myRef.child("allCards").push().setValue(CardEXP);
    }
    public void InsertConditionerToFirebase(){
        CardEXP2=C_Conditions.get(count2);
        myRef.child("allCards").push().setValue(CardEXP2);
    }
    /*public void InsertCardbackToFirebase(){
        CardbackEXP=Cardbacks.get(count3);
        myRef.child("allCardbacks").push().setValue(CardbackEXP);
    }*/
}