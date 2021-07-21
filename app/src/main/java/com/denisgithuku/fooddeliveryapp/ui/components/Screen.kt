package com.denisgithuku.fooddeliveryapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val id: String,
    val icon: ImageVector,
    val label: String,
) {
    object Home: Screen("home", Icons.Outlined.Home, "Home")
    object Discover: Screen("discover", Icons.Outlined.Search, "Discover")
    object Activity: Screen("activity", Icons.Outlined.Analytics, "Activity")
    object Cart :Screen("cart", Icons.Outlined.ShoppingCart, "Cart")

    object ScreenList {
        val screens = listOf(
            Home, Discover, Activity, Cart
        )
    }
}
