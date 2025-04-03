package com.mostafa.moviesclone.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.compose.primaryLight
import com.mostafa.moviesclone.domain.models.MoviesModel
import com.mostafa.moviesclone.util.Constants.UI.DEFAULT_ANIMATION_DURATION
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HomeUpcomingMoviesSection(
    moviesList: List<MoviesModel>,
    sectionTitle: String,
) {
    val pageCount = moviesList.size
    val pagerState = rememberPagerState(pageCount = { pageCount }, initialPage = 0)
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(moviesList.size) {
        if (moviesList.isNotEmpty()) {
            while (true) {
                delay(timeMillis = DEFAULT_ANIMATION_DURATION)
                coroutineScope.launch {
                    val nextPage = (pagerState.currentPage + 1) % moviesList.size
                    pagerState.animateScrollToPage(nextPage)
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(355.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 6.dp),
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

        // **Pager for Swiping Images**
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth()
        ) { page ->
            AsyncImage(
                modifier = Modifier.fillMaxWidth().height(300.dp),
                model = moviesList[page].posterImage,
                contentDescription = "movie poster",
            )
        }

        // **Dot Indicators**
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(moviesList.size) { index ->
                Canvas(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(if (index == pagerState.currentPage) 10.dp else 8.dp)
                ) {
                    drawCircle(
                        color = if (index == pagerState.currentPage) primaryLight else Color.Gray.copy(
                            alpha = 0.5f
                        )
                    )
                }
            }
        }
    }
}