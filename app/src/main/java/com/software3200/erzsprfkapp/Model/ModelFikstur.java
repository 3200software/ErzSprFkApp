package com.software3200.erzsprfkapp.Model;

import java.util.Date;

public class ModelFikstur {

    public String teamFiksturfirstTeamName;
    public String teamFiksturFirstTeamImageUrl;
    public String teamFiksturSecondTeamName;
    public String teamFiksturSecondTeamImageUrl;
    public String teamFiksturLeagueName;
    public String teamFiksturDocumentId;
    public Date teamFiksturMatchDate;

    public ModelFikstur(String teamFiksturfirstTeamName, String teamFiksturFirstTeamImageUrl, String teamFiksturSecondTeamName, String teamFiksturSecondTeamImageUrl, String teamFiksturLeagueName, String teamFiksturDocumentId, Date teamFiksturMatchDate) {
        this.teamFiksturfirstTeamName = teamFiksturfirstTeamName;
        this.teamFiksturFirstTeamImageUrl = teamFiksturFirstTeamImageUrl;
        this.teamFiksturSecondTeamName = teamFiksturSecondTeamName;
        this.teamFiksturSecondTeamImageUrl = teamFiksturSecondTeamImageUrl;
        this.teamFiksturLeagueName = teamFiksturLeagueName;
        this.teamFiksturDocumentId = teamFiksturDocumentId;
        this.teamFiksturMatchDate = teamFiksturMatchDate;
    }
}
