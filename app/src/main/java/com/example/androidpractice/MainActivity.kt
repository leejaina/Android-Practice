package com.example.androidpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidpractice.ui.theme.AndroidPracticeTheme
import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { // 코드가 시작되는 부분?
            AndroidPracticeTheme {
                /*Surface( //속성 지정->꾸미기
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column ( //수직으로 나열
                        modifier=Modifier //modifier가 대충 속성 대장?
                            .fillMaxSize()
                            .background(color= Color.Blue)
                            .padding(16.dp), //패딩이 뭐야?
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                        //.aaa.bbb 차례대로 실행되므로 순서 주의!
                    ){ //(괄호 안) 컨텐츠
                        Text("Hello")
                        Text("World")
                    }
                    Row ( //수평으로 나열
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text("Hello")
                        Spacer(Modifier.width(16.dp)) //띄어쓰기
                        Text("World")
                    }
                } */
                //Box특: 안에 있는 자식들이 다 겹쳐보임
                Box(modifier = Modifier.background(color = Color.Green)
                    .fillMaxWidth() //가로로 형광펜 쫙
                    //.fillMaxHeight() //세로로 형광펜 쫙
                    //.fillMaxSize() //전체 칠하기
                    .height(200.dp),
                    contentAlignment = Alignment.TopEnd //글씨 옮기기
                ) {
                    Text("Hello")
                    Box( //Box안의 Box 마트료시카 가능
                        modifier = Modifier.fillMaxSize()
                            .padding(16.dp),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        Text("World")
                    }
                }
            }
        }
    }
}

@Preview //Preview: Split 미리보기로 볼 수 있음, 여러개 가능
@Composable
fun PreviewMainScreen() { //Composable 에서는 함수가 대문자로 시작
    AndroidPracticeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Text("Hello")
        }
    }
}