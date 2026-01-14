package com.shivam.postra

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.shivam.postra.presentation.blog_list.BlogListScreen
import com.shivam.postra.presentation.blog_list.BlogListViewModel
import com.shivam.postra.presentation.theme.PostraTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PostraTheme {
                val viewModel= koinViewModel<BlogListViewModel>()
                val state by  viewModel.state.collectAsStateWithLifecycle()
                Scaffold(modifier = Modifier.fillMaxSize(),
                    contentWindowInsets = WindowInsets(0)
                ) {
                    innerPadding ->

                    BlogListScreen(modifier = Modifier.padding(innerPadding),
                        state
                    )
                }
            }
        }
    }

}

