package com.example.heartofstone;

import java.util.ArrayList;

public class Game_class {
    String Player1;
    String Player2;
    String LobbyPassword;
    ArrayList<Turn_class> Turns;

    public Game_class(String player1, String player2, String lobbyPassword) {
        Player1 = player1;
        Player2 = player2;
        Turns = null;
        LobbyPassword= lobbyPassword;
    }
}
