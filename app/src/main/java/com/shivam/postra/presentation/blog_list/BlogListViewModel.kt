package com.shivam.postra.presentation.blog_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shivam.postra.data.remote.api.BlogApiImpl
import com.shivam.postra.data.remote.client.HttpClientFactory
import com.shivam.postra.data.repository.BlogRepositoryImpl
import com.shivam.postra.domain.repository.BlogRepository
import io.ktor.client.engine.okhttp.OkHttp

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BlogListViewModel(
    private val blogRepository: BlogRepository
): ViewModel() {
    private val _state= MutableStateFlow(BlogListState())
    val state=_state
        .onStart {
            getAllBlogs()
        }
        .stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = _state.value
         )

//    private val httpClient= HttpClientFactory.create(OkHttp)
//    private val blogApi= BlogApiImpl(httpClient)
//
//    private val blogRepository= BlogRepositoryImpl(blogApi)
    private fun getAllBlogs(){
        viewModelScope.launch {
            val blogs=blogRepository.getAllBlogs()
            _state.update { it.copy(blogs=blogs) }
        }
    }


}
