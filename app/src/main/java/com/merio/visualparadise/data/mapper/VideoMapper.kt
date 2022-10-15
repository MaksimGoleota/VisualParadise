package com.merio.visualparadise.data.mapper

import com.merio.visualparadise.data.network.models.Video
import com.merio.visualparadise.data.network.models.VideoDTO
import javax.inject.Inject

class VideoMapper @Inject constructor() {
    fun map(videoDTOs: List<VideoDTO>): List<Video> {
        return videoDTOs.map { videoDTO ->
            Video(
                id = videoDTO.id,
                pageURL = videoDTO.pageURL,
                type = videoDTO.type,
                tags = videoDTO.tags,
                duration = videoDTO.duration,
                previewPicture = mapPreviewPicture(videoDTO.picture_id),
                videos = videoDTO.videos,
                views = videoDTO.views,
                downloads = videoDTO.downloads,
                likes = videoDTO.likes,
                comments = videoDTO.comments,
                user_id = videoDTO.user_id,
                user = videoDTO.user,
                userImageURL = videoDTO.userImageURL
            )
        }
    }

    private fun mapPreviewPicture(picture_id: String): String {
        return "https://i.vimeocdn.com/video/${picture_id}_1920x1080.jpg" // Use string resource https://stackoverflow.com/questions/3656371/is-it-possible-to-have-placeholders-in-strings-xml-for-runtime-values
    }
}


