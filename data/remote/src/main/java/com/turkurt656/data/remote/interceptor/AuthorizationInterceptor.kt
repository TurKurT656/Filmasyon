package com.turkurt656.data.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response

private const val AUTHORIZATION = "Authorization"
private const val THE_MOVIE_DB_ACCESS_TOKEN =
    "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2NmViYWRlMTVkNTBmODU3NjkxYjI3NTM3NzJhODEzMiIsInN1YiI6IjVjMDkwM2ZlOTI1MTQxNDc5ODAxMzM0MCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.Z7iZYsBEZ3fw6sLmO_1KMyQvN_EjlyM3-omxF_y_L5E"

class AuthorizationInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val newRequest = request
            .newBuilder()
            .addHeader(AUTHORIZATION, "Bearer $THE_MOVIE_DB_ACCESS_TOKEN")
            .build()

        return chain.proceed(newRequest)
    }
}