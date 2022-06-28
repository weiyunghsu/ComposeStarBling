package com.weiyung.compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.weiyung.compose.ui.theme.ComposeTheme
import com.weiyung.compose.ui.theme.Purple40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StarChangeColor()
                }
            }
        }
    }
}
// 1.讓星星變大80dp
// 2.改變星星變成實心
// 3.三個方塊分散對齊
// 4.按左右旋轉紐讓星星旋轉
@Composable
fun StarChangeColor() {
    // 存一個狀態，當點擊時會旋轉
    Column(verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {

        IconButton(
            onClick = {
                Log.d("AAA","Star clicked.")},
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_icon_star0),
                tint = Yellow,
                modifier = Modifier
                    .height(80.dp).width(80.dp),
                contentDescription = null
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(
                onClick = {
                    Log.d("AAA","Undo clicked.")},
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_undo),
                    modifier = Modifier.padding(8.dp),
                    contentDescription = null
                )
            }
            Button(
                onClick = {Log.d("AAA", "button default clicked.")},
                colors = ButtonDefaults.buttonColors(
                    White,
                    contentColor = Purple40
                ),
            ) {
                Text("default")
            }
            IconButton(
                onClick = {
                    Log.d("AAA","Redo clicked.")},
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_redo),
                    modifier = Modifier.padding(8.dp),
                    contentDescription = null
                )
            }
        }

        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            Box() {
                Canvas(modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp),
                    onDraw = {
                        drawRect(
                            color = Blue,
                        )
                    })
                Canvas(modifier = Modifier
                    .size(80.dp),
                    onDraw = {
                        val canvasWidth = size.width
                        val canvasHeight = size.height
                        drawLine(
                            start = Offset(x = 0F, y = 0F),
                            end = Offset(x = 0F, y = canvasHeight),
                            color = Black,
                            strokeWidth = 2F
                        )
                        drawLine(
                            start = Offset(x = 0F, y = 0F),
                            end = Offset(x = canvasWidth, y = 0F),
                            color = Black,
                            strokeWidth = 2F
                        )
                        drawLine(
                            start = Offset(x = canvasWidth, y = 0F),
                            end = Offset(x = canvasWidth, y = canvasHeight),
                            color = Black,
                            strokeWidth = 2F
                        )
                        drawLine(
                            start = Offset(x = 0F, y = canvasHeight),
                            end = Offset(x = canvasWidth, y = canvasHeight),
                            color = Black,
                            strokeWidth = 2F
                        )
                    })
            }
            Box() {
                Canvas(modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp),
                    onDraw = {
                        drawRect(
                            color = Green,
                        )
                    })
                Canvas(modifier = Modifier
                    .size(80.dp),
                    onDraw = {
                        val canvasWidth = size.width
                        val canvasHeight = size.height
                        drawLine(
                            start = Offset(x = 0F, y = 0F),
                            end = Offset(x = 0F, y = canvasHeight),
                            color = Black,
                            strokeWidth = 2F
                        )
                        drawLine(
                            start = Offset(x = 0F, y = 0F),
                            end = Offset(x = canvasWidth, y = 0F),
                            color = Black,
                            strokeWidth = 2F
                        )
                        drawLine(
                            start = Offset(x = canvasWidth, y = 0F),
                            end = Offset(x = canvasWidth, y = canvasHeight),
                            color = Black,
                            strokeWidth = 2F
                        )
                        drawLine(
                            start = Offset(x = 0F, y = canvasHeight),
                            end = Offset(x = canvasWidth, y = canvasHeight),
                            color = Black,
                            strokeWidth = 2F
                        )
                    })
            }
            Box() {
                Canvas(modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp),
                    onDraw = {
                        drawRect(
                            color = Red,
                        )
                    })
                Canvas(modifier = Modifier
                    .size(80.dp),
                    onDraw = {
                        val canvasWidth = size.width
                        val canvasHeight = size.height
                        drawLine(
                            start = Offset(x = 0F, y = 0F),
                            end = Offset(x = 0F, y = canvasHeight),
                            color = Black,
                            strokeWidth = 2F
                        )
                        drawLine(
                            start = Offset(x = 0F, y = 0F),
                            end = Offset(x = canvasWidth, y = 0F),
                            color = Black,
                            strokeWidth = 2F
                        )
                        drawLine(
                            start = Offset(x = canvasWidth, y = 0F),
                            end = Offset(x = canvasWidth, y = canvasHeight),
                            color = Black,
                            strokeWidth = 2F
                        )
                        drawLine(
                            start = Offset(x = 0F, y = canvasHeight),
                            end = Offset(x = canvasWidth, y = canvasHeight),
                            color = Black,
                            strokeWidth = 2F
                        )
                    })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTheme {
        StarChangeColor()
    }
}
