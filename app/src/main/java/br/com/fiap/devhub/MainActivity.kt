package br.com.fiap.devhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import br.com.fiap.devhub.ui.theme.DevHubTheme

import androidx.navigation.compose.composable
import br.com.fiap.devhub.view.DevHubLogin
import br.com.fiap.devhub.view.DevHubPerfil


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DevHubTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "DevHubLogin",
                        exitTransition = {
                            slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.End) + fadeOut(animationSpec = tween(5000))
                        }
                    ) {
                        composable(route = "DevHubLogin"){
                            DevHubLogin(navController = navController)
                        }
                        composable(route = "Perfil?username={username}"){
                            val username = it.arguments?.getString("username")
                            DevHubPerfil(username = username!!, navController = navController)
                        }
                    }

                }
            }
        }
    }
}

