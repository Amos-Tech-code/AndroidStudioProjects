package com.example.uilogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.uilogin.ui.theme.UILoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UILoginTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    UILoginTheme {
        LoginScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    UILoginTheme {
        RegisterScreen()
    }
}
@Preview
@Composable
fun LoginDarkPreview() {
    UILoginTheme(darkTheme = true) {
        LoginScreen()
    }
}

@Preview
@Composable
fun RegisterDarkPreview() {
    UILoginTheme(darkTheme = true) {
        RegisterScreen()
    }
}