package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    ArtSpace()
                }
            }
        }
    }
}


@Composable
fun ArtSpace(modifier: Modifier = Modifier) {
        One()
}


@Composable
fun One(modifier: Modifier = Modifier) {

    var currentArtwork by remember { mutableIntStateOf(1) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
    ) {
        when (currentArtwork) {
        1 -> {
        Column (
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .border(
                        width = 3.dp,
                        color = Color.Transparent,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .shadow(2.dp, shape = RoundedCornerShape(16.dp))
            ) {
                Image(
                    painter = painterResource(R.drawable.horses),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp, end = 16.dp)
                        .height(400.dp)
                )
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.art_title1),
                fontSize = 30.sp,
                fontWeight = FontWeight.Black
            )
            Text(
                text = stringResource(R.string.artist1),
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Button(
                    onClick = { currentArtwork = 3 },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue, contentColor = Color.White)
                ) {
                    Text(text = "Previous")
                }

                Button(
                    onClick = { currentArtwork = 2 },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue, contentColor = Color.White)
                ) {
                    Text(text = "Next")
                }
            }
        }
    } 2 -> {
            Column (
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .border(
                            width = 3.dp,
                            color = Color.Transparent,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .shadow(2.dp, shape = RoundedCornerShape(16.dp))
                ) {
                    Image(
                        painter = painterResource(R.drawable.tiger),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp)
                            .height(400.dp)
                    )
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.BottomCenter)
                    .padding(16.dp)
            ) {
                Text(
                    text = stringResource(R.string.art_title2),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Black
                )
                Text(
                    text = stringResource(R.string.artist2),
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Button(
                        onClick = { currentArtwork = 1 },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue, contentColor = Color.White)
                    ) {
                        Text(text = "Previous")
                    }

                    Button(
                        onClick = { currentArtwork = 3 },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue, contentColor = Color.White)
                    ) {
                        Text(text = "Next")
                    }
                }
            }
    }
      3 -> {
          Column (
              modifier = Modifier.fillMaxSize()
          ) {
              Box(
                  modifier = Modifier
                      .fillMaxWidth()
                      .padding(20.dp)
                      .border(
                          width = 3.dp,
                          color = Color.Transparent,
                          shape = RoundedCornerShape(16.dp)
                      )
                      .shadow(2.dp, shape = RoundedCornerShape(16.dp))
              ) {
                  Image(
                      painter = painterResource(R.drawable.cape),
                      contentDescription = null,
                      modifier = Modifier
                          .fillMaxSize()
                          .padding(20.dp)
                          .height(400.dp)
                  )
              }
          }

          Column(
              horizontalAlignment = Alignment.CenterHorizontally,
              verticalArrangement = Arrangement.Center,
              modifier = Modifier
                  .fillMaxWidth()
                  .align(alignment = Alignment.BottomCenter)
                  .padding(16.dp)
          ) {
              Text(
                  text = stringResource(R.string.art_title3),
                  fontSize = 30.sp,
                  fontWeight = FontWeight.Black
              )
              Text(
                  text = stringResource(R.string.artist3),
                  fontSize = 20.sp
              )
              Spacer(modifier = Modifier.height(16.dp))

              Row(
                  modifier = Modifier
                      .fillMaxWidth()
                      .padding(16.dp),
                  horizontalArrangement = Arrangement.SpaceBetween,
              ) {
                  Button(
                      onClick = { currentArtwork = 2 },
                      colors = ButtonDefaults.buttonColors(containerColor = Color.Blue, contentColor = Color.White)
                  ) {
                      Text(text = "Previous")
                  }

                  Button(
                      onClick = { currentArtwork = 1 },
                      colors = ButtonDefaults.buttonColors(containerColor = Color.Blue, contentColor = Color.White)
                  ) {
                      Text(text = "Next")
                  }
              }
          }
      }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}