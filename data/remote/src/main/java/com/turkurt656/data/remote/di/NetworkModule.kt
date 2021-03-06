package com.turkurt656.data.remote.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.turkurt656.data.remote.getBaseUrl
import com.turkurt656.data.remote.interceptor.AuthorizationInterceptor
import com.turkurt656.library.core.di.GlobalQualifiers.IS_DEBUG
import com.turkurt656.library.core.di.RemoteQualifiers.AUTHORIZATION_INTERCEPTOR
import com.turkurt656.library.core.di.RemoteQualifiers.BASE_URL
import com.turkurt656.library.core.di.RemoteQualifiers.CONNECTION_TIMEOUT
import com.turkurt656.library.core.di.RemoteQualifiers.LOGGING_INTERCEPTOR
import com.turkurt656.library.core.di.RemoteQualifiers.READ_TIMEOUT
import com.turkurt656.library.core.di.RemoteQualifiers.WRITE_TIMEOUT
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

val networkModule = module {

    factory(BASE_URL) {
        getBaseUrl(get(IS_DEBUG))
    }

    factory(READ_TIMEOUT) { 30 * 1000L }
    factory(WRITE_TIMEOUT) { 10 * 1000L }
    factory(CONNECTION_TIMEOUT) { 10 * 1000L }

    factory<Interceptor>(LOGGING_INTERCEPTOR) {
        HttpLoggingInterceptor().apply {
            level = if (get(IS_DEBUG)) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        }
    }

    factory<Interceptor>(AUTHORIZATION_INTERCEPTOR) {
        AuthorizationInterceptor()
    }

    single {
        OkHttpClient.Builder()
            .readTimeout(get(READ_TIMEOUT), TimeUnit.MILLISECONDS)
            .writeTimeout(get(WRITE_TIMEOUT), TimeUnit.MILLISECONDS)
            .connectTimeout(get(CONNECTION_TIMEOUT), TimeUnit.MILLISECONDS)
            .addInterceptor(get(AUTHORIZATION_INTERCEPTOR))
            .addInterceptor(get(LOGGING_INTERCEPTOR))
            .build()
    }

    factory<Moshi> {
        Moshi.Builder()
            .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .client(get())
            .baseUrl(get<String>(BASE_URL))
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

}