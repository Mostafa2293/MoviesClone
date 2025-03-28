package com.mostafa.moviesclone.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.compose.onSecondaryContainerLight
import com.example.compose.surfaceContainerLight
import com.mostafa.moviesclone.domain.models.MoviesModel
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun PopularMovieItemCard(
    movie: MoviesModel,
    modifier: Modifier = Modifier,
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = surfaceContainerLight
        ),
        shape = RoundedCornerShape(3.dp),
        modifier = modifier
            .width(120.dp)
            .height(200.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 4.dp, end = 4.dp)
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.TopCenter
            ) {
                KamelImage(
                    resource = { asyncPainterResource(movie.posterImage) },
                    contentDescription = "${movie.title} Poster",
                    onFailure = { println("Failed to load image: ${it.message}") },
                )

                TicketStyleRatingBadge(
                    rating = movie.rating.toFloat(),
                    modifier = Modifier.align(Alignment.TopStart)
                )
            }
            Text(
                modifier = Modifier.padding(start = 2.dp, end = 2.dp),
                text = movie.title,
                style = MaterialTheme.typography.labelMedium,
                color = onSecondaryContainerLight,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }
    }

}