package br.com.fiap.devhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

        Card(modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
            shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp),
            colors = CardDefaults.cardColors(Color.Gray)
        ){

        }
        Card(
            shape = RoundedCornerShape(80.dp),
            modifier = Modifier.absoluteOffset(120.dp, -75.dp)
        ) {
            Image(
                painter = painterResource(id  = R.drawable.my_picture),
                contentDescription = "",
                modifier = Modifier.size(150.dp)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth().absoluteOffset(y = -65.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Column (horizontalAlignment = Alignment.CenterHorizontally){
                Text(
                    text = nomeState,
                    fontSize = 30.sp
                )
                Text(
                    text = githubState,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = bioState,
                    textAlign = TextAlign.Center
                )
            }
        }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DevHubPerfilPreview() {
    DevHubPerfil()
}