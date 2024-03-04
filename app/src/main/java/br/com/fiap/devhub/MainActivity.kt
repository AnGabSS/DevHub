package br.com.fiap.devhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.devhub.ui.theme.DevHubTheme

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
                    DevHubPerfil()
                }
            }
        }
    }
}

@Composable
fun DevHubPerfil() {
    Column {

        var nomeState by remember{
            mutableStateOf("Angelo")
        }
        var githubState by remember{
            mutableStateOf("AnGabSS")
        }
        var bioState by remember{
            mutableStateOf("Android Developer and student of analysis and development software by @FIAP")
        }

        Image(
            painter = painterResource(id  = R.drawable.my_picture),
            contentDescription = "",
            modifier = Modifier.size(150.dp)
        )
        Text(text = nomeState)
        Text(text = githubState)
        Text(text = bioState)
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DevHubPerfilPreview() {
    DevHubPerfil()
}