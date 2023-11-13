package com.yy.codebasecase.ui.screens.propertylist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yy.codebasecase.domain.usecase.GetPropertiesUseCase
import com.yy.codebasecase.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PropertyListViewModel @Inject constructor(
    private val getPropertiesUseCase: GetPropertiesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(PropertyListState())
    val state: StateFlow<PropertyListState> = _state

    init {
        getProperties()
    }

    fun getProperties() {
        viewModelScope.launch {
            getPropertiesUseCase().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = PropertyListState(
                            properties = result.data.data,
                            filteredProperties = result.data.data
                        )
                    }

                    is Resource.Error -> {
                        _state.value = PropertyListState(
                            error = result.exception ?: "İlanlar getirilirken bir hata oluştu."
                        )
                    }

                    is Resource.Loading -> {
                        _state.value = PropertyListState(isLoading = true)
                    }
                }
            }
        }
    }

    fun onSearchQueryChanged(query: String) {
        _state.value = _state.value.copy(searchQuery = query)
        if (_state.value.properties.isNotEmpty())
            updateFilteredProperties()
    }

    private fun updateFilteredProperties() {
        _state.value = _state.value.copy(
            filteredProperties = if (_state.value.searchQuery.isBlank()) {
                _state.value.properties
            } else {
                _state.value.properties.filter {
                    it.category?.contains(_state.value.searchQuery, ignoreCase = true) == true
                }
            }
        )
    }
}