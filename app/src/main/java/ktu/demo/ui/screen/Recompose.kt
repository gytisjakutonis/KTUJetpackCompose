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
fun MyScreenWithClickCount() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        MyClickCounterWithSaveableState()
    }
}

@Composable
fun MyClickCounter() {
    var clicks = 0
    Button(onClick = { clicks++ }) {
        Text(text = "Click Me")
    }
    Text(text = "Total clicks: $clicks")
}

@Composable
fun MyClickCounterWithState() {
    var clicks by remember {
        mutableIntStateOf(0)
    }
    Button(onClick = { clicks++ }) {
        Text(text = "Click Me")
    }
    Text(text = "Total clicks: $clicks")
}

@Composable
fun MyClickCounterWithSaveableState() {
    var clicks by rememberSaveable {
        mutableIntStateOf(0)
    }
    Button(onClick = { clicks++ }) {
        Text(text = "Click Me")
    }
    Text(text = "Total clicks: $clicks")
}

@Preview
@Composable
private fun PreviewMyScreenWithClickCount() {
    MyScreenWithClickCount()
}