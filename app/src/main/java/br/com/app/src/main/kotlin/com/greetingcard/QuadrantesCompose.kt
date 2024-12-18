package br.com.app.src.main.kotlin.com.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class QuadrantesCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuadrantesComposeContent()
        }
    }
}

@Composable
private fun QuadrantesComposeContent() {
    Column {
        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
            modifier = Modifier.weight(1f)) {
            Quadrante("Text composable", "Displays text and follows the recommended Material Design guidelines.",  Modifier.weight(1f), Color(0xFFEADDFF))
            Quadrante("Image composable", "Creates a composable that lays out and draws a given Painter class object.", Modifier.weight(1f), Color(0xFFD0BCFF))
            }
        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
            modifier = Modifier.weight(1f)) {
            Quadrante("Row composable", "A layout composable that places its children in a horizontal sequence.", Modifier.weight(1f), Color(0xFFB69DF8))
            Quadrante("Column composable", "A layout composable that places its children in a vertical sequence." ,Modifier.weight(1f), Color(0xFFF6EDFF))
        }
    }
}

@Composable
fun Quadrante(t: String, text: String, weight: Modifier, color: Color) {
    Column(verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        modifier = weight.background(color).fillMaxHeight()) {
        Text(
            t,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            modifier = Modifier.padding(16.dp),
            color = Color.Black,
            fontSize = 20.sp
            )
        Text(
            text,
            textAlign = androidx.compose.ui.text.style.TextAlign.Justify,
            color = Color.Black,
            fontSize = 16.sp,
            modifier = Modifier.padding(16.dp)
            )
    }
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
private fun QuadrantesComposePreview() {
    QuadrantesComposeContent()
}