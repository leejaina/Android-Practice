package com.example.androidpractice.jetpackCompose.lecture8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class Lecture8Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Button(onClick = { finish() }) {
                Text("홈 ㄱㄱ")
            }

            val viewModel = viewModel<MainViewModel>()

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text( //여기의 글자를 바꾸고 싶어~ -> 변수 ㄱㄱ
                    viewModel.data.value,
                    fontSize = 30.sp
                )
                Button(onClick = {
                    viewModel.changeValue()
                }) {
                    Text("변경")
                }
            }
        }
    }
}

class MainViewModel : ViewModel() { //Activity ♡ lifespan
//ViewModel은 컴포저블과 독립적 -> Activity 살아있는 동안에는 데이터 유지
//->remember를 붙이지 않아도 됨

    private val _data = mutableStateOf("Hello") //안에서는 데이터 제공
    val data: State<String> = _data //외부에는 읽기전용으로 제공

    fun changeValue() {
        _data.value = "World"
    }

}