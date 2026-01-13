package com.shivam.postra.data.mapper

import com.shivam.postra.data.remote.dto.BlogDto
import com.shivam.postra.domain.model.Blog

fun BlogDto.toBlog(): Blog {
    return Blog(
        id=id,
        title=title,
        thumbnailUrl=thumbnailUrl,
        content=null,
        contentUrl=contentUrl
    )
}
