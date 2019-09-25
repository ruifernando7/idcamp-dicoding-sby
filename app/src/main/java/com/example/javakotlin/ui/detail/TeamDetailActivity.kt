package com.example.javakotlin.ui.detail

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

import com.example.javakotlin.R
import com.example.javakotlin.data.remote.model.Team
import com.example.javakotlin.ui.main.MainActivity
import com.example.javakotlin.utils.gone
import com.example.javakotlin.utils.show
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_team_detail.*

class TeamDetailActivity : AppCompatActivity(), TeamDetailView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_detail)

        if (supportActionBar != null) supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val data = intent.getParcelableExtra<Team>(MainActivity.FLAG_EXTRAS_TEAM)
        if (data != null) populateData(data)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showLoading() {
        pb_teamactivity.show()
    }

    override fun hideLoading() {
        pb_teamactivity.gone()
    }

    override fun populateData(team: Team) {
        with(team){
            Picasso.get().load(strTeamBadge).into(iv_teamactivity_logo)
            tv_teamactivity_name?.text = strTeam
            tv_teamactivity_year?.text = intFormedYear
            tv_teamactivity_stadium?.text = strStadium
            tv_teamactivity_desc?.text = strDescriptionEN?.substring(0, 300)
        }
    }
}
