package com.example.animationincompose

import android.os.Bundle
import android.text.style.StyleSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.animationincompose.ui.theme.AnimationInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationInComposeTheme {
                val composition by rememberLottieComposition(
                    spec = LottieCompositionSpec.Asset("anim.json")
                )
                var isPlaying by remember {
                    mutableStateOf(false)
                }

                var isComplete by remember {
                    mutableStateOf(false)
                }

                val animSpec = LottieClipSpec.Progress(
                    0f,
                    if(isComplete) 1f else 0.5f
                )

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                    )
                {
                    LottieAnimation(
                        composition = composition,
                        isPlaying = isPlaying,
                        speed = 1f,
                        iterations = if(isComplete) 1 else LottieConstants.IterateForever,
                        reverseOnRepeat = true,
                        clipSpec = animSpec,
                    )
                    Button(
                        onClick = {
                            isPlaying = true
                        }) {
                        Text(text = "Download")
                    }

                    Button(
                        onClick = {
                            isComplete = true
                        }) {
                        Text(text = "Finish")
                    }

                    Button(
                        onClick = {
                            isComplete = false
                        }) {
                        Text(text = "Restart")
                    }
                }
            }
        }
    }
}

