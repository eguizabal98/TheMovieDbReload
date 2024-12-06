package com.eem.remotedatasource.di

import com.eem.remotedatasource.api.Api
import com.eem.remotedatasource.source.ApiConfig
import com.google.gson.GsonBuilder
import com.google.gson.Strictness
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun getBaseClient(): OkHttpClient = OkHttpClient
        .Builder()
        .followRedirects(false)
        .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
        .build()

    @Provides
    @Singleton
    fun getApi(client: OkHttpClient, gsonBuilder: GsonBuilder): Retrofit {
        val gson = gsonBuilder.setStrictness(Strictness.LENIENT).create()

        return Retrofit
            .Builder()
            .baseUrl(ApiConfig.BASE_URL)
            .callFactory { client.newCall(it) }
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    fun provideApi(retrofit: Retrofit): Api = retrofit.create(Api::class.java)

    private const val TIMEOUT = 60L
}
