package com.merio.visualparadise.data.network.api

import com.merio.visualparadise.data.network.models.ImageResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface VisualParadiseApiClient {

    @GET("api/")
    fun searchImage(
        @Query("q") q: String
    ): Single<ImageResponse>
}
