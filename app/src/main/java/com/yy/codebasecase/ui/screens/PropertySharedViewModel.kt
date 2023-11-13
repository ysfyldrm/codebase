package com.yy.codebasecase.ui.screens

import androidx.lifecycle.ViewModel
import com.yy.codebasecase.domain.model.Property
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * Seçilen ilanı farklı ekranlar arasında paylaşmak için kullanılan ViewModel.
 */
@HiltViewModel
class PropertySharedViewModel @Inject constructor() : ViewModel() {

    private val _navProp = MutableStateFlow(Property())
    val navProp: StateFlow<Property> = _navProp


    /**
     * Seçilen ilanı ayarlar ve UI'nin bu ilanı gözlemlemesini sağlar.
     * @param property Kullanıcı tarafından seçilen gayrimenkul ilanı.
     */
    internal fun setNavProp(property: Property) {
        _navProp.value = property
    }
}