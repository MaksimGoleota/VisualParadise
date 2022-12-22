package com.merio.visualparadise.data.network.api

import com.merio.visualparadise.data.network.models.ImageResponse
import com.merio.visualparadise.data.network.models.VideoResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface VisualParadiseApiClient {

    @GET("api/")
    fun searchImage(
        @Query("q") q: String,
        @Query("per_page") perPage: Int
    ): Single<ImageResponse>

    @GET("/api/videos/")
    fun searchVideo(
        @Query("q") q: String,
        @Query("per_page") perPage: Int
    ): Single<VideoResponse>
}
