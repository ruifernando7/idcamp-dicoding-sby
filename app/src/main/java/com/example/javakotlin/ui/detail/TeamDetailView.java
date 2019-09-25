package com.example.javakotlin.ui.detail;

import com.example.javakotlin.data.remote.model.Team;

public interface TeamDetailView {
    void showLoading();
    void hideLoading();
    void populateData(Team team);
}
