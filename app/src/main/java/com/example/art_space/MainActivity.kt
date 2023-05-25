package com.example.art_space

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.art_space.ui.theme.ArtspaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtspaceTheme {
                // A surface container using the 'background' color from the theme
                AppArtSpace()
            }
        }
    }
}

@Preview
@Composable
fun AppArtSpace(){
    var art by remember { mutableStateOf(1) }
    var idImage by remember { mutableStateOf(1) }
    var title by remember { mutableStateOf("") }
    var artist by remember { mutableStateOf("") }

    when (art) {
        1 -> {
            idImage = R.drawable.art_space1
            title = "A apoteose de Hércules"
            artist = "François Lemoyne (1736)"
        }
        2 -> {
            idImage = R.drawable.art_space2
            title = "Preto & Amarelo"
            artist = "murakamistudio"
        }
        3 -> {
            idImage = R.drawable.art_space3
            title = "Arte suíça"
            artist = "Artista desconhecido"
        }

        4 -> {
            idImage = R.drawable.art_space4
            title = "Nuvens no céu"
            artist = "Fotografado por Youssef Naddam"
        }
        5 -> {
            idImage = R.drawable.art_space5
            title = "Foto de Paso di Glau, Italia"
            artist = "Nicola Pavan"
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = idImage),
                contentDescription = "Fotografia de alguma arte ou paisagem",
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .size(400.dp),
                contentScale = ContentScale.Crop

            )
            Card() {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(5.dp)
                ) {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                    Spacer(
                        modifier = Modifier.size(5.dp))
                    Text(
                        text = artist,
                        fontSize = 16.sp
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 40.dp)
            ,
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom,
        ) {
            NavButton(
                text = "Anterior",

            ) {
                if(art>1)
                    art--
            }
            NavButton(
                text = "Próxima",
            ) {
                if(art<5)
                    art++
            }
        }
    }
}


@Composable
fun NavButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(Color(100, 125, 85))
    ) {
        Text(
            text = text,
            color = Color.White
        )
    }
}