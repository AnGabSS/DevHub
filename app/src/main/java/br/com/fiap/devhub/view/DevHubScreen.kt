package br.com.fiap.devhub.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.devhub.R
import br.com.fiap.devhub.model.Repository
import br.com.fiap.devhub.model.User
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun DevHubScreen(user: User, listRepos: List<Repository>) {

    Column (
        modifier = Modifier
            .fillMaxWidth()){
        Surface {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp),
                colors = CardDefaults.cardColors(Color.Gray),
            ) {}
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 75.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Card(
                    shape = RoundedCornerShape(80.dp),
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(user.avatarUrl)
                            .crossfade(true)
                            .build(),
                        placeholder = painterResource(R.drawable.my_picture),
                        contentDescription = null,
                        modifier = Modifier.size(150.dp)
                    )
                }
            }

        }
        Row(
            modifier = Modifier
                    .fillMaxWidth(), horizontalArrangement = Arrangement.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = user.name,
                        fontSize = 30.sp
                    )
                    Text(
                        text = user.login,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = (if (user.bio != null) user.bio else "Sem bio")!!,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Text(
                text = "Repositórios",
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp)
            )

            LazyColumn() {
                items(listRepos) {
                    RepositoryCard(it)
                }
            }
        }
    }



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DevHubScreenPreview() {
    var listaReposMocki by remember {
        mutableStateOf(listOf<Repository>(Repository("teste", "Teste description")))
    }
    DevHubScreen(
        user = User(
            "AnGabss",
            "https://avatars.githubusercontent.com/u/129183227?v=4",
            "Angelo",
            "Android Developer and student of analysis and development software by @FIAP"
        ),
        listaReposMocki
    )
}