package com.example.heartofstone;

public class Card_Condition_class extends Cards_class {
    String Type_dealer;

    public Card_Condition_class(String imgCard, String cardName, Integer rarityLevel, String Type_dealer) {
        IMGCard=imgCard;
        CardName = cardName;
        RarityLevel = rarityLevel;
        this.Type= "Condition Card";
        this.Type_dealer=Type_dealer;
        this.Power = null;
        this.Description = "change's card's power of "+ Type_dealer+" to 1";
    }

    public Card_Condition_class(){}


}
