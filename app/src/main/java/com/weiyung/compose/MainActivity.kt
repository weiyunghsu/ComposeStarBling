package com.weiyung.compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.weiyung.compose.ui.theme.ComposeTheme
import com.weiyung.compose.ui.theme.Purple40
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

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
        var starColor by remember { mutableStateOf(0) }
        var starRotateStatus by remember{ mutableStateOf(0)}

        var flag by remember { mutableStateOf(true) }
        val rotation = remember { Animatable(0f) }
        val scope = rememberCoroutineScope()
        val rotationValue = rotation.value.toInt()

        var offsetX by remember { mutableStateOf(0f) }
        var offsetY by remember { mutableStateOf(0f) }

        Canvas(modifier = Modifier.size(20.dp),
            onDraw = {
                drawRect(
                    color = Transparent,
                )
            })
        Text(text = "$rotationValue")
        IconButton(
            modifier = Modifier
                .height(80.dp)
                .width(80.dp)
                .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        offsetX += dragAmount.x
                        offsetY += dragAmount.y
                    }
                },
            onClick = {
                starStatus = 1
                Log.d("AAA","Star clicked.")},
        ) {
            Icon(
                painter = painterResource(
                    if (starStatus == 0) StarSelected.Star.icon
                    else StarSelected.Star.iconSelected
                        ),
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp)
                    .rotate(rotation.value),
                tint =
                when (starColor) {
                    0 -> Magenta
                    1 -> Blue
                    2 -> Green
                    3 -> Red
                    else -> { }
                } as Color,
                contentDescription = null
            )
        }

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically) {
            IconButton(
                modifier = Modifier
                    .height(48.dp)
                    .width(48.dp),
                onClick = {
                    scope.launch {
                        rotation.animateTo(
                            targetValue = rotation.targetValue - 30,
                            animationSpec = tween(500, easing = LinearEasing)
                        )
                    }
                    Log.d("AAA","Undo clicked.")}

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_undo),
                    modifier = Modifier.padding(8.dp),
                    contentDescription = null
                )
            }
            Button(
                onClick = {
                    starStatus = 0
                    starColor = 0
                    Log.d("AAA", "button default clicked.")},
                colors = ButtonDefaults.buttonColors(
                    Transparent,
                    contentColor = Purple40
                ),
            ) {
                Text("default")
            }
            IconButton(
                modifier = Modifier
                    .height(48.dp)
                    .width(48.dp),
                onClick = {
                    scope.launch {
                        rotation.animateTo(
                            targetValue = rotation.targetValue + 30,
                            animationSpec = tween(500, easing = LinearEasing)
                        )
                    }
                    Log.d("AAA","Redo clicked.")},
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_redo),
                    modifier = Modifier.padding(8.dp),
                    contentDescription = null
                )
            }
        }

        Row(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Box(Modifier.clickable {
                starColor = 1
                Log.i("AAA", "Blue box clicked.")}
            ) {
                Canvas(modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp),
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
                            strokeWidth = 5F
                        )
                        drawLine(
                            start = Offset(x = 0F, y = 0F),
                            end = Offset(x = canvasWidth, y = 0F),
                            color = Black,
                            strokeWidth = 5F
                        )
                        drawLine(
                            start = Offset(x = canvasWidth, y = 0F),
                            end = Offset(x = canvasWidth, y = canvasHeight),
                            color = Black,
                            strokeWidth = 5F
                        )
                        drawLine(
                            start = Offset(x = 0F, y = canvasHeight),
                            end = Offset(x = canvasWidth, y = canvasHeight),
                            color = Black,
                            strokeWidth = 5F
                        )
                    })
            }
            Box(Modifier.clickable {
                starColor = 2
                Log.i("AAA", "Green box clicked.")}
            ) {
                Canvas(modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp),
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
                            strokeWidth = 5F
                        )
                        drawLine(
                            start = Offset(x = 0F, y = 0F),
                            end = Offset(x = canvasWidth, y = 0F),
                            color = Black,
                            strokeWidth = 5F
                        )
                        drawLine(
                            start = Offset(x = canvasWidth, y = 0F),
                            end = Offset(x = canvasWidth, y = canvasHeight),
                            color = Black,
                            strokeWidth = 5F
                        )
                        drawLine(
                            start = Offset(x = 0F, y = canvasHeight),
                            end = Offset(x = canvasWidth, y = canvasHeight),
                            color = Black,
                            strokeWidth = 5F
                        )
                    })
            }
            Box(Modifier.clickable {
                starColor = 3
                Log.i("AAA", "Red box clicked.")}
            ) {
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
                            strokeWidth = 5F
                        )
                        drawLine(
                            start = Offset(x = 0F, y = 0F),
                            end = Offset(x = canvasWidth, y = 0F),
                            color = Black,
                            strokeWidth = 5F
                        )
                        drawLine(
                            start = Offset(x = canvasWidth, y = 0F),
                            end = Offset(x = canvasWidth, y = canvasHeight),
                            color = Black,
                            strokeWidth = 5F
                        )
                        drawLine(
                            start = Offset(x = 0F, y = canvasHeight),
                            end = Offset(x = canvasWidth, y = canvasHeight),
                            color = Black,
                            strokeWidth = 5F
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
