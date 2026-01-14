package com.shivam.postra.data.remote.api

import com.shivam.postra.data.Constant
import com.shivam.postra.data.remote.dto.BlogDto
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class BlogApiImpl(
    private val httpClient: HttpClient
): BlogApi{

    override suspend fun getAllBlogs(): List<BlogDto> {
     return try {
         val response=httpClient.get(urlString = Constant.GITHUB_URL).bodyAsText()
         kotlinx.serialization.json.Json.decodeFromString(response)
     }catch (e: Exception){
         e.printStackTrace()
         throw RuntimeException("Failed to Fetch data")
     }
    }
}