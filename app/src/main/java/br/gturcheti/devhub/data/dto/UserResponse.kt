package br.gturcheti.devhub.data.dto

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("login")
    val userName: String,
    @SerializedName("avatar_url")
    val profilePicture: String,
)