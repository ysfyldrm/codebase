package com.yy.codebasecase.data.repository

import com.yy.codebasecase.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

/**
 * Temel repository sınıfı, tüm repository sınıflarının kalıtım alabileceği genel işlevsellikleri sağlar.
 * Bu sınıf, network çağrılarının nasıl yapılacağını ve sonuçlarının nasıl işleneceğini tanımlar.
 */
abstract class BaseRepository {

    protected fun <T> performNetworkOperation(networkCall: suspend () -> T): Flow<Resource<T>> =
        flow {
            emit(Resource.Loading)
            val response = networkCall.invoke()
            emit(Resource.Success(response))
        }.catch { e ->
            emit(Resource.Error(e.message ?: "Beklenmedik Bir Hata Oluştu."))
        }
}