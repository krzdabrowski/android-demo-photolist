package com.example.myproject.model

import com.google.gson.annotations.SerializedName

data class Photo (
    @SerializedName("name") val id: Any,
    @SerializedName("image") val imageUrl: String
)