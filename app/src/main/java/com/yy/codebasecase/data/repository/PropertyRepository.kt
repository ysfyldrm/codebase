package com.yy.codebasecase.data.repository

import com.yy.codebasecase.domain.model.PropertyResponse
import com.yy.codebasecase.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * İlanları almak için repository interface'i.
 */
interface PropertyRepository {
    fun getProperties(): Flow<Resource<PropertyResponse>>
}