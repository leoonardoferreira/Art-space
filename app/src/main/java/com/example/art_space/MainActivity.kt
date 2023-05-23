package com.example.art_space

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppArtSpace()
                }
            }
        }
    }
}

@Preview
@Composable

fun AppArtSpace(){
    var art by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Card() {
            Image(
                painter = painterResource(id = R.drawable.art_space1),
                contentDescription = "Fotografia de alguma arte ou paisagem",
                modifier = Modifier.padding(40.dp)
            )
        }
        Card() {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(5.dp)
            ) {
                Text(
                    text = "Título da Obra",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
                Spacer(
                    modifier = Modifier.size(5.dp))
                Text(
                    text = "Artista (ano)",
                    fontSize = 16.sp
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = {}) {
                Text(text = "Anterior")
            }
            Button(onClick = {}) {
                Text(text = "Próxima")
            }
        }
    }
}