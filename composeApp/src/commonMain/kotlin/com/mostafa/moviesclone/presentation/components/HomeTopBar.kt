package com.mostafa.moviesclone.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mostafa.moviesclone.util.Constants.UI.MOVIES
import com.mostafa.moviesclone.util.Constants.UI.TV

@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier,
    selectedSegment: MutableState<String>
) {
    val options = listOf(MOVIES, TV)
    val selectedIndex = options.indexOf(selectedSegment.value)
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        SingleChoiceSegmentedButtonRow(
            modifier = Modifier,
        ) {
            SegmentedButton(
                onClick = { selectedSegment.value = "Movies" },
                selected = selectedIndex == 0,
                label = {
                    Text(
                        MOVIES,
                        style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
                    )
                },
                shape = RoundedCornerShape(4.dp)
            )
            SegmentedButton(
                onClick = { selectedSegment.value = "TV" },
                selected = selectedIndex == 1,
                label = {
                    Text(
                        TV,
                        style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
                    )
                },
                shape = RoundedCornerShape(4.dp)
            )
        }
    }
}