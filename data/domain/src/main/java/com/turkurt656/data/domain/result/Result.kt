package com.turkurt656.data.domain.result

import kotlinx.coroutines.flow.Flow

sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    object Loading : Result<Nothing>()
    data class Error<T>(val exception: ResultException, val data: T?) : Result<Nothing>()
}

typealias FlowResult<T> = Flow<Result<T>>