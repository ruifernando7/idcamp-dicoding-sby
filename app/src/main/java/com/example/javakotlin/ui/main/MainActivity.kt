package com.example.javakotlin.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.javakotlin.R
import com.example.javakotlin.data.remote.RetrofitClient
import com.example.javakotlin.data.remote.model.League
import com.example.javakotlin.data.remote.model.Team
import com.example.javakotlin.ui.detail.TeamDetailActivity
import com.example.javakotlin.ui.main.adapter.TeamRvAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainActivityView{

    private lateinit var presenter: MainActivityPresenter
    private lateinit var spinnerAdapter : ArrayAdapter<String>
    private var listLeagueName : MutableList<String> = mutableListOf()
    private var listLeague : MutableList<League> = mutableListOf()
    private var listTeam : MutableList<Team> = mutableListOf()
    private lateinit var rvAdapter: TeamRvAdapter

    companion object{
        const val FLAG_EXTRAS_TEAM = "TEAM"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listLeagueName)
        sp_mainactivity.adapter = spinnerAdapter
        sp_mainactivity.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {}
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, selectedIndex: Int, p3: Long) {
                presenter.getAllTeamInLeague(listLeague[selectedIndex].idLeague)
            }
        }

        rvAdapter = TeamRvAdapter(listTeam){ team ->
            val intent = Intent(this@MainActivity, TeamDetailActivity::class.java)
            intent.putExtra(FLAG_EXTRAS_TEAM, team)
            startActivity(intent)
        }
        rv_mainactivity_team?.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_mainactivity_team?.adapter= rvAdapter

        presenter = MainActivityPresenter(this, RetrofitClient.getInstance())
        presenter.getAllLeagues()
    }

    override fun showAllLeagues(leagues: List<League>) {
        listLeague.clear()
        listLeague.addAll(leagues)
        for(i in 0 until listLeague.size){
            listLeagueName.add(listLeague[i].strLeague)
        }
        spinnerAdapter.notifyDataSetChanged()
    }

    override fun showAllTeams(teams: List<Team>) {
        listTeam.clear()
        listTeam.addAll(teams)
        rvAdapter.notifyDataSetChanged()
    }

    override fun showLoading() {
        pb_mainactivity.visibility = View.VISIBLE
        rv_mainactivity_team.visibility = View.GONE
    }

    override fun hideLoading() {
        pb_mainactivity.visibility = View.GONE
        rv_mainactivity_team.visibility = View.VISIBLE
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
