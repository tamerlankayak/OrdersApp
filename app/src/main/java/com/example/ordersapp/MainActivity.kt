package com.example.ordersapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.toArgb
import com.example.ordersapp.core.presentation.Navigation
import com.example.ordersapp.ui.theme.OrdersAppTheme
import com.example.ordersapp.ui.theme.orange
import dagger.hilt.android.AndroidEntryPoint

//declaring hilt in main activity
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = orange.toArgb()
            window.navigationBarColor = orange.toArgb()
            OrdersAppTheme {
                Navigation()
            }
        }
    }
}

