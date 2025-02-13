package com.example.androidpractice.jetpackCompose.lecture4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

//4강. 리스트, LazyColumn

//스크롤을 만드는 방법 Column<LazyColumn

class Lecture4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val scrollState= rememberScrollState() //스크롤 정보를 기억해주는 객체

            //1. Column으로 만드는 스크롤
            // 스크롤 안에 미리 모든 아이템을 넣어놓음
            //그래서 용량 엄청 차지할 수도 있음
/*
            Column (
                modifier = Modifier
                    .background(color= Color.Green)
                    .fillMaxWidth()
                    .verticalScroll(scrollState) //세로 스크롤
            ) {
                for (i in 1..50) {
                    Text("글씨 $i")
                }
            } */

            //2.LazyColumn으로 만드는 스크롤
            //더 많이 쓰임, 기본 스크롤 내장
            //화면에 보이는 부분만 렌더링해서 최적화

            LazyColumn (
                modifier=Modifier
                    .background(color = Color.Green)
                    .fillMaxWidth()
            ){
                items(50) { index ->
                    Text ("글씨 $index")
                }
            }
        }
    }
}