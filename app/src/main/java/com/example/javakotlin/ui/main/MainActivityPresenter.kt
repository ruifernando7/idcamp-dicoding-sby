package com.example.javakotlin.ui.main

import com.example.javakotlin.data.remote.RemoteServices
import com.example.javakotlin.data.remote.model.League
import com.example.javakotlin.data.remote.response.LeagueResponse
import com.example.javakotlin.data.remote.response.TeamResponse
import retrofit2.Call
import retrofit2.Response

class MainActivityPresenter(
    private val view: MainActivityView,
    private val service: RemoteServices
){
    fun getAllLeagues(){
        service.allLeagues.enqueue(object : retrofit2.Callback<LeagueResponse> {
            override fun onResponse(call: Call<LeagueResponse>, res: Response<LeagueResponse>) {
                val response = res.body()
                response?.let { view.showAllLeagues(it.leagues) }
            }

            override fun onFailure(call: Call<LeagueResponse>, t: Throwable) {
                view.showToast(t.message.toString())
            }
        })
    }

    fun getAllTeamInLeague(leagueId: String){
        view.showLoading()
        service.getTeamByLeague(leagueId).enqueue(object: retrofit2.Callback<TeamResponse> {
            override fun onResponse(call: Call<TeamResponse>, res: Response<TeamResponse>) {
                val response = res.body()
                response?.let { view.showAllTeams(it.teams) }
            }

            override fun onFailure(call: Call<TeamResponse>, t: Throwable) {
                view.showToast(t.message.toString())
            }
        })
        view.hideLoading()
    }
}