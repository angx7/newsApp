package com.example.newsapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.components.HeaderTabs
import com.example.newsapp.components.NewsGrid
import com.example.newsapp.components.NoticiasPrincipales
import com.example.newsapp.icons.Add_home
import com.example.newsapp.ui.theme.NewsAppTheme
import com.example.newsapp.ui.theme.background
import com.example.newsapp.R


@Composable
fun HomeScreen(innerPadding : PaddingValues) {
    var query by remember { mutableStateOf("") }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(background)
            .padding(innerPadding)
            .padding(20.dp)

    ){
        var value by remember {
            mutableStateOf("")
        }
        // Barra de busqueda
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(30.dp),
            value = value,
            onValueChange = {
                value = it
            },
            leadingIcon = {
                Icon(
                    imageVector = Add_home,
                    contentDescription = null
                )
            },
            placeholder ={
                Text(
                    text = "Buscar",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }
        )

        // Filtros

        HeaderTabs(
            tabs = listOf("Noticias", "Eventos", "Clima"),
            onTabSelected = { idx ->
                when (idx) {
                    0 -> println("Noticias seleccionado")
                    1 -> println("Eventos seleccionado")
                    2 -> println("Clima seleccionado")
                }
            }
        )

        // Encabezado

        Text(
            text = stringResource(R.string.lastnews),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 20.dp, bottom = 20.dp)
        )

        NoticiasPrincipales()

        // Contenido principal

        Text(
            text = stringResource(R.string.around_the_world),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 20.dp, bottom = 20.dp)
        )

        NewsGrid()

    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HomeScreenPreview() {
    NewsAppTheme {
        HomeScreen(innerPadding = PaddingValues(0.dp))
    }
}