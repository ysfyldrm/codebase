package com.yy.codebasecase.data.repository

import com.yy.codebasecase.domain.model.PropertyResponse
import com.yy.codebasecase.utils.Resource
import kotlinx.coroutines.flow.Flow

interface PropertyRepository {
    fun getProperties(): Flow<Resource<PropertyResponse>>
}