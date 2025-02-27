package com.example.androidpractice

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidpractice.jetpackCompose.lecture1to3.Lecture1to3Activity
import com.example.androidpractice.jetpackCompose.lecture4.Lecture4Activity
import com.example.androidpractice.jetpackCompose.lecture5.Lecture5Activity
import com.example.androidpractice.jetpackCompose.lecture6.Lecture6Activity
import com.example.androidpractice.jetpackCompose.lecture7.Lecture7Activity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }

    @Composable
    fun HomeScreen() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("이재인 안드로이드 공부", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                startActivity(Intent(this@MainActivity, Lecture1to3Activity::class.java))
            }) {
                Text("1강~3강")
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {
                startActivity(Intent(this@MainActivity, Lecture4Activity::class.java))
            }) {
                Text("4강")
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {
                startActivity(Intent(this@MainActivity, Lecture5Activity::class.java))
            }) {
                Text("5강: Image, Card, 상태")
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {
                startActivity(Intent(this@MainActivity, Lecture6Activity::class.java))
            }) {
                Text("6강: Scaffold, TextField, Button, 구조분해, SnackBar, 코루틴 스코프")
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {
                startActivity(Intent(this@MainActivity, Lecture7Activity::class.java))
            }) {
                Text("7강: Navigation")
            }
        }
    }
}
//intent 말고 navigation 써보자
class Lecture1to3Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LectureScreen("1~3강", this@Lecture1to3Activity)
        }
    }
}

class Lecture4Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LectureScreen("4강", this)
        }
    }
}

class Lecture5Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LectureScreen("5강: Image, Card, 상태", this)
        }
    }
}

class Lecture6Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LectureScreen(
                "6강: Scaffold, TextField, Button, 구조분해, SnackBar, 코루틴 스코프",
                this
            )
        }
    }
}

class Lecture7Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LectureScreen(
                "7강: Navigation",
                this
            )
        }
    }
}

@Composable
fun LectureScreen(title: String, activity: ComponentActivity) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(title, fontSize = 24.sp)
        }

        Button(
            onClick = {
                val intent = Intent(activity, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                activity.startActivity(intent)
            },
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Text("홈ㄱㄱ")
        }
    }
}