package com.yy.codebasecase.data.repository

import com.yy.codebasecase.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

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