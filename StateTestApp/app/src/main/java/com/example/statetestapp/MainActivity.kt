package com.example.statetestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.statetestapp.ui.theme.StateTestAppTheme

class MainActivity : ComponentActivity() {
    //ViewModel
    private val viewModel by viewModels<StateTestAppViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StateTestAppTheme {
                    MyScreen(viewModel)
                }
            }
        }
    }

@Composable
fun MyScreen(
     viewModel: StateTestAppViewModel
) {
    val name by viewModel.name.collectAsState()
    val surName by viewModel.surName.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyText(name, surName)
        MyTextField(
            name = name,
            onNameChange = { viewModel.onNameChange(it) }
            )
        MyTextField(
            name = surName,
            onNameChange = { viewModel.onSurNameChange(it) }
        )
    }
}

@Composable
fun MyText(name: String, surName: String) {
    Text(
        text = "Hello, $name $surName",
        fontSize = 30.sp
    )
}

@Composable
fun MyTextField(
    name: String,
    onNameChange: (String) -> Unit
) {

    OutlinedTextField(
        value = name ,
        onValueChange = { onNameChange(it) },
        label = {Text(text = "Enter Name") },
    )
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StateTestAppTheme {
        MyScreen(viewModel = StateTestAppViewModel())
    }
}