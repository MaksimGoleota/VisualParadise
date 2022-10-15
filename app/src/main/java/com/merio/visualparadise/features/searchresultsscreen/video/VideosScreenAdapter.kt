package com.merio.visualparadise.features.searchresultsscreen.video

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.merio.visualparadise.data.network.models.Video
import com.merio.visualparadise.databinding.VideoLayoutBinding
import com.squareup.picasso.Picasso

class VideosScreenAdapter(
    private val itemClicks: (String, Int, Int, Int) -> Unit
): RecyclerView.Adapter<VideosScreenAdapter.VideoViewHolder>() {

    class VideoViewHolder(val binding: VideoLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    private val videoList: MutableList<Video> = mutableListOf()

    fun setData(video: List<Video>) {
        videoList.clear()
        videoList.addAll(video)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val binding = VideoLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return VideosScreenAdapter.VideoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        with(holder) {
            val currentItem = videoList[position]

            Picasso.get()
                .load(currentItem.previewPicture)
                .resize(250, 400)
                .centerCrop()
                .onlyScaleDown()
                .into(binding.imageViewForPreviewVideo)

            holder.itemView.setOnClickListener {
                itemClicks(
                    currentItem.videos.tiny.toString(),
                    currentItem.views,
                    currentItem.downloads,
                    currentItem.likes
                )
            }
        }
    }

    override fun getItemCount() = videoList.size
}
