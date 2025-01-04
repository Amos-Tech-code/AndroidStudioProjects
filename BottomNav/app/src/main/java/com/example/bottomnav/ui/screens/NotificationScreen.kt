package com.example.bottomnav.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NotificationScreen(
    message: List<Message>
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(message) { message ->
            NotificationItem(message)
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NotificationItem(
    message: Message
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Card(
            elevation = CardDefaults.elevatedCardElevation(6.dp),
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = message.name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = message.description,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = message.date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
                )
            }
        }
    }
}








data class Message(
    val name: String,
    val description: String,
    val date: LocalDateTime
)

@RequiresApi(Build.VERSION_CODES.O)
val messages = listOf(
    Message(
        name = "John",
        description = "Hello!",
        date = LocalDateTime.of(2024, 9, 3, 8,50)
    ),
    Message(
        name = "Alice",
        description = "Meeting rescheduled to 2:00 p.m.",
        date = LocalDateTime.of(2024, 9, 3, 10, 15)
    ),
    Message(
        name = "Bob",
        description = "Can you review the document?",
        date = LocalDateTime.of(2024, 9, 3, 9, 45)
    ),
    Message(
        name = "Sarah",
        description = "Happy Birthday!",
        date = LocalDateTime.of(2024, 9, 3, 8, 30)
    ),
    Message(
        name = "David",
        description = "See you at the conference.",
        date = LocalDateTime.of(2024, 9, 3, 7, 50)
    )

)


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun NotificationScreenPreview() {
    val sampleMessages = listOf(
        Message(
            name = "John",
            description = "Hello!",
            date = LocalDateTime.of(2024, 9, 3, 11, 25)
        ),
        Message(
            name = "Alice",
            description = "Meeting rescheduled to 2:00 p.m.",
            date = LocalDateTime.of(2024, 9, 3, 10, 15)
        ),
        Message(
            name = "Bob",
            description = "Can you review the document?",
            date = LocalDateTime.of(2024, 9, 3, 9, 45)
        ),
        Message(
            name = "Sarah",
            description = "Happy Birthday!",
            date = LocalDateTime.of(2024, 9, 3, 8, 30)
        ),
        Message(
            name = "David",
            description = "See you at the conference.",
            date = LocalDateTime.of(2024, 9, 3, 7, 50)
        )
    )
    NotificationScreen(message = sampleMessages)
}