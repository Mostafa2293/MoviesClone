package com.mostafa.moviesclone

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.example.compose.darkScheme
import com.example.compose.lightScheme
import com.mostafa.moviesclone.presentation.Screens.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val colors = if (!isSystemInDarkTheme()) lightScheme else darkScheme
    MaterialTheme(colorScheme = colors) {
        Navigator(HomeScreen())
    }
}