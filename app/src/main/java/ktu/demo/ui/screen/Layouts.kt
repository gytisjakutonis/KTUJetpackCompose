package ktu.demo.ui.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderState
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyScreenWithLayouts() {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Row(modifier = Modifier.padding(20.dp).border(width = 2.dp, color = Color.Blue)) {
            Text(text = "this", modifier = Modifier.padding(5.dp).border(width = 1.dp, color = Color.Blue).padding(5.dp))
            Text(text = "is", modifier = Modifier.padding(5.dp).border(width = 1.dp, color = Color.Blue).padding(5.dp))
            Text(text = "row", modifier = Modifier.padding(5.dp).border(width = 1.dp, color = Color.Blue).padding(5.dp))
        }

        Column(modifier = Modifier.padding(20.dp).border(width = 2.dp, color = Color.Blue)) {
            Text(text = "this", modifier = Modifier.padding(5.dp).border(width = 1.dp, color = Color.Blue).padding(5.dp))
            Text(text = "is", modifier = Modifier.padding(5.dp).border(width = 1.dp, color = Color.Blue).padding(5.dp))
            Text(text = "column", modifier = Modifier.padding(5.dp).border(width = 1.dp, color = Color.Blue).padding(5.dp))
        }

        Box(modifier = Modifier.padding(20.dp).border(width = 2.dp, color = Color.Blue)) {
            Text(text = "this is box", modifier = Modifier.padding(5.dp).border(width = 1.dp, color = Color.Blue).padding(5.dp))
        }
    }
}

@Preview
@Composable
private fun PreviewMyScreenWithLayouts() {
    MyScreenWithLayouts()
}