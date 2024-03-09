package br.com.fiap.devhub.retrofit

import br.com.fiap.devhub.model.Repository
import br.com.fiap.devhub.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    //URL Base  https://api.github.com/users

    @GET("{user}")
    fun getUserByUsername(@Path("user") Username : String): Call<User>

    @GET("{user}/repos")
    fun getReposbyUsername(@Path("user") Username: String): Call<List<Repository>>
}