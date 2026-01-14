package com.shivam.postra.di

import com.shivam.postra.data.remote.api.BlogApi
import com.shivam.postra.data.remote.api.BlogApiImpl
import com.shivam.postra.data.remote.client.HttpClientFactory
import com.shivam.postra.data.repository.BlogRepositoryImpl
import com.shivam.postra.domain.repository.BlogRepository
import com.shivam.postra.presentation.blog_list.BlogListViewModel
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val koinMainModule= module {


    single { HttpClientFactory.create(OkHttp) }
    singleOf(::BlogApiImpl).bind<BlogApi>()
    singleOf(::BlogRepositoryImpl).bind<BlogRepository>()
    viewModelOf(::BlogListViewModel)
}