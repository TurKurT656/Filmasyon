package com.turkurt656.common.core.ktx

import androidx.lifecycle.liveData
import com.turkurt656.common.core.base.BaseViewModel
import com.turkurt656.data.domain.ktx.collect as collectDomain
import com.turkurt656.data.domain.result.FlowResult
import com.turkurt656.data.domain.result.Result
import com.turkurt656.data.domain.result.ResultException
import kotlinx.coroutines.flow.collect
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

@Suppress("UNCHECKED_CAST")
suspend fun <T> FlowResult<T>.collectOnLiveData(
    mutableLiveData: MutableLiveResult<T>,
    viewModel: BaseViewModel? = null,
    showAutoSnackbar: Boolean = true, // Shows an automatic snackbar when error occurs
    onSuccess: (suspend (T) -> Unit)? = null,
    onError: (suspend (exception: ResultException, data: T?) -> Unit)? = null,
    onLoading: (suspend () -> Unit)? = null,
) = collect {
    mutableLiveData.value = when (it) {
        is Result.Success -> {
            onSuccess?.invoke(it.data)
            Result.Success(it.data)
        }
        is Result.Error<*> -> {
            viewModel?.handleCommonExceptions(it.exception)
            if (showAutoSnackbar) viewModel?.showSnackBar(it.exception.message)
            onError?.invoke(it.exception, it.data as? T?)
            Result.Error(it.exception, it.data)
        }
        is Result.Loading -> {
            onLoading?.invoke()
            Result.Loading
        }
    }
}


fun <T> FlowResult<T>.asLiveData(
    viewModel: BaseViewModel? = null,
    showAutoSnackbar: Boolean = true, // Shows an automatic snackbar when error occurs
    context: CoroutineContext = EmptyCoroutineContext,
    timeoutInMs: Long = 5_000L
): LiveResult<T> = liveData(context, timeoutInMs) {
    collect {
        if (it is Result.Error<*>) {
            viewModel?.handleCommonExceptions(it.exception)
            if (showAutoSnackbar) viewModel?.showSnackBar(it.exception.message)
        }
        emit(it)
    }
}

suspend fun <T> FlowResult<T>.collect(
    viewModel: BaseViewModel? = null,
    showAutoSnackbar: Boolean = true, // Shows an automatic snackbar when error occurs
    onSuccess: (suspend (T) -> Unit)? = null,
    onError: (suspend (exception: ResultException, data: T?) -> Unit)? = null,
    onLoading: (suspend () -> Unit)? = null,
) = collectDomain(
    onSuccess = { onSuccess?.invoke(it) },
    onError = { exception, data ->
        viewModel?.handleCommonExceptions(exception)
        if (showAutoSnackbar) viewModel?.showSnackBar(exception.message)
        onError?.invoke(exception, data)
    },
    onLoading = { onLoading?.invoke() }
)