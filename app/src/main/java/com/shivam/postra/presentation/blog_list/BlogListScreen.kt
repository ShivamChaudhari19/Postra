package com.shivam.postra.presentation.blog_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.shivam.postra.domain.model.Blog
import com.shivam.postra.presentation.blog_list.component.BlogCard

@Composable
fun BlogListScreen(
    modifier: Modifier= Modifier,
    state: BlogListState
){

    Column(
        modifier=modifier.fillMaxSize()
    ) {
        BlogListTopBar(modifier)
        LazyVerticalGrid(
                columns = GridCells.Adaptive(300.dp),
                contentPadding = PaddingValues(15.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(state.blogs){ blog->
                BlogCard(modifier, blog = blog)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BlogListTopBar(
   modifier: Modifier
){
    TopAppBar(
        modifier=modifier,
        title = {Text(text="Postra Blogs")}
    )
}
@PreviewScreenSizes
@Composable
fun BlogListTopBarPreview(){
        val blog= listOf<Blog>(
            Blog(
                    id = 2,
                    title = "sl",
                    thumbnailUrl = "ldld",
                    contentUrl = "https://developer.android.com/static/codelabs/jetpack-compose-animation/img/jetpack_compose_logo_with_rocket.png",
                    content = null
            )
        )
    val state=BlogListState(
        isLoading = false,
        errorMessage = null,
        blog
    )
    BlogListScreen(modifier = Modifier, state=state );
}