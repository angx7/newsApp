package com.example.newsapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import coil3.compose.AsyncImage
import com.example.newsapp.R
import com.example.newsapp.models.news
import com.example.newsapp.models.noticias
import com.example.newsapp.screens.HomeScreen
import com.example.newsapp.ui.theme.NewsAppTheme
import com.example.newsapp.ui.theme.background

@Composable
fun NewsGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
    ) {
//        items(news) { news ->
//            Card(
//                modifier = Modifier
//                    .height(220.dp)
//                    .padding(10.dp),
//                colors = CardDefaults.cardColors(
//                    containerColor = Color.LightGray
//                ),
//                shape = RoundedCornerShape(25.dp)
//            ) {
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(10.dp),
//                    verticalArrangement = Arrangement.Bottom
//                ) {
//                    Text(
//                        text = news.title,
//                        fontSize = 14.sp,
//                        fontWeight = FontWeight.Bold,
//                        color = Color.Black,
//                    )
//                }
//            }
//        }
        items(news) {
            Box(
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.Gray)
            ){
                AsyncImage(
                    model = it.imageUrl,
                    contentDescription = it.title,
                    modifier = Modifier
                        .fillMaxSize(),
                    placeholder = painterResource(R.drawable.ic_launcher_background),
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                        .background(Color.LightGray)
                        .padding(10.dp)

                ){
                    Text(
                        text = it.title
                    )
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
fun NewsGridPreview() {
    NewsAppTheme {
        NewsGrid()
    }
}