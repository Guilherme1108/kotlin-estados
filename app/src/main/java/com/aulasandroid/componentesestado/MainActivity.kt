package com.aulasandroid.componentesestado

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
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

    var backgroundColor by remember {
        mutableStateOf(Color(234, 158, 158, 255))
    }

    Column(modifier = modifier
        .background(backgroundColor)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        var nome by remember {
            mutableStateOf("")
        }

        var idade by remember {
            mutableStateOf("")
        }

        var email by remember {
            mutableStateOf("batata@email")
        }

        var jCompose by remember {
            mutableStateOf(false)
        }

        var xml by remember {
            mutableStateOf(false)
        }

        var sOperacional by remember {
            mutableStateOf("")
        }

        TextField(
            value = nome,
            onValueChange = { novoValor ->
                nome = novoValor
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words
            ),
            placeholder = {
                Text(text = "Digite seu nome e sobrenome")
            },
            label = {
                Text(text = "Nome completo")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Person Icon",
                    tint = Color(100, 95, 173, 255)
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Person Icon",
                    tint = Color(100, 95, 173, 255)
                )
            }
        )


        TextField(
            value = idade,
            onValueChange = { novoValor ->
                idade = novoValor
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = {
                Text(text = "Digite sua idade")
            },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color(208, 13, 13, 255),
                unfocusedTextColor = Color(27, 92, 215, 255),
                unfocusedPlaceholderColor = Color(37, 236, 43, 255)
            ),
            shape = RoundedCornerShape(topStart = 20.dp, bottomEnd = 20.dp)
        )


        OutlinedTextField(
            value = email,
            onValueChange = { email = it},
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Email")
            },
            placeholder = {
                Text(text = "Digite seu email")
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color(208, 13, 13, 255),
                unfocusedTextColor = Color(27, 92, 215, 255),
                unfocusedPlaceholderColor = Color(37, 236, 43, 255),
                focusedBorderColor = Color(245, 188, 43, 255),
                unfocusedBorderColor = Color(250, 91, 17, 255)
            )
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = jCompose,
                onCheckedChange = { jCompose = it},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Green,
                    uncheckedColor = Color.Red
                )
            )

            Text(text = "Jetpack Compose")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = xml,
                onCheckedChange = { xml = it}
            )

            Text(text = "Jetpack Compose")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = sOperacional == "android",
                onClick = { sOperacional = "android" }
            )

            Text(text = "Android")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = sOperacional == "ios",
                onClick = { sOperacional = "ios" }
            )

            Text(text = "IOS")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = sOperacional == "wPhone",
                onClick = { sOperacional = "wPhone" }
            )

            Text(text = "Windows Phone")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                    backgroundColor = Color(142, 94, 208, 255)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.Black
                ),
                border = BorderStroke(width = 4.dp, Color.Cyan),
                shape = RoundedCornerShape(topEnd = 10.dp, bottomStart = 10.dp)
            ) {

                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Star Icon"
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(text = "Clique aqui")
            }

            OutlinedButton(
                onClick = {
                    backgroundColor = Color(222, 165, 80, 255)
                }
            ) {
                Text(text = "Outro botão")
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            var favoritado by remember {
                mutableStateOf(false)
            }

            if (favoritado ) {
                Icon(
                    modifier = Modifier.clickable{
                        favoritado = false
                    },
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite Icon",
                )
            } else {
                Icon(
                    modifier = Modifier.clickable{
                        favoritado = true
                    },
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite border Icon"
                )
            }


        }


    }




}