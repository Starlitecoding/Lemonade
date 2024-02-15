package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}

@Composable
fun LemonApp() {
    var stepCounter by remember { mutableStateOf(1) }
    val lightGreenColor = Color(0xFF92d196)

    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    )

    {
        when (stepCounter) {
            1 -> Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {

                Box(
                    modifier = Modifier
                        .size(250.dp) // Adjust size of the background box as needed
                        .clickable { stepCounter = 2 }
                        .background(color = lightGreenColor, shape = RoundedCornerShape(30.dp)),
                    contentAlignment = Alignment.Center
                )
                {
                    Image(painter = painterResource(id = R.drawable.lemon_tree),
                        contentDescription = stringResource(id = R.string.lemonTree)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

                Text(text = stringResource(id = R.string.tap), fontSize = 20.sp)
            }

            2 -> Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                val squeezeNumber = remember {(1..6).random()}
                var squeezeCounter by remember { mutableStateOf(0) }

                Box(
                    modifier = Modifier
                        .size(250.dp) // Adjust size of the background box as needed
                        .clickable {
                            squeezeCounter += 1
                            if (squeezeCounter == squeezeNumber){
                                stepCounter = 3
                            }
                        }
                        .background(color = lightGreenColor, shape = RoundedCornerShape(30.dp)),
                    contentAlignment = Alignment.Center
                )
                {
                    Image(painter = painterResource(id = R.drawable.lemon_squeeze),
                        contentDescription = stringResource(id = R.string.lemon)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = stringResource(id = R.string.keepTapping), fontSize = 20.sp)
                Text(text = squeezeCounter.toString(), fontSize = 20.sp)
                Text(text = squeezeNumber.toString(), fontSize = 20.sp)
            }

            3 -> Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Box(
                    modifier = Modifier
                        .size(250.dp) // Adjust size of the background box as needed
                        .clickable { stepCounter = 4 }
                        .background(color = lightGreenColor, shape = RoundedCornerShape(30.dp)),
                    contentAlignment = Alignment.Center
                )
                {
                    Image(painter = painterResource(id = R.drawable.lemon_drink),
                        contentDescription = stringResource(id = R.string.lemonGlass)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = stringResource(id = R.string.tapToDrink), fontSize = 20.sp)
            }

            4 -> Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Box(
                    modifier = Modifier
                        .size(250.dp) // Adjust size of the background box as needed
                        .clickable { stepCounter = 1 }
                        .background(color = lightGreenColor, shape = RoundedCornerShape(30.dp)),
                    contentAlignment = Alignment.Center
                )
                {
                    Image(painter = painterResource(id = R.drawable.lemon_restart),
                        contentDescription = stringResource(id = R.string.emptyGlass)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = stringResource(id = R.string.tapRestart), fontSize = 20.sp)
            }


        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}