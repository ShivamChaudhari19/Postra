package com.shivam.postra.presentation.blog_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BlogListScreen(
    modifier: Modifier= Modifier
){
    Column(
        modifier=modifier.fillMaxSize()
    ) {
        BlogListTopBar(modifier)
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
@Preview(showBackground =true)
@Composable
fun BlogListTopBarPreview(){
    BlogListScreen();
}