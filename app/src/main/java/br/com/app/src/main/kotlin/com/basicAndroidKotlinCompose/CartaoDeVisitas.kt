package br.com.app.src.main.kotlin.com.basicAndroidKotlinCompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.app.src.main.kotlin.com.greetingcard.R
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.brands.Github
import compose.icons.fontawesomeicons.brands.Linkedin
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
    Card {
        var expanded by remember { mutableStateOf(false) }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF5F9EA0),
                            Color(0xFFD2E8D4)
                        )
                    )
                )
                .padding(16.dp)
                .fillMaxHeight()
                .clickable(indication = null, interactionSource = remember { MutableInteractionSource() }) { expanded = !expanded }
        ) {
            Header (
                modifier = Modifier
                    .fillMaxWidth(),
                expanded = expanded
            )
            AnimatedVisibility(expanded) {
                Column { // Column para adicionar os ícones das redes sociais
                    SocialNetworks(
                        modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                        "GitHub",
                        "https://github.com/igsem123",
                        FontAwesomeIcons.Brands.Github,
                        null,
                        Color.Black
                    )
                    SocialNetworks(
                        modifier = Modifier.fillMaxWidth(),
                        "LinkedIn",
                        "https://linkedin.com/in/raphael-nathan-moreira-a84077216",
                        FontAwesomeIcons.Brands.Linkedin,
                        null,
                        Color(0xFF0A66C2)
                    )
                    SocialNetworks(
                        modifier = Modifier.fillMaxWidth(),
                        "Gmail",
                        "mailto:rnathanmoreira@gmail.com",
                        null,
                        R.drawable.gmail_ic,
                        Color.Unspecified
                    )
                    SocialNetworks(
                        modifier = Modifier.fillMaxWidth(),
                        "Telegram",
                        "https://www.t.me/igsem123",
                        FontAwesomeIcons.Brands.Telegram,
                        null,
                        Color(0xFF24ABEC)
                    )
                }
            }
        }
    }
}

@Composable
private fun Header(modifier: Modifier, expanded: Boolean = false) {
    val rotation by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f,
        animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing),
        label = "FloatAnimation"
    )

    val imagemDaFrente = painterResource(id = R.drawable.android_logo)
    val imagemDeVerso = painterResource(id = R.drawable.avatar)

    Box(
        modifier = modifier.wrapContentHeight(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .graphicsLayer {
                        rotationY = rotation
                        cameraDistance = 25f * density
                    }
            ) {
                if (rotation <= 90f || rotation >= 270f) {
                    Image(
                        painter = imagemDaFrente,
                        contentDescription = "Imagem com a logo do Android",
                        modifier = Modifier
                            .background(Color(0xFF5F9EA0))
                            .size(175.dp)
                            .padding(16.dp),
                        alignment = Alignment.Center
                    )
                } else {
                    Image(
                        painter = imagemDeVerso,
                        contentDescription = "Avatar do desenvolvedor",
                        modifier = Modifier
                            .size(175.dp)
                            .clip(CircleShape)
                            .graphicsLayer(scaleX = -1f),
                        alignment = Alignment.Center,
                    )
                }
            }

            Row(modifier = Modifier.padding(top = 16.dp)) {
                Text(
                    text = "Raphael Nathan Moreira",
                    fontSize = 25.sp,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1f),
                )
            }
            Row {
                Text(
                    text = "Desenvolvedor Mobile",
                    fontSize = 20.sp,
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium,
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
private fun SocialNetworks(modifier: Modifier = Modifier, socialNetworks: String, url: String, icon: ImageVector ?= null, painter: Int ?= null, color: Color) {
    val context = LocalContext.current // Obtém o contexto atual
    Box (modifier = modifier,
        contentAlignment = Alignment.Center) { // Box para centralizar o conteúdo
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            IconButton(
                modifier = Modifier.size(60.dp).animateContentSize(),
                onClick = {
                    val intent = Intent(context, WebViewActivity::class.java)
                    intent.putExtra("url", url)
                    context.startActivity(intent)
                }
            ) {
                if (icon != null) {
                    Icon(
                        imageVector = icon,
                        contentDescription = socialNetworks,
                        tint = color,
                        modifier = modifier.size(45.dp)
                            .clip(RectangleShape)
                    )
                } else if (painter != null) {
                    Icon(
                        painter = painterResource(id = painter),
                        contentDescription = socialNetworks,
                        tint = color,
                        modifier = modifier.size(45.dp)
                            .clip(RectangleShape)
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CartaoDeVisitasPreview() {
    CartaoDeVisitasContent()
}