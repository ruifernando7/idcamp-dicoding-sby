package com.example.javakotlin.data.remote.model;

import com.google.gson.annotations.SerializedName;

public class League {
    @SerializedName("idLeague")
    private String idLeague;

    @SerializedName("strLeague")
    private String strLeague;

    public League(String idLeague, String strLeague) {
        this.idLeague = idLeague;
        this.strLeague = strLeague;
    }

    public String getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }
}
