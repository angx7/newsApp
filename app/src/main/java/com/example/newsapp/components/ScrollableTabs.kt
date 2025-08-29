@file:OptIn(ExperimentalFoundationApi::class)

package com.example.newsapp.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.screens.HomeScreen
import com.example.newsapp.ui.theme.NewsAppTheme
import kotlinx.coroutines.launch

@Composable
fun HeaderTabs(
    tabs: List<String>,
    modifier: Modifier = Modifier,
    initialSelected: Int = 0,
    underlineColor: Color = Color(0xFF6C5CE7),
    onTabSelected: (Int) -> Unit = {},

) {
    val density = LocalDensity.current
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()
    var selected by remember { mutableIntStateOf(initialSelected) }

    data class ItemBounds(val xPx: Float, val widthPx: Float)
    val bounds = remember { mutableStateMapOf<Int, ItemBounds>() }

    val indicatorX by animateDpAsState(
        targetValue = with(density) { (bounds[selected]?.xPx ?: 0f).toDp() },
        label = "indicatorX"
    )
    val indicatorW by animateDpAsState(
        targetValue = with(density) { (bounds[selected]?.widthPx ?: 0f).toDp() },
        label = "indicatorW"
    )

    // Reservamos altura suficiente para texto + subrayado
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(top = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        LazyRow(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(tabs.size, key = { it }) { index ->
                Box(
                    modifier = Modifier
                        .onGloballyPositioned { coords ->
                            val pos: Offset = coords.positionInParent()
                            bounds[index] = ItemBounds(
                                xPx = pos.x,
                                widthPx = coords.size.width.toFloat()
                            )
                        }
                        .clickable {
                            selected = index
                            onTabSelected(index)
                            scope.launch { listState.animateScrollToItem(index) }
                        }
                ) {
                    Text(
                        text = tabs[index],
                        fontSize = 25.sp,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = if (index == selected) FontWeight.Black else FontWeight.SemiBold
                        ),
                        color = if (index == selected) Color.Black else Color.LightGray
                    )
                }
            }
        }

        // Indicador dentro del Box, alineado al fondo
        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(horizontal = 16.dp)
                .offset(x = indicatorX + (indicatorW - 40.dp) / 2) // <- centramos el subrayado
                .width(50.dp) // <- ancho fijo
                .height(4.dp)
                .background(underlineColor, RoundedCornerShape(2.dp))
        )
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