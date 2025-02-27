package com.example.androidpractice.jetpackCompose.lecture9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue  //by
import androidx.compose.runtime.setValue  //by
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class Lecture9Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Box(modifier = Modifier.fillMaxSize()) {
                Button(
                    onClick = { finish() },
                    modifier = Modifier.align(Alignment.TopEnd)
                ) {
                    Text("홈 ㄱㄱ")
                }
            }
            HomeScreen()
        }
    }
}

@Composable
fun HomeScreen(viewModel: MainViewModel = viewModel()) {

    val text1: MutableState<String> = remember { //내부 값 변경-> 수정X
        mutableStateOf("Hello World")
    }

    var text2: String by remember { //by->text2 변경할 때 set, get 재정의, 활용
        mutableStateOf("Hello World")
    }

    val (text: String, setText: (String) -> Unit) = remember { //구조분해
        mutableStateOf("Hello World") //여기 상태가 계속 변함
    }

    Column() {
        Text("Hello World")
        Button(onClick = {
            text1.value = "변경"
            print(text1.value)
            text2 = "변경"
            print(text2)
            //text="변경"
            setText("변경")

            //viewModel.value.value = "변경"
            viewModel.changeValue("변경")
        }) {
            Text("클릭")
        }
        TextField(value = text, onValueChange = setText)
    }
}

class MainViewModel : ViewModel() {
    private val _value: MutableState<String> = mutableStateOf("Hello World")
    val value: State<String> = _value

    private val _liveData = MutableLiveData<String>()
    val liveData: LiveData<String> = _liveData

    fun changeValue(value: String) {
        _value.value = value
    }
}