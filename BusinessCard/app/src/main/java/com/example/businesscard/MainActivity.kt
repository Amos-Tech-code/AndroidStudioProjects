package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Card()
                }
            }
        }
    }
}

@Composable
fun Card( modifier: Modifier = Modifier) {

    val image = painterResource(R.drawable.profile_pic)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF3ddc84)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
           // Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Title(
                title = "Getting Started",

            )
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .aspectRatio(2f)
            )
            MyDescription(
                name = "Amos Njega Kamau",
                description = "Android Developer (Beginner)"
            )
        }
        Column(
            Modifier.weight(1f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Details(
                phone = "+254 743 217 122",
                username = "@lutank1 (Twitter/X)",
                email = "amosk5132@gmail.com"
            )
        }
    }

}

@Composable
fun Title(title: String, modifier: Modifier = Modifier) {
    Row(Modifier.padding(top = 5.dp)) {
        Icon(
            imageVector = Icons.Rounded.Star,
            contentDescription = "Star icon",
            tint = Color.Blue
        )
        Icon(
            imageVector = Icons.Rounded.Star,
            contentDescription = "Star icon",
            tint = Color.Blue
        )
        Icon(
            imageVector = Icons.Rounded.Star,
            contentDescription = "Star icon",
            tint = Color.Blue
        )
        Icon(
            imageVector = Icons.Rounded.Star,
            contentDescription = "Star icon",
            tint = Color.Blue
        )
        Icon(
            imageVector = Icons.Rounded.Star,
            contentDescription = "Star icon",
            tint = Color.Blue
        )
        Icon(
            imageVector = Icons.Rounded.Star,
            contentDescription = "Star icon",
            tint = Color.Blue
        )
        Icon(
            imageVector = Icons.Rounded.Star,
            contentDescription = "Star icon",
            tint = Color.Blue
        )
        Icon(
            imageVector = Icons.Rounded.Star,
            contentDescription = "Star icon",
            tint = Color.Blue
        )
    }
    Row{
        Icon(
            imageVector = Icons.Rounded.Star,
            contentDescription = "Star icon",
            tint = Color.Blue
        )
    Text(
        text = title,
        fontSize = 30.sp,
        color = Color.White,
        modifier = Modifier.background(color = Color.DarkGray)
            .padding(10.dp)
    )
        Icon(
            imageVector = Icons.Rounded.Star,
            contentDescription = "Star icon",
            tint = Color.Blue
        )
}
    Icon(
        imageVector = Icons.Rounded.Star,
        contentDescription = "Star icon",
        tint = Color.Blue
    )
    Icon(
        imageVector = Icons.Rounded.Star,
        contentDescription = "Star icon",
        tint = Color.Blue
    )
}
@Composable
fun MyDescription(name: String, description: String, modifier: Modifier = Modifier) {
    Column {

        Text(
            text = name,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(
                    top = 10.dp,
                    bottom = 10.dp
                )

        )
        Text(
            text = description,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
        Row(Modifier
            .align(alignment = Alignment.CenterHorizontally)
            .padding(top = 30.dp)
        ) {
        Icon(
            imageVector = Icons.Rounded.Settings,
            contentDescription = "icon",
            tint = Color.White,
            modifier = Modifier
                .size(70.dp)
        )
        Icon(
            imageVector = Icons.Rounded.Build,
            contentDescription = "Build icon",
            tint = Color.White,
            modifier = Modifier
                .size(80.dp)
                .padding(top = 10.dp)
        )
    }
        Icon(
            imageVector = Icons.Rounded.Favorite,
            contentDescription = "icon",
            tint = Color.Magenta,
            modifier = Modifier
                .size(90.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }

}
@Composable
fun Details(phone: String, username: String, email:String, modifier: Modifier = Modifier) {
    Column{
        Row {
            Icon(
                imageVector = Icons.Rounded.Call,
                contentDescription = "Phone Call icon",
                tint = Color.Black,
                modifier = Modifier
                    .padding(end = 10.dp)
            )
            Text(
                text = phone,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 10.dp)
            )
        }
        Row {
            Icon(
                imageVector = Icons.Rounded.Share,
                contentDescription = "Share icon",
                tint = Color.Black,
                modifier = Modifier
                    .padding(end = 10.dp)
            )
            Text(
                text = username,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 10.dp)
            )
        }
        Row {
            Icon(
                imageVector = Icons.Rounded.Email,
                contentDescription = "Email icon",
                tint = Color.Black,
                modifier = Modifier
                    .padding(end = 10.dp)
            )
            Text(
                text = email,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 20.dp)
            )
        }
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CardPreview() {
    BusinessCardTheme {
        Card()
    }
}
