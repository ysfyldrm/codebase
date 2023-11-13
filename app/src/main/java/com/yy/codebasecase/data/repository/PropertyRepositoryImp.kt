package com.yy.codebasecase.data.repository

import com.yy.codebasecase.domain.model.PropertyResponse
import com.yy.codebasecase.network.service.PropertyService
import com.yy.codebasecase.utils.Resource
import kotlinx.coroutines.flow.Flow

class PropertyRepositoryImpl(
    private val propertyService: PropertyService
) : BaseRepository(), PropertyRepository {

    override fun getProperties(): Flow<Resource<PropertyResponse>> = performNetworkOperation {
        propertyService.getProperties()
    }
}