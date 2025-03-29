package com.android.ibotestapptemplate.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.ibotestapptemplate.model.MovieResponse
import com.android.ibotestapptemplate.netWorks.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(private val repository: MyRepository) : ViewModel() {

    private var _itemList = MutableStateFlow<List<MovieResponse>>(emptyList())
    val itemList: StateFlow<List<MovieResponse>> = _itemList.asStateFlow()

    private var _isLoading = MutableStateFlow<Boolean>(false)
    val isLoading :StateFlow<Boolean> = _isLoading.asStateFlow()

    private var _error = MutableStateFlow<String?>(null)
    var error: StateFlow<String?> = _error.asStateFlow()


    init {
        fetchItems()
    }

    private fun fetchItems() {
        viewModelScope.launch {
          _isLoading.value = true
            _error.value = null
            try {
                var response = emptyList<MovieResponse>()
                withContext(Dispatchers.IO){
                 response = repository.getMovieDetails()?.movies!!
                }
                _itemList.value = response
            }catch (e:Exception){
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }

        }
    }
}