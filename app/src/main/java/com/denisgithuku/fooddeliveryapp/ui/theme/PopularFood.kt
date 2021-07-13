package com.denisgithuku.fooddeliveryapp.ui.theme

import androidx.annotation.DrawableRes

data class PopularFood (
    @DrawableRes
    val foodImage: Int,
    val foodName: String,
    val foodPrice: String,
    val calories: Int
        )
