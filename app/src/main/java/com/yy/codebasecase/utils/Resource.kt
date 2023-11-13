package com.yy.codebasecase.utils

/**
 * Bir veri akışının durumunu temsil eden sealed class.
 * Başarılı, hata ve yükleniyor durumlarını kapsar.
 */
sealed class Resource<out T> {
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val exception: String?) : Resource<Nothing>()
    data object Loading : Resource<Nothing>()
}