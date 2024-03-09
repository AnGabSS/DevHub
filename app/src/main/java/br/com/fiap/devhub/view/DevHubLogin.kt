package br.com.fiap.devhub.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.devhub.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DevHubLogin(navController: NavController){

    var nomeState by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(50.dp)
        ) {
            Text(
            text = "DevHub",
            fontSize = 50.sp
            )
            OutlinedTextField(
                value = nomeState,
                onValueChange = {   nomeState = it  },
                placeholder = {
                    Text(text = "Digite seu usuário do GitHub")
                },
                label = {
                    Text(text = "Usuario")
                },
                modifier = Modifier.padding(5.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Purple40
                )
            )
            Button(
                onClick = { navController.navigate("Perfil?username=${nomeState}") },
                modifier = Modifier
                    .width(250.dp)
                    .padding(top = 5.dp),
                shape = RoundedCornerShape(13.dp)
            ) {
                Text(text = "Buscar")
            }
        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun DevHubLoginPreview() {
    DevHubLogin(navController = rememberNavController())
}