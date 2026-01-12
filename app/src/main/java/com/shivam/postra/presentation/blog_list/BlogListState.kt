package com.shivam.postra.presentation.blog_list

import com.shivam.postra.domain.model.Blog

data class BlogListState(
    val isLoading: Boolean=false,
    val errorMessage:String?=null,
    val blogs:List<Blog> = emptyList()
)