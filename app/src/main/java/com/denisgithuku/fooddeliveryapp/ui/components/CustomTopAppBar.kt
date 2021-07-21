package com.denisgithuku.fooddeliveryapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Grid4x4
import androidx.compose.material.icons.outlined.GridView
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.denisgithuku.fooddeliveryapp.R

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
                Icon(
                    painterResource(id = R.drawable.grid),
                    tint = Color.Black.copy(alpha = .6f),
                    contentDescription = null
                )
            }
        }

        Column {
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(50.dp)) {
                Icon(
                    painterResource(id = R.drawable.search),
                    tint = Color.Black.copy(alpha = .6f),
                    contentDescription = null
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    CustomTopAppBar()
}

