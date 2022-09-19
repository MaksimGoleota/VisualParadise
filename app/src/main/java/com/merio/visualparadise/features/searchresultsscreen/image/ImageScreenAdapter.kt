package com.merio.visualparadise.features.searchresultsscreen.image

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.merio.visualparadise.data.network.models.Image
import com.merio.visualparadise.databinding.ImageLayoutBinding
import com.squareup.picasso.Picasso

class ImageScreenAdapter(
    private val itemClicks: (String, Int, Int, Int) -> Unit
) : RecyclerView.Adapter<ImageScreenAdapter.ImageViewHolder>() {

    class ImageViewHolder(val binding: ImageLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    private val imageList: MutableList<Image> = mutableListOf()

    fun setData(image: List<Image>) {
        imageList.clear()
        imageList.addAll(image)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ImageLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        with(holder) {
            val currentItem = imageList[position]

            Picasso.get()
                .load(currentItem.webformatURL)
                .resize(250, 400)
                .centerCrop()
                .onlyScaleDown()
                .into(binding.image)

            holder.itemView.setOnClickListener {
                itemClicks(
                    currentItem.largeImageURL,
                    currentItem.views,
                    currentItem.downloads,
                    currentItem.likes
                )
            }
        }
    }

    override fun getItemCount() = imageList.size

}
