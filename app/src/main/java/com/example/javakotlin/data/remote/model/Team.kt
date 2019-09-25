package com.example.javakotlin.data.remote.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Team (
    var idTeam: String? = null,
    var strTeam: String? = null,
    var strTeamBadge: String? = null,
    var intFormedYear: String? = null,
    var strStadium: String? = null,
    var strDescriptionEN: String? = null
): Parcelable
