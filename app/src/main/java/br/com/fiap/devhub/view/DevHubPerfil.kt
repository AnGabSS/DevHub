package br.com.fiap.devhub.view

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    var listRepos by remember {
        mutableStateOf(listOf<Repository>())
    }

    var call = RetrofitInit().getGithubService().getUserByUsername(username);
    call.enqueue(object : Callback<User>{
        override fun onResponse(call: Call<User>, response: Response<User>) {
            user = response.body()!!
        }

        override fun onFailure(call: Call<User>, t: Throwable) {
            Log.i("GitHubException", t.message!!)
        }
    })

    var callRepo = RetrofitInit().getGithubService().getReposbyUsername(username);
    callRepo.enqueue(object : Callback<List<Repository>>{
        override fun onResponse(
            call: Call<List<Repository>>,
            response: Response<List<Repository>>
        ) {
            listRepos = response.body()!!
        }

        override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
            Log.i("GitHubException", t.message!!)
        }

    })

        DevHubScreen(user, listRepos)


}


