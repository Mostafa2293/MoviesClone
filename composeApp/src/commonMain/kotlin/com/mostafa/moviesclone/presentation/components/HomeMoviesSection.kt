package com.mostafa.moviesclone.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose.primaryLight
import com.mostafa.moviesclone.domain.models.MoviesModel

@Composable
fun HomeMoviesSection(
    moviesList: List<MoviesModel>,
    sectionTitle: String,
    sectionSubTitle: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = sectionTitle,
                style = MaterialTheme.typography.titleLarge,
                color = primaryLight
            )

            Text(
                text = "View All",
                modifier = Modifier.align(Alignment.CenterVertically),
                style = MaterialTheme.typography.bodyMedium,
                color = primaryLight
            )
        }
        Text(
            modifier = Modifier.padding(bottom = 2.dp),
            text = sectionSubTitle,
            style = MaterialTheme.typography.bodySmall,
            color = primaryLight
        )
        LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            itemsIndexed(moviesList) { index, movie ->
                PopularMovieItemCard(movie)
            }
        }
    }
}