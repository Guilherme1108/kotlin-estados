package com.aulasandroid.componentesestado

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.componentesestado.ui.theme.ComponentesEstadoTheme
import com.aulasandroid.componentesestado.ui.theme.InterFont

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentesEstadoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    BasicComponentsScreen(modifier = Modifier.padding(innerPadding))
                    TesteEstadosScreen(modifier = Modifier.padding(innerPadding))

                }
            }
        }
    }
}

@Composable
fun BasicComponentsScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .background(Color(91, 213, 190, 255))
        .fillMaxSize()

    ) {
        Text(
            text = "Aulas android",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            color = Color(241, 74, 98, 255),
            textAlign = TextAlign.End,
            letterSpacing = 4.sp
        )
        Text(
            text = "Com Jetpack Compose",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = InterFont,
        )

    }

}

@Composable
fun TesteEstadosScreen(modifier: Modifier = Modifier) {

    Column(modifier = modifier
        .background(Color.Black)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        val nome = remember {
            mutableStateOf("")
        }

        TextField(
            value = nome.value,
            onValueChange = { novoValor ->
                nome.value = novoValor
            }
        )

        val idade = remember {
            mutableStateOf("")
        }

        TextField(
            value = idade.value,
            onValueChange = { novoValor ->
                idade.value = novoValor
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

    }




}