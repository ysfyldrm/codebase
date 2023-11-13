package com.yy.codebasecase.ui.screens.propertydetail

import androidx.lifecycle.ViewModel
import com.yy.codebasecase.domain.model.Property
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class PropertyDetailViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(PropertyDetailState())
    val state: StateFlow<PropertyDetailState> = _state

    fun setProperty(property: Property) {
        _state.value = _state.value.copy(property = property)
    }
}
