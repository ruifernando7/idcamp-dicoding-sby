package com.example.javakotlin.ui.main

import com.example.javakotlin.data.remote.model.League
import com.example.javakotlin.data.remote.model.Team

interface MainActivityView{
    fun showAllLeagues(leagues: List<League>)
    fun showAllTeams(teams: List<Team>)
    fun showLoading()
    fun hideLoading()
    fun showToast(message: String)
}