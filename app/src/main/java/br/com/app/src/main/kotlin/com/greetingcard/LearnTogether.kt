package br.com.app.src.main.kotlin.com.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class LearnTogether : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnTogether()
        }
    }

    @Composable
    fun LearnTogetherImage(modifier: Modifier = Modifier) {
        Box(modifier = modifier) {
            Image(
                painter = painterResource(id = R.drawable.bg_compose_background),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
            )
        }
    }

    @Composable
    fun LearnTogetherText(title: String, text: String, text2: String, modifier: Modifier = Modifier) {
        Column(modifier = Modifier
            .padding(16.dp)) {
            Text(
                text = title,
                fontSize = 25.sp,
                color = Color.Black,
                textAlign = TextAlign.Left,
                modifier = Modifier.align(Alignment.Start)
                    .padding(bottom = 16.dp)
            )
            Text(
                text = text,
                fontSize = 20.sp,
                color = Color.Black,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = text2,
                fontSize = 20.sp,
                color = Color.Black,
                textAlign = TextAlign.Justify
            )
        }
    }

    @Preview (showBackground = true, showSystemUi = true)
    @Composable
    fun PreviewLearnTogetherImage() {
        Column {
            LearnTogetherImage()
            LearnTogetherText(
                title = stringResource(R.string.learn_together_title),
                text = stringResource(R.string.learn_together_text),
                text2 = stringResource(R.string.learn_together_text2)
            )
        }
    }
}