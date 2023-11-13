package com.yy.codebasecase.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.yy.codebasecase.ui.navigation.NavGraph
import com.yy.codebasecase.ui.theme.CodebasecaseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            CodebasecaseTheme {
                val navController = rememberNavController()
                NavGraph(navController)
            }
        }
    }
}
