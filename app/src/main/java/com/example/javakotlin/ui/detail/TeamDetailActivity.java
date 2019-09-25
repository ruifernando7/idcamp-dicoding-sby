package com.example.javakotlin.ui.detail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.javakotlin.R;
import com.example.javakotlin.data.remote.model.Team;
import com.example.javakotlin.ui.main.MainActivity;
import com.squareup.picasso.Picasso;

public class TeamDetailActivity extends AppCompatActivity implements TeamDetailView {

    private ImageView imgLogoTeam;
    private TextView tvTeamName, tvTeamYear, tvStadium, tvDesc;
    private ProgressBar pbLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_detail);

        if(getSupportActionBar() != null)  getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imgLogoTeam = findViewById(R.id.iv_teamactivity_logo);
        tvTeamName = findViewById(R.id.tv_teamactivity_name);
        tvTeamYear = findViewById(R.id.tv_teamactivity_year);
        tvStadium = findViewById(R.id.tv_teamactivity_stadium);
        tvDesc = findViewById(R.id.tv_teamactivity_desc);
        pbLoading = findViewById(R.id.pb_teamactivity);

        Team data = getIntent().getParcelableExtra(MainActivity.FLAG_EXTRAS_TEAM);
        if(data != null) populateData(data);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showLoading() {
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pbLoading.setVisibility(View.GONE);
    }

    @Override
    public void populateData(Team team) {
        Picasso.get().load(team.getStrTeamBadge()).into(imgLogoTeam);
        tvTeamName.setText(team.getStrTeam());
        tvTeamYear.setText(team.getIntFormedYear());
        tvStadium.setText(team.getStrStadium());
        tvDesc.setText(team.getStrDescriptionEN().substring(0,300));
    }
}
