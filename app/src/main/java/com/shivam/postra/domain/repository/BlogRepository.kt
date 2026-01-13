package com.shivam.postra.domain.repository

import com.shivam.postra.domain.model.Blog

interface BlogRepository {
    suspend fun getAllBlogs():List<Blog>
}