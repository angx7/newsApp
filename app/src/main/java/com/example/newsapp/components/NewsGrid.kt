package com.example.newsapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.models.noticias

@Composable
fun NewsGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(noticias) { news ->
            Card(
                modifier = Modifier
                    .height(220.dp)
                    .padding(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.LightGray
                ),
                shape = RoundedCornerShape(25.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
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
