package com.kdroid_consulting.albums.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kdroid_consulting.ui.theme.AlbumsLBCTheme

@Composable
fun AlbumsErrorComponent(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Une erreur est survenue, veuillez réessayer ultérieurement",
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        )
    }
}

@Preview
@Composable
private fun AlbumsErrorComponentPreview() {
    AlbumsLBCTheme {
        AlbumsErrorComponent(Modifier)
    }
}