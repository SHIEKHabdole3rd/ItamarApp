package com.example.heartofstone;

import android.content.Intent;

public class Turn_class {
    int TurnNum;
    String Player;
    Cards_class CardPlayed;

    public Turn_class(int turnNum, String player, Cards_class cardPlayed) {
        TurnNum = turnNum;
        Player = player;
        CardPlayed = cardPlayed;
    }
}
