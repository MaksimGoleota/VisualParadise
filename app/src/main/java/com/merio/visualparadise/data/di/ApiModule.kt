package com.merio.visualparadise.data.di

import com.merio.visualparadise.data.network.api.VisualParadiseApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    fun providesVisualParadiseApiClient(retrofit: Retrofit) = retrofit.create(
        VisualParadiseApiClient::class.java)
}
