package br.com.fiap.devhub.retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInit {

    private val URL = "https://api.github.com/users/"

    private val retrofit = Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build()

    fun getGithubService(): GithubService{
        return retrofit.create(GithubService::class.java)
    }


}