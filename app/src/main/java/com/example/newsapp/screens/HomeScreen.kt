package com.example.newsapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.components.HeaderTabs
import com.example.newsapp.icons.Add_home
import com.example.newsapp.ui.theme.NewsAppTheme
import com.example.newsapp.ui.theme.background

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
        // Barra de busqueda
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(30.dp),
            value = "",
            onValueChange = {},
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
                    fontSize = 20.sp
                )
            }
        )

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
        // Filtros
        Row {  }
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