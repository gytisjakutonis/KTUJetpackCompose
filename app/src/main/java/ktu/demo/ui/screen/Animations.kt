package ktu.demo.ui.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyScreenWithAnimations() {
    TweenVsSpringAnimation()
}

@Composable
fun AnimatedState() {
    var rotate by remember { mutableStateOf(false) }
    val rotationAngle by animateFloatAsState(
        targetValue = if (rotate) 90f else 0f,
        animationSpec = tween(500)
    )
    val backgroundColor by animateColorAsState(
        targetValue = if (rotate)
            Color.Green else Color.Blue,
        animationSpec = tween(1000)
    )
    Box(
        modifier = Modifier
            .size(100.dp)
            .rotate(degrees = rotationAngle)
            .background(color = backgroundColor)
            .clickable { rotate = !rotate }
    )
}

@Composable
fun AnimatedDisplay() {
    var visible by remember {
        mutableStateOf(false)
    }
    Row {
        Button(onClick = { visible = !visible }) {
            Text(if (visible) "Hide" else "Show")
        }
        AnimatedVisibility(visible = visible) {
            Box(
                modifier = Modifier
                    .size(height = 40.dp, width = 100.dp)
                    .background(color = Color.Red)
                    .clickable { visible = !visible }
            )
        }
    }
}

@Composable
fun AnimatedContents() {
    var count by remember {
        mutableIntStateOf(0)
    }

    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        ClickButton { count++ }

        AnimatedContent(
            targetState = count,
            transitionSpec = {
                slideInHorizontally { it } +
                        fadeIn() togetherWith
                        slideOutHorizontally { -it } +
                        fadeOut()
            }
        ) { targetClicks ->
            ClickText(targetClicks)
        }
    }
}

@Composable
fun TweenVsSpringAnimation() {
    var isAtEnd by remember { mutableStateOf(false) }

    val tweenOffsetX by animateDpAsState(
        targetValue = if (isAtEnd) 200.dp else 0.dp,
        animationSpec = tween(durationMillis = 1000,
            easing = LinearOutSlowInEasing)
    )

    val springOffsetX by animateDpAsState(
        targetValue = if (isAtEnd) 200.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable { isAtEnd = !isAtEnd }
    ) {
        // Box using tween animation
        Box(
            modifier = Modifier
                .offset(x = tweenOffsetX, y = 200.dp)
                .size(50.dp)
                .background(Color.Blue)
        )

        // Box using spring animation
        Box(
            modifier = Modifier
                .offset(x = springOffsetX, y = 300.dp)
                .size(50.dp)
                .background(Color.Red)
        )
    }
}

@Preview
@Composable
private fun PreviewMyScreenWithAnimations() {
    MyScreenWithAnimations()
}