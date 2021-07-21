package com.denisgithuku.fooddeliveryapp.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CustomBottomNavigationBar(
    currentScreenId: String,
    onItemSelected: (Screen) -> Unit
) {

    val screens = Screen.ScreenList.screens

    Row(modifier = Modifier
        .background(MaterialTheme.colors.background)
        .padding(8.dp)
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        
        screens.forEach { screen ->  
            CustomBottomBarItem(item = screen, isSelected = screen.id == currentScreenId) {
                onItemSelected(screen)
            }
        }
    }

}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CustomBottomBarItem(
    item: Screen,
    isSelected: Boolean,
    onClicked: () -> Unit
) {

    val backgroundColor = if (isSelected) MaterialTheme.colors.onSurface .copy(alpha = .3f) else Color.Transparent
    val contentColor = if (isSelected) MaterialTheme.colors.onSurface else MaterialTheme.colors.onBackground

    Box(modifier = Modifier
        .clip(CircleShape)
        .background(backgroundColor)
        .clickable(onClick = onClicked)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            Icon(imageVector = item.icon, tint = contentColor, contentDescription = null)

            AnimatedVisibility(visible = isSelected) {
                Text(text = item.label, color = contentColor, style = TextStyle(fontSize = 16.sp))
            }

        }
    }

}