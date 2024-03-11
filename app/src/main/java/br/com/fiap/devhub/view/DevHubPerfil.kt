package br.com.fiap.devhub.view

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import br.com.fiap.devhub.model.Repository
import br.com.fiap.devhub.model.User
import br.com.fiap.devhub.retrofit.RetrofitInit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun DevHubPerfil(username: String, navController: NavController) {

    var user by remember {
        mutableStateOf(User())
    }
    var listRepository by remember {
        mutableStateOf(listOf(Repository()))
    }

    val callUser = RetrofitInit().getGithubService().getUserByUsername(username);
    callUser.enqueue(object : Callback<User> {
        override fun onResponse(call: Call<User>, response: Response<User>) {
            user = response.body()!!
        }

        override fun onFailure(call: Call<User>, t: Throwable) {
            Log.i("GitHubException", t.message!!)
        }
    })

    val callRepo = RetrofitInit().getGithubService().getReposbyUsername(username);
    callRepo.enqueue(object : Callback<List<Repository>> {
        override fun onResponse(
            call: Call<List<Repository>>,
            response: Response<List<Repository>>
        ) {
            listRepository = response.body()!!
        }

        override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
            Log.i("GitHubException", t.message!!)
        }

    })


    DevHubScreen(user, listRepository)


}



