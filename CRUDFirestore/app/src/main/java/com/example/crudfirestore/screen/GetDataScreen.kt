package com.example.crudfirestore.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.crudfirestore.data.UserData
import com.example.crudfirestore.model.SharedViewModel

@Composable
fun GetDataScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel
) {

    var userID: String by rememberSaveable {
        mutableStateOf("")
    }
    var name: String by rememberSaveable {
        mutableStateOf("")
    }
    var profession: String by rememberSaveable {
        mutableStateOf("")
    }
    var age: String by rememberSaveable {
        mutableStateOf("")
    }
    var ageInt: Int by rememberSaveable {
        mutableIntStateOf(0)
    }

    val context = LocalContext.current

    //Main Layout
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .padding(start = 15.dp, top = 15.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            IconButton(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back button"
                )
            }
        }

        //Add data Layout
        Column(
            modifier = Modifier
                .padding(start = 50.dp, end = 50.dp, bottom = 50.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            //User ID

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(0.6f),
                    value = userID,
                    onValueChange = { userID = it },
                    label = {
                        Text(text = "User ID")
                    }
                )

                //Get User data button
                Button(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .width(100.dp),
                    onClick = {
                        sharedViewModel.retrieveData(
                            userID = userID,
                            context = context
                        ) { data ->
                            name = data.name
                            profession = data.profession
                            age = data.age.toString()
                            ageInt = age.toInt()
                        }
                    }
                ) {
                    Text(text = "Get Data")
                }
            }


            //Name
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = name,
                onValueChange = { name = it },
                label = {
                    Text(text = "Name")
                }
            )
            //Profession
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = profession,
                onValueChange = { profession = it },
                label = {
                    Text(text = "Profession")
                }
            )
            //Age
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = age,
                onValueChange = {
                    age = it
                    if (age.isNotEmpty()) {
                        ageInt = age.toInt()
                    }
                },
                label = {
                    Text(text = "Age")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            //Save Button

            Button(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(),
                onClick = {
                    val userData = UserData(
                        userID = userID,
                        name = name,
                        profession = profession,
                        age = ageInt
                    )

                    sharedViewModel.saveData(userData = userData, context = context)
                }
            ) {
                Text(text = "Save")
            }

            //Delete Button

            Button(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(),
                onClick = {
                    sharedViewModel.deleteData(
                        userID = userID,
                        context = context,
                        navController = navController
                    )
                }
            ) {
                Text(text = "Delete")
            }
        }

      }

    }