package com.yy.codebasecase.domain.usecase

import com.yy.codebasecase.data.repository.PropertyRepository
import com.yy.codebasecase.domain.model.PropertyResponse
import com.yy.codebasecase.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPropertiesUseCase @Inject constructor(
    private val propertyRepository: PropertyRepository
) {
    operator fun invoke(): Flow<Resource<PropertyResponse>> {
        return propertyRepository.getProperties()
    }
}