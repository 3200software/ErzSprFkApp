package com.software3200.erzsprfkapp.Model;

public class ModelStandings {

    public String teamLogoImageUrl;
    public String teamStandingsTeamName;
    public Integer teamStandingsPlayed;
    public Integer teamStandingsVictory;
    public Integer teamStandingsTie;
    public Integer teamStandingsDefeat;
    public Integer teamStandingsGoalScored;
    public Integer teamStandingsGoalConceded;
    public Integer teamStandingsAverage;
    public Integer getTeamStandingsPoint;

    public ModelStandings(String teamLogoImageUrl, String teamStandingsTeamName, Integer teamStandingsPlayed, Integer teamStandingsVictory, Integer teamStandingsTie, Integer teamStandingsDefeat, Integer teamStandingsGoalScored, Integer teamStandingsGoalConceded, Integer teamStandingsAverage, Integer getTeamStandingsPoint) {
        this.teamLogoImageUrl = teamLogoImageUrl;
        this.teamStandingsTeamName = teamStandingsTeamName;
        this.teamStandingsPlayed = teamStandingsPlayed;
        this.teamStandingsVictory = teamStandingsVictory;
        this.teamStandingsTie = teamStandingsTie;
        this.teamStandingsDefeat = teamStandingsDefeat;
        this.teamStandingsGoalScored = teamStandingsGoalScored;
        this.teamStandingsGoalConceded = teamStandingsGoalConceded;
        this.teamStandingsAverage = teamStandingsAverage;
        this.getTeamStandingsPoint = getTeamStandingsPoint;
    }
}
