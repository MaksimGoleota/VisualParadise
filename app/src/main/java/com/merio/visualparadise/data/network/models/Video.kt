package com.merio.visualparadise.data.network.models

data class VideoResponse(
    val total: Int,
    val totalHits: Int,
    val hits: List<VideoDTO>
)

data class VideoDTO(
    val id: Int,
    val pageURL: String,
    val type: String,
    val tags: String,
    val duration: Int,
    val picture_id: String,
    val videos: VideoTypes,
    val views: Int,
    val downloads: Int,
    val likes: Int,
    val comments: Int,
    val user_id: Int,
    val user: String,
    val userImageURL: String
)

data class Video(
    val id: Int,
    val pageURL: String,
    val type: String,
    val tags: String,
    val duration: Int,
    val previewPicture: String,
    val videos: VideoTypes,
    val views: Int,
    val downloads: Int,
    val likes: Int,
    val comments: Int,
    val user_id: Int,
    val user: String,
    val userImageURL: String
)

data class VideoTypes(
    val large: VideoQ,
    val medium: VideoQ,
    val small: VideoQ,
    val tiny: VideoQ
)

data class VideoQ(
    val url: String,
    val width: Int,
    val height: Int,
    val size: Int
)



