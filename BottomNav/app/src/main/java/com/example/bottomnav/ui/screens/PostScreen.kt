package com.example.bottomnav.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PostScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Card(
            elevation = CardDefaults.elevatedCardElevation(8.dp),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = "Oops! No recent Post.",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(30.dp)
            )
        }
        Box(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(
                    text = "See Previous Post",
                    fontSize = 20.sp
                )
            }
        }
    }
}



@Composable
@Preview(showBackground = true)
fun PostScreenPreview() {
    PostScreen()
}