package com.nikhilproject.presentation.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nikhilproject.domain.model.University
import com.nikhilproject.presentation.databinding.HomeCarouselItemBinding

class CarouselAdapter(
    private val context: Context,
    private val carouselData: List<University>
) : RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        val binding = HomeCarouselItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return CarouselViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        val item = carouselData[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = carouselData.size

    class CarouselViewHolder(private val binding: HomeCarouselItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: University) {
            binding.imageView.setImageResource(item.coverImage)
        }
    }
}
