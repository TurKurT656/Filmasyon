package com.turkurt656.data.domainimpl.exception

import com.turkurt656.data.domain.result.ResultException
import com.turkurt656.data.remote.exception.RemoteException
import com.turkurt656.data.remote.exception.RemoteException.*

fun RemoteException.toResultException(): ResultException =
    when(this) {
        is HttpClientException -> ResultException.HttpClientException(message, code)
        is HttpServerException -> ResultException.HttpServerException(message, code)
        is NetworkException -> ResultException.NetworkException(message)
        is ApiException -> ResultException.ApiException(message, code)
    }