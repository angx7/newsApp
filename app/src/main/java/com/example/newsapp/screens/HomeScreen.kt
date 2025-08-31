package com.example.newsapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.components.HeaderTabs
import com.example.newsapp.icons.Add_home
import com.example.newsapp.ui.theme.NewsAppTheme
import com.example.newsapp.ui.theme.RecentCards
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

        val noticias = listOf<String>(
            "El presidente de EE.UU. no muestra signos de arrepentimiento...",
            "La economía global enfrenta desafíos sin precedentes...",
            "Científicos descubren una nueva especie en la Amazonía...",
            "La tecnología 5G revoluciona las comunicaciones móviles...",
            "El cambio climático amenaza la biodiversidad mundial...",
            "Avances en inteligencia artificial transforman industrias...",
        )

        Text(
            text = "Ultimas noticias",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 20.dp, bottom = 20.dp)
        )



        LazyRow (
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(noticias) { idx ->
                Card(
                    modifier = Modifier
                        .width(300.dp)
                        .height(200.dp)
                        .padding(end = 10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = RecentCards
                    ),
                    shape = RoundedCornerShape(30.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Text(
                            text = idx,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier
                                .padding(bottom = 10.dp)
                        )
                        Text(
                            text = "febrero 08 - 2024",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier
                                .padding(bottom = 10.dp)
                        )
                    }
                }


            }
        }

        // Contenido principal

        Text(
            text = "Alrededor del mundo",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 20.dp, bottom = 20.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {

            items(noticias){ news ->
                Card (
                    modifier = Modifier
                        .weight(1f)
                        .height(220.dp)
                        .padding(10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.LightGray
                    ),
                    shape = RoundedCornerShape(25.dp)
                ) {
                    Column (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp),
                        verticalArrangement = Arrangement.Bottom
                    ){
                        Text(
                            text = news,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                        )
                    }
                }
            }
        }





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