package com.shivam.postra.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class BlogDto (
    val id:Int,
    val title:String,
    val thumbnailUrl:String,
    val contentUrl:String
)