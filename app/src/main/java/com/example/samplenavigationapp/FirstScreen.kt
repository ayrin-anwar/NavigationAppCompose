package com.example.samplenavigationapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FirstScreen(navigationToSecondScreen:(String,Int)->Unit) {
    val name = remember {
        mutableStateOf("")
    }
    val age= remember { mutableIntStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("this is 1st screen", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp) )
        OutlinedTextField(value = name.value,
            onValueChange = {
                name.value = it
            })

        Row {
            OutlinedTextField(
                value = if (age.value == 0) "" else age.value.toString(),
                onValueChange = { newValue ->
                    age.value = newValue.toIntOrNull() ?: 0
                },
                label = { Text("Age") }
            )
        }


        Button(onClick = { navigationToSecondScreen(name.value,age.value)
        }) {
            Text("Go to Next Screen")
        }
    }
}

