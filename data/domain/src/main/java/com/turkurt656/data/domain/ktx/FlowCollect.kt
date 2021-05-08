package com.turkurt656.data.domain.ktx

import com.turkurt656.data.domain.result.FlowResult
import com.turkurt656.data.domain.result.Result
import com.turkurt656.data.domain.result.ResultException
import kotlinx.coroutines.flow.collect


@Suppress("UNCHECKED_CAST")
suspend fun <T> FlowResult<T>.collect(
    onSuccess: (suspend (T) -> Unit)? = null,
    onError: (suspend (exception: ResultException, data: T?) -> Unit)? = null,
    onLoading: (suspend () -> Unit)? = null
) = collect {
    when (it) {
        is Result.Success -> onSuccess?.invoke(it.data)
        is Result.Loading -> onLoading?.invoke()
        is Result.Error<*> -> onError?.invoke(it.exception, it.data as? T?)
    }
}

suspend inline fun <T> FlowResult<T>.collectSuccess(
    crossinline onSuccess: ((data: T) -> Unit)
) = collect {
    when (it) {
        is Result.Success -> onSuccess(it.data)
        else -> {}
    }
}

@Suppress("UNCHECKED_CAST")
suspend inline fun <T> FlowResult<T>.collectError(
    crossinline onError: ((exception: ResultException, data: T?) -> Unit)
) = collect {
    when (it) {
        is Result.Error<*> -> onError(it.exception, it.data as? T?)
        else -> {}
    }
}

suspend inline fun <T> FlowResult<T>.collectLoading(
    crossinline onLoading: (() -> Unit)
) = collect {
    when (it) {
        is Result.Loading -> onLoading()
        else -> {}
    }
}