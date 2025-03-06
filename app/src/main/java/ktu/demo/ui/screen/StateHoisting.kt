package ktu.demo.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyScreenWithStateHoisting() {
    var clicks by remember {
        mutableIntStateOf(0)
    }

    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ClickCounter()
    }
}

@Composable
fun ClickCounter() {
    var clicks by remember {
        mutableIntStateOf(0)
    }
    ClickButton { clicks++ }
    ClickText(clicks)
}

@Composable
fun ClickButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = "Click Me")
    }
}

@Composable
fun ClickText(clicks: Int) {
    Text(text = "Total clicks: $clicks")
}

@Preview
@Composable
private fun PreviewMyScreenWithStateHoisting() {
    MyScreenWithStateHoisting()
}