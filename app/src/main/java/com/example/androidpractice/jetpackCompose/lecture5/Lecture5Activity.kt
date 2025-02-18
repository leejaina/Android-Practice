package com.example.androidpractice.jetpackCompose.lecture5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable

class Lecture5Activity:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageCard()
        }
    }
}

@Composable //컴포져블로 만들어서 쓸거에염 -> 카드 형식 언제라도 재활용 ㄱㄴ
fun ImageCard() {

}