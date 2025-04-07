package com.example.tuan04_mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.tuan04_mvvm.navigation.SetupNavigation
import com.example.tuan04_mvvm.ui.theme.Tuan04_MVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tuan04_MVVMTheme {
                val navController = rememberNavController()
                SetupNavigation(navController = navController)
            }
        }
    }
}