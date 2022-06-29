package com.weiyung.compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
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
@Composable
fun StarChangeColor() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var starStatus by remember { mutableStateOf(0) }
        Canvas(modifier = Modifier.size(20.dp),
            onDraw = {
                drawRect(
                    color = Transparent,
                )
            })
        IconButton(
            modifier = Modifier.height(80.dp).width(80.dp),
            onClick = {
                starStatus = 1
                Log.d("AAA","Star clicked.")},
        ) {
            Icon(
                painter = painterResource(
                    if (starStatus == 0) StarSelected.Star.icon
                    else StarSelected.Star.iconSelected
                        ),
                modifier = Modifier.height(80.dp).width(80.dp),
                tint = Magenta,
                contentDescription = null
            )
        }

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically) {
            IconButton(
                modifier = Modifier.height(48.dp).width(48.dp),
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
                modifier = Modifier.height(48.dp).width(48.dp),
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

        Row(modifier = Modifier.fillMaxHeight().fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Box(Modifier.clickable {
                Log.i("AAA", "Blue box clicked.")}
            ) {
                Canvas(modifier = Modifier.size(80.dp).padding(8.dp),
                    onDraw = {
                        drawRect(
                            color = Blue,
                        )
                    })
                Canvas(modifier = Modifier.size(80.dp),
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
            Box(Modifier.clickable {
                Log.i("AAA", "Green box clicked.")}
            ) {
                Canvas(modifier = Modifier.size(80.dp).padding(8.dp),
                    onDraw = {
                        drawRect(
                            color = Green,
                        )
                    })
                Canvas(modifier = Modifier.size(80.dp),
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
            Box(Modifier.clickable {
                Log.i("AAA", "Red box clicked.")}
            ) {
                Canvas(modifier = Modifier.size(80.dp).padding(8.dp),
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
sealed class StarSelected(val icon: Int, val iconSelected: Int) {
    object Star : StarSelected(R.drawable.ic_icon_star0, R.drawable.ic_icon_star1)
}
