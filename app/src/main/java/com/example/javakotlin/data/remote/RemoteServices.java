package com.example.javakotlin.data.remote;

import com.example.javakotlin.data.remote.response.LeagueResponse;
import com.example.javakotlin.data.remote.response.TeamResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RemoteServices {
    @GET("all_leagues.php")
    Call<LeagueResponse> getAllLeagues();

    @GET("lookup_all_teams.php")
    Call<TeamResponse> getTeamByLeague(@Query("id") String idLeague);
}
