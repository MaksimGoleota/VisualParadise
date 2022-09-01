package com.merio.visualparadise.data.di

import com.merio.visualparadise.data.network.api.VisualParadiseApiClient
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiModule {

    @Provides
    fun providesVisualParadiseApiClient(retrofit: Retrofit) = retrofit.create(
        VisualParadiseApiClient::class.java)
}
