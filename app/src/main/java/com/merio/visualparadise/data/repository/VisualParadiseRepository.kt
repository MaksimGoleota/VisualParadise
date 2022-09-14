package com.merio.visualparadise.data.repository

import com.merio.visualparadise.data.network.api.VisualParadiseApiClient
import com.merio.visualparadise.data.network.models.Image
import io.reactivex.Single
import javax.inject.Inject

class VisualParadiseRepository @Inject constructor(
    private val visualParadiseApiClient: VisualParadiseApiClient
) {

    fun getImages(q: String): Single<List<Image>> {
        return visualParadiseApiClient.searchImage(q)
            .map { response ->
                response.hits
            }
    }
}
