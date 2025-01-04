package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiceRollerApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerApp() {

    Column(modifier = Modifier.background(Color.Magenta)) {
        Dice()

    }
}

@Composable
fun Dice(modifier: Modifier = Modifier) {

    var result by remember { mutableStateOf( 1) }

    val imageResource = when(result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    var isRolling by remember { mutableStateOf(false) }
    val scale = remember { Animatable(1f) }
    val coroutineScope = rememberCoroutineScope()
    val rotation = remember { Animatable(0f) }



    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Column(
            Modifier
                .wrapContentSize(Alignment.Center)
                .weight(0.3f)
        ) {
            Text(
                text = "RollMaster: Your Ultimate Dice Roller",
                fontWeight = FontWeight.Bold,
                fontSize = 23.sp

            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
                .weight(0.7f)
        )
        {

            Box(
                modifier = Modifier
                    .size(200.dp)
                    .graphicsLayer(
                        scaleX = scale.value,
                        scaleY = scale.value,
                        rotationZ = rotation.value
                    )

            ) {
                Image(
                    painter = painterResource(imageResource),
                    contentDescription = result.toString()
                )

            }
            Spacer(modifier = Modifier.height(40.dp))

            Button(onClick = {
                if (!isRolling) {
                    coroutineScope.launch {
                        isRolling = true
                        scale.animateTo(
                            targetValue = 1.5f,
                            animationSpec = spring(stiffness = Spring.StiffnessLow)
                        )
                        scale.animateTo(
                            targetValue = 1f,
                            animationSpec = spring(stiffness = Spring.StiffnessLow)
                        )
                        rotation.animateTo(
                            targetValue = 360f,
                            animationSpec = tween(durationMillis = 1000, easing = LinearEasing)

                        )

                        rotation.snapTo(0f)
                        isRolling = false
                        result = (1..6).random()
                    }
                }
            })
            {
                Text(
                    text = stringResource(R.string.roll),
                    fontSize = 30.sp
                )
            }

        }
    }
}