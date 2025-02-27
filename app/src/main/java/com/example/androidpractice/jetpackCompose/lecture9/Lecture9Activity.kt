package com.example.androidpractice.jetpackCompose.lecture9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class Lecture9Activity:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Button(onClick = { finish() }) {
                Text("홈 ㄱㄱ")
            }

            HomeScreen()

        }
    }
}

@Composable
fun HomeScreen() {
    Column () {
        Text("Hello World")
        Button(onClick = {}) {
            Text("클릭")
        }
    }
}