package com.shivam.postra.data.remote.api

import com.shivam.postra.data.remote.dto.BlogDto

interface BlogApi {
    suspend fun getAllBlogs():List<BlogDto>
}