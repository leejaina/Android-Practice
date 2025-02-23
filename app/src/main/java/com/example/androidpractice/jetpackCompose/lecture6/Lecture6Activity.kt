package com.example.androidpractice.jetpackCompose.lecture6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp

class Lecture6Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Button(onClick = { finish() }) {
                Text("홈 ㄱㄱ")
            }

            var text by remember {
                mutableStateOf("")
            }
            val snackbarHostState = remember{SnackbarHostState()}
            val scope= rememberCoroutineScope()
            val keyboardController= LocalSoftwareKeyboardController.current

            Scaffold (
                snackbarHost = { SnackbarHost(snackbarHostState)}
            ) { paddingValues->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextField(
                        value = text,
                        onValueChange = {text=it}
                    )
                    Button(onClick = {
                        keyboardController?.hide()
                        scope.launch {
                            snackbarHostState
                                .showSnackbar("Hello $text")
                        }
                    }) {
                        Text("클릭!!")
                    }
                }
            }
        }
    }
}