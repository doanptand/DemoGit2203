package com.ddona.wallpaper.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ddona.wallpaper.R
import com.ddona.wallpaper.databinding.ItemWallpaperBinding
import com.ddona.wallpaper.model.Wallpaper

class WallpaperAdapter(
    private val wallpapers: List<Wallpaper>,
    private val callback: WallpaperItemClickListener
) : RecyclerView.Adapter<WallpaperAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemWallpaperBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(wallpaper: Wallpaper) {
            binding.tvImageName.text = wallpaper.name
            binding.tvImageAuthor.text = wallpaper.author
            Glide.with(binding.imgWallpaper)
                .load(wallpaper.imageId)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(binding.imgWallpaper)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemWallpaperBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        wallpapers[position].let {
            holder.bind(it)
        }
        holder.itemView.setOnClickListener {
            //báo cho wallpaper fragment vị trí(position) vừa được click
            callback.onWallpaperItemClick(position)
        }
    }

    override fun getItemCount(): Int = wallpapers.size

}