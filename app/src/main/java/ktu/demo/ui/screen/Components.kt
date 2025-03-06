package ktu.demo.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyScreenWithComponents() {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "this is text", modifier = Modifier.padding(5.dp))
        Button(onClick = {}, modifier = Modifier.padding(5.dp)) {
            Text("click me")
        }
        Switch(checked = false, onCheckedChange = {}, modifier = Modifier.padding(5.dp))
        RadioButton(selected = false, onClick = {}, modifier = Modifier.padding(5.dp))
        CircularProgressIndicator(progress = { 0.8F }, modifier = Modifier.padding(5.dp))
    }
}

@Preview
@Composable
private fun PreviewMyScreenWithComponents() {
    MyScreenWithComponents()
}