package com.example.newsapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import com.example.newsapp.ui.theme.RecentCards

@Composable
fun NoticiasPrincipales() {

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

}
