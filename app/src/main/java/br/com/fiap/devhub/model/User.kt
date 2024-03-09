package br.com.fiap.devhub.model

import com.google.gson.annotations.SerializedName

data class User(
    val login: String = "",
    @SerializedName("avatar_url")
    val avatarUrl: String = "",
    val name: String = "",
    val bio: String? = null

)
