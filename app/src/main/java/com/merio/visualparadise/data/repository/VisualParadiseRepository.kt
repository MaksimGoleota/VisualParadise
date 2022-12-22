package com.merio.visualparadise.data.repository

import com.merio.visualparadise.data.mapper.VideoMapper
import com.merio.visualparadise.data.network.api.VisualParadiseApiClient
import com.merio.visualparadise.data.network.models.Image
import com.merio.visualparadise.data.network.models.Video
import io.reactivex.Single
import javax.inject.Inject

class VisualParadiseRepository @Inject constructor(
    private val visualParadiseApiClient: VisualParadiseApiClient,
    private val videoMapper: VideoMapper
) {

    fun getImages(q: String, perPage: Int = 200): Single<List<Image>> {
        return visualParadiseApiClient.searchImage(q, perPage)
            .map { response ->
                response.hits
            }
    }

    fun getVideos(q: String, perPage: Int = 200): Single<List<Video>> {
        return visualParadiseApiClient.searchVideo(q, perPage)
            .map { response ->
                videoMapper.map(response.hits)
            }
    }
}
