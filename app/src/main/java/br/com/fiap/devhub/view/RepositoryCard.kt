package br.com.fiap.devhub.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.devhub.model.Repository

@Composable
fun RepositoryCard(repo: Repository) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(3.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Row(
            modifier = Modifier
                .background(color = Color(0xFF3C3E4B))
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Text(text = repo.name, color = Color.White)
        }

        if (repo.description != null) {
            Row(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Text(text = repo.description)
            }
        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RepositoryCardPreview() {
    RepositoryCard(Repository("About-me", null))
}