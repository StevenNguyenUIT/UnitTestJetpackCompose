package com.nhinhnguyenuit.unittestjetpackcompose.data.model

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("r_id")
    val id: Int,
    @SerializedName("r_title")
    val name: String,
    @SerializedName("r_description")
    val description: String
)
