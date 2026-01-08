package com.shivam.postra

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.shivam.postra.presentation.theme.PostraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PostraTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//
//                }
            }
        }
    }
}
