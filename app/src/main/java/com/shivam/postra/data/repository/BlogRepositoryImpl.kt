package com.shivam.postra.data.repository

import com.shivam.postra.data.mapper.toBlog
import com.shivam.postra.data.remote.api.BlogApi
import com.shivam.postra.domain.model.Blog
import com.shivam.postra.domain.repository.BlogRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class BlogRepositoryImpl(
    private val blogApi: BlogApi,
): BlogRepository {
    override suspend fun getAllBlogs(): List<Blog> {
        return withContext(Dispatchers.IO) {
            blogApi.getAllBlogs().map { blogDto -> blogDto.toBlog() }
        }
    }
}
