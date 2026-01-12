package com.shivam.postra

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shivam.postra.domain.model.Blog
import com.shivam.postra.presentation.blog_list.BlogListScreen
import com.shivam.postra.presentation.blog_list.BlogListState
import com.shivam.postra.presentation.theme.PostraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PostraTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    contentWindowInsets = WindowInsets(0)
                ) {
                    innerPadding ->
                    BlogListScreen(modifier = Modifier.padding(innerPadding),
                        BlogListState(
                            false,"massage",listOf(
                                Blog(
                                    1,
                                    "this is the title of the blog two",
                                    "kludged",
                                    "https://developer.android.com/static/codelabs/jetpack-compose-animation/img/jetpack_compose_logo_with_rocket.png",
                                    "this is content string"
                                ),
                                Blog(
                                    2,
                                    "this is the title of the blog 2 on the blog card",
                                    "kludged",
                                    "https://developer.android.com/static/codelabs/jetpack-compose-animation/img/jetpack_compose_logo_with_rocket.png",
                                    "this is content string"
                                )
                            )
                        )
                    )
                }
            }
        }
    }
}

