package com.example.heartofstone;

import android.media.Image;

import java.util.concurrent.locks.Condition;

public class Cards_class {
    public String CardName;
    public Integer Power;
    public String Description;
    public String Type;
    public Integer RarityLevel;
    public String IMGCard;

    public Cards_class(String imgCard, String cardName, Integer power, String description, String type, Integer rarityLevel) {
        IMGCard=imgCard;
        CardName = cardName;
        Power = power;
        Description = description;
        Type = type;
        RarityLevel = rarityLevel;
    }

    public Cards_class(){}


    /*public String getIMGCard() { return IMGCard; }

    public void setIMGCard(String IMGCard) { this.IMGCard = IMGCard; }

    public String getCardName() {
        return CardName;
    }

    public void setCardName(String cardName) {
        CardName = cardName;
    }

    public Integer getPower() {
        return Power;
    }

    public void setPower(Integer power) {
        Power = power;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCondition() {
        return Condition;
    }

    public void setCondition(String condition) {
        Condition = condition;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Integer getRarityLevel() {
        return RarityLevel;
    }

    public void setRarityLevel(Integer rarityLevel) {
        RarityLevel = rarityLevel;
    }
     */
}
