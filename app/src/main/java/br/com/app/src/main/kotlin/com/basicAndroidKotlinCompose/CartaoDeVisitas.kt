package br.com.app.src.main.kotlin.com.basicAndroidKotlinCompose

import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.app.src.main.kotlin.com.greetingcard.R
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.brands.Github
import compose.icons.fontawesomeicons.brands.Google
import compose.icons.fontawesomeicons.brands.LinkedinIn
import compose.icons.fontawesomeicons.brands.Telegram

class CartaoDeVisitas : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CartaoDeVisitasContent()
        }
    }
}

@Composable
private fun CartaoDeVisitasContent() {
    Column (modifier = Modifier.background(Color(0xFFD2E8D4)).padding(16.dp)){
        Header(modifier = Modifier
            .weight(1f)
            .fillMaxWidth())
        SocialNetworks("GitHub", "https://github.com/igsem123", FontAwesomeIcons.Brands.Github, modifier = Modifier.fillMaxWidth())
        SocialNetworks("LinkedIn", "https://linkedin.com/in/raphael-nathan-moreira-a84077216", FontAwesomeIcons.Brands.LinkedinIn, modifier = Modifier.fillMaxWidth())
        SocialNetworks("Gmail", "mailto:rnathanmoreira@gmail.com", FontAwesomeIcons.Brands.Google, modifier = Modifier.fillMaxWidth())
        SocialNetworks("Telegram", "https://t.me/igsem123", FontAwesomeIcons.Brands.Telegram, modifier = Modifier.fillMaxWidth())
    }
}

@Composable
private fun Header(modifier: Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box (Modifier.clip(CircleShape)) {
                Image(
                    painter = painterResource(id = R.drawable.android_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .background(Color(0xFF5F9EA0))
                        .size(150.dp)
                        .padding(16.dp),
                    alignment = Alignment.Center
                )
            }
            Row {
                Text(
                    text = "Raphael Nathan Moreira",
                    fontSize = 25.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1f)
                )
            }
            Row {
                Text(
                    text = "Desenvolvedor Android",
                    fontSize = 20.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .weight(1f)
                )
            }
        }
    }
}

@Composable
private fun SocialNetworks(socialNetworks: String, url: String, icon: ImageVector, modifier: Modifier = Modifier) {
    val context = LocalContext.current // obtém o contexto atual
    Box (modifier = modifier,
        contentAlignment = Alignment.Center) { // Box para centralizar o conteúdo
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            IconButton(onClick = {
                val intent = Intent(context, WebViewActivity::class.java)
                intent.putExtra("url", url)
                context.startActivity(intent)
            }
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = socialNetworks,
                    tint = Color.Black,
                    modifier = modifier.size(30.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CartaoDeVisitasPreview() {
    CartaoDeVisitasContent()
}