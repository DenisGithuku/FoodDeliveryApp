package com.denisgithuku.fooddeliveryapp.ui.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }


    @Composable
    fun App() {
        HomeScreen()
    }




    @Preview(showBackground = true)
    @Composable
    fun HomeScreenPreview() {
        App()
    }
}