package com.example.javakotlin.data.remote.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Team implements Parcelable {
    private String idTeam;
    private String strTeam;
    private String strTeamBadge;
    private String intFormedYear;
    private String strStadium;
    private String strDescriptionEN;

    public Team(String idTeam, String strTeam, String strTeamBadge, String intFormedYear, String strStadium, String strDescriptionEN) {
        this.idTeam = idTeam;
        this.strTeam = strTeam;
        this.strTeamBadge = strTeamBadge;
        this.intFormedYear = intFormedYear;
        this.strStadium = strStadium;
        this.strDescriptionEN = strDescriptionEN;
    }

    protected Team(Parcel in) {
        idTeam = in.readString();
        strTeam = in.readString();
        strTeamBadge = in.readString();
        intFormedYear = in.readString();
        strStadium = in.readString();
        strDescriptionEN = in.readString();
    }

    public static final Creator<Team> CREATOR = new Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel in) {
            return new Team(in);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idTeam);
        dest.writeString(strTeam);
        dest.writeString(strTeamBadge);
        dest.writeString(intFormedYear);
        dest.writeString(strStadium);
        dest.writeString(strDescriptionEN);
    }

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public void setStrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }

    public String getIntFormedYear() {
        return intFormedYear;
    }

    public void setIntFormedYear(String intFormedYear) {
        this.intFormedYear = intFormedYear;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public void setStrStadium(String strStadium) {
        this.strStadium = strStadium;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }
}
