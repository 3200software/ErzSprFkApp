package com.software3200.erzsprfkapp.Model;

import java.util.Date;

public class ModelPlayers {

    public String playerProfilPhotoUrl;
    public String playerName;
    public String playerSurname;
    public Date playerBirthday;
    public Integer playerMatch;
    public Integer playerFirstEleven;
    public Integer playerGoal;
    public Integer playerAssist;
    public Integer playerRescue;
    public Integer playerMatchTime;
    public Integer playerYellowCard;
    public Integer playerRedCard;

    public ModelPlayers(String playerProfilPhotoUrl, String playerName, String playerSurname, Date playerBirthday, Integer playerMatch, Integer playerFirstEleven, Integer playerGoal, Integer playerAssist, Integer playerRescue, Integer playerMatchTime, Integer playerYellowCard, Integer playerRedCard) {
        this.playerProfilPhotoUrl = playerProfilPhotoUrl;
        this.playerName = playerName;
        this.playerSurname = playerSurname;
        this.playerBirthday = playerBirthday;
        this.playerMatch = playerMatch;
        this.playerFirstEleven = playerFirstEleven;
        this.playerGoal = playerGoal;
        this.playerAssist = playerAssist;
        this.playerRescue = playerRescue;
        this.playerMatchTime = playerMatchTime;
        this.playerYellowCard = playerYellowCard;
        this.playerRedCard = playerRedCard;
    }
}
