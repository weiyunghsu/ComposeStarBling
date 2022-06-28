package com.weiyung.compose

import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.weiyung.compose.ui.theme.ComposeTheme

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
    Column(verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        IconButton(
            onClick = { Log.d("AAA","Star clicked.")},
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_icon_star0),
                contentDescription = null // decorative element
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(
                onClick = { Log.d("AAA","Undo clicked.")},
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_undo),
                    contentDescription = null // decorative element
                )
            }
            Text(text = "default")
            IconButton(
                onClick = { Log.d("AAA","Redo clicked.")},
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_redo),
                    contentDescription = null // decorative element
                )
            }
        }

        Row() {
            Canvas(modifier = Modifier.size(80.dp), onDraw = {
                drawRect(
                    color = Blue
                )
            })
            Canvas(modifier = Modifier.size(80.dp), onDraw = {
                drawRect(
                    color = Green
                )
            })
            Canvas(modifier = Modifier.size(80.dp), onDraw = {
                drawRect(
                    color = Red
                )
            })
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
