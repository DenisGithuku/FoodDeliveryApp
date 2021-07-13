package com.denisgithuku.fooddeliveryapp.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.denisgithuku.fooddeliveryapp.R
import com.denisgithuku.fooddeliveryapp.ui.theme.FoodDeliveryAppTheme
import com.denisgithuku.fooddeliveryapp.ui.theme.PopularFood

@Composable
fun HomeScreen() {
    FoodDeliveryAppTheme {
        Surface(color = MaterialTheme.colors.primary) {
            Scaffold(
                topBar = {
                    CustomTopAppBar()
                }
            ) { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(horizontal = 20.dp)
                ) {
                    QuerySection()
                    FoodTypeGridSection()
                    GuideSection()
                    PopularFoodSection()
                }
            }
        }
    }
}


@Composable
fun CustomTopAppBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 15.dp)
    ) {
        Column {
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(50.dp)) {
                Icon(painter = painterResource(id = R.drawable.grid), tint = Color.Black.copy(alpha = .6f), contentDescription = null)
            }
        }

        Column {
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(50.dp)) {
                Icon(painter = painterResource(id = R.drawable.search), tint = Color.Black.copy(alpha = .6f), contentDescription = null)
            }
        }
    }
}

@Composable
fun QuerySection() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.7f)
        ) {
            Text(
                text = "What would you like to eat?",
                style = MaterialTheme.typography.h1
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FoodTypeGridSection() {
    val frequentFoodList = listOf(
        FoodItem(R.drawable.hotdog, "Hotdog"),
        FoodItem(R.drawable.fries, "Fries"),
        FoodItem(R.drawable.fruits, "Fruits"),
        FoodItem(R.drawable.rice, "Rice")
    )

    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        items(frequentFoodList.size) { frequentFoodItem ->
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .clickable { }
                    .fillMaxWidth(),
                elevation = 4.dp,
                shape = RoundedCornerShape(8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(vertical = 6.dp, horizontal = 4.dp)
                        .fillMaxWidth()
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .clip(shape = RoundedCornerShape(12.dp))
                                .size(60.dp)
                        ) {
                            Image(
                                painter = painterResource(id = frequentFoodList[frequentFoodItem].foodImage),
                                contentDescription = null,
                                contentScale = ContentScale.Fit
                            )
                        }
                    }
                    Column(modifier = Modifier.padding(10.dp)) {
                        Text(
                            text = frequentFoodList[frequentFoodItem].foodName,
                            color = Color.Black.copy(alpha = .7f),
                            style = MaterialTheme.typography.h2
                        )
                    }
                }
            }
        }

    }
}


@Composable
fun GuideSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(vertical = 12.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = "Popular",
                style = MaterialTheme.typography.body1,
                color = Color.Black.copy(alpha = .5f)
            )
        }
        Column {
            Text(
                text = "See all",
                style = MaterialTheme.typography.caption,
                color = Color.Black.copy(alpha = .4f)
            )
        }
    }
}

@Composable
fun PopularFoodSection() {
    val foodList = listOf(
        PopularFood(R.drawable.meal1, "Fried Shrimps", "81.4$", 44),
        PopularFood(R.drawable.meal2, "Fried Rice", "112$", 56),
        PopularFood(R.drawable.meal3, "Scrambled eggs", "44.5$", 67),
        PopularFood(R.drawable.meal4, "Tuna", "44.5$", 46),
        PopularFood(R.drawable.meal5, "Fries", "53.2$", 84),
        PopularFood(R.drawable.meal6, "Salad", "41$", 112),
        PopularFood(R.drawable.meal7, "Steak", "56.9$", 78),
        PopularFood(R.drawable.meal8, "Fried Steak", "70.75$", 90)
    )

    val listState = rememberLazyListState()

    LazyRow(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(10.dp),
        state = listState
    ) {
        items(foodList.size) { foodItem ->
            Card(modifier = Modifier
                .padding(end = 4.dp),
            shape = RoundedCornerShape(18.dp)) {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        Text(
                            text = foodList[foodItem].foodName,
                            style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.SemiBold)
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier.fillMaxWidth()) {
                            Column(
                                modifier = Modifier
                                    .size(100.dp)
                                    .padding(8.dp)
                                    .clip(CircleShape)
                                    .fillMaxWidth()
                            ) {
                                Image(
                                    painter = painterResource(id = foodList[foodItem].foodImage),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop
                                )
                            }
                    }
                    Row(modifier = Modifier.padding(vertical = 12.dp, horizontal = 10.dp)) {
                        Column {
                            Icon(
                                imageVector = Icons.Default.Info,
                                tint = MaterialTheme.colors.onSurface,
                                contentDescription = null
                            )
                        }
                        Column(modifier = Modifier.padding(start = 8.dp)) {
                            Text(
                                text = "${foodList[foodItem].calories} Calories",
                                color = Color.Yellow.copy(alpha = .8f),
                                style = MaterialTheme.typography.caption
                            )
                        }
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .padding(vertical = 12.dp, horizontal = 10.dp)
                            .fillMaxWidth()
                    ) {
                        Column {
                            Text(
                                text = foodList[foodItem].foodPrice,
                                color = Color.Black,
                                style = MaterialTheme.typography.h2.copy(fontWeight = FontWeight.SemiBold)
                            )
                        }
                        Column {
                            Box(modifier = Modifier
                                .clip(RoundedCornerShape(14.dp))
                                .clickable { }
                                .background(color = MaterialTheme.colors.onSurface)
                                .padding(8.dp)
                                .size(20.dp)
                            ) {
                                    Icon(
                                        imageVector = Icons.Outlined.Add,
                                        contentDescription = null,
                                        tint = Color.White
                                    )
                            }
                        }
                    }
                }
            }
        }
    }

}