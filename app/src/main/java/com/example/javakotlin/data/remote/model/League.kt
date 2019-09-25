package com.example.javakotlin.data.remote.model

import com.google.gson.annotations.SerializedName

class League(
    @field:SerializedName("idLeague")
    var idLeague: String?,
    @field:SerializedName("strLeague")
    var strLeague: String?
)
